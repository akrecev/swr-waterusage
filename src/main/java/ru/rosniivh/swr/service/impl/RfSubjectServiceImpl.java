package ru.rosniivh.swr.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import ru.rosniivh.swr.domain.catalog.FederalDistrictEntity;
import ru.rosniivh.swr.domain.catalog.RfSubjectEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportAuthOrgContractEntity;
import ru.rosniivh.swr.domain.object.BasinDistrictEntity;
import ru.rosniivh.swr.domain.object.HeParcelEntity;
import ru.rosniivh.swr.domain.object.RiverBasinEntity;
import ru.rosniivh.swr.domain.object.SubbasinEntity;
import ru.rosniivh.swr.dto.filter.BasinFilterForUser;
import ru.rosniivh.swr.dto.report.BasinFilterForUserReport;
import ru.rosniivh.swr.repository.asv.AsvImportAuthOrgContractRepository;
import ru.rosniivh.swr.service.AbstractForService;
import ru.rosniivh.swr.service.RfSubjectService;
import ru.rosniivh.swr.util.ForServiceUtil;

@Service
public class RfSubjectServiceImpl extends AbstractForService implements RfSubjectService {

    private final AsvImportAuthOrgContractRepository organRep;

    @PersistenceContext
    private EntityManager entityManager;

    public RfSubjectServiceImpl(AsvImportAuthOrgContractRepository organRep) {
        super(organRep);
        this.organRep = organRep;
    }

    @Override
    public BasinFilterForUserReport getBasinFilterForUser() {
        // Необходимо добавить метод получения уполномоченного органа у текущего юзера
        Integer organUid = 269;

        Optional<AsvImportAuthOrgContractEntity> organ = organRep.findById(organUid);
        CriteriaBuilder cbRf = entityManager.getCriteriaBuilder();
        CriteriaQuery<BasinFilterForUser> cqRf = cbRf.createQuery(BasinFilterForUser.class);
        Root<RfSubjectEntity> rootRf = cqRf.from(RfSubjectEntity.class);
        Join<RfSubjectEntity, FederalDistrictEntity> fdJoin = rootRf.join("fd", JoinType.LEFT);
        cqRf.select(cbRf.construct(
                BasinFilterForUser.class,
                rootRf.get("constNumber"),
                rootRf.get("name"),
                rootRf.get("id"),
                fdJoin.get("name"),
                fdJoin.get("id")));

        CriteriaBuilder cbHep = entityManager.getCriteriaBuilder();
        CriteriaQuery<BasinFilterForUser> cqHep = cbHep.createQuery(BasinFilterForUser.class);
        Root<HeParcelEntity> rootHep = cqHep.from(HeParcelEntity.class);
        Join<HeParcelEntity, SubbasinEntity> subJoin = rootHep.join("subbasin", JoinType.LEFT);
        Join<SubbasinEntity, RiverBasinEntity> riverJoin = subJoin.join("riverBasin", JoinType.LEFT);
        Join<RiverBasinEntity, BasinDistrictEntity> basinJoin = riverJoin.join("basinDistrict", JoinType.LEFT);
        Join<HeParcelEntity, RfSubjectEntity> rfJoin = rootHep.join("rfSubjects", JoinType.LEFT);
        cqHep.select(cbHep.construct(
                BasinFilterForUser.class,
                rootHep.get("id"),
                subJoin.get("id"),
                riverJoin.get("id"),
                basinJoin.get("id"),
                rootHep.get("name"),
                subJoin.get("name"),
                riverJoin.get("name"),
                basinJoin.get("name"),
                rootHep.get("code"),
                subJoin.get("code"),
                riverJoin.get("code"),
                basinJoin.get("code")));
        if (organ.isPresent() && organ.get().getOrgType().getId() != 10) {
            List<Integer> orgIds = getAuthOrgHierarchyIds(organ.orElseThrow().getId());
            List<Integer> rfSubjects = new ArrayList<>();
            for (Integer id : orgIds) {
                Integer idRf =
                        organRep.findById(id).orElseThrow().getRfSubjectNew().getId();
                if (ForServiceUtil.findArray(rfSubjects, idRf) == -1) {
                    rfSubjects.add(idRf);
                }
            }
            cqHep.where(buildIn(cbHep, rfJoin.get("id"), rfSubjects));
            cqRf.where(
                    cbRf.or(buildIn(cbRf, rootRf.get("id"), rfSubjects), cbRf.equal(rootRf.get("constNumber"), "00")));
        }
        List<BasinFilterForUser> resultHep = entityManager.createQuery(cqHep).getResultList();
        List<BasinFilterForUser> resultRf = entityManager.createQuery(cqRf).getResultList();
        return new BasinFilterForUserReport(resultHep, resultRf);
    }
}
