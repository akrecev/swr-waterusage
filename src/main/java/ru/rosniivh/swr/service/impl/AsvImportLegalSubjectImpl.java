package ru.rosniivh.swr.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportAuthOrgContractEntity;
import ru.rosniivh.swr.domain.object.asv.AsvImportLegalSubjectEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportLegalSubjectDto;
import ru.rosniivh.swr.dto.report.AsvImportResponse;
import ru.rosniivh.swr.filter.AsvImportLegalSubjectFilter;
import ru.rosniivh.swr.repository.AsvImportLegalSubjectRepository;
import ru.rosniivh.swr.service.AsvImportLegalSubjectService;

@Service
public class AsvImportLegalSubjectImpl implements AsvImportLegalSubjectService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private AsvImportLegalSubjectRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AsvImportLegalSubjectDto> getByFilter(AsvImportLegalSubjectFilter filter) {
        List<AsvImportLegalSubjectEntity> entitys = repository.findAll(filter);
        return entitys.stream()
                .map(entity -> modelMapper.map(entity, AsvImportLegalSubjectDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AsvImportLegalSubjectDto> getByType(
            Integer type,
            String name,
            String ogrn,
            String okpo,
            String postAddress,
            String legalAddress,
            String okato,
            String inn) {
        if (type.equals(1)) {
            return repository.getByTypeOne(name, ogrn, okpo, postAddress, legalAddress, okato).stream()
                    .map(entity -> modelMapper.map(entity, AsvImportLegalSubjectDto.class))
                    .collect(Collectors.toList());
        } else {
            return repository.getByTypeTwo(inn, name).stream()
                    .map(entity -> modelMapper.map(entity, AsvImportLegalSubjectDto.class))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public List<AsvImportResponse> getLegalSubject(AsvImportLegalSubjectFilter filter) {
        List<AsvImportLegalSubjectEntity> legalSubject = repository.findAll(filter);
        List<AsvImportResponse> asvImportResponses = new ArrayList<>();
        for (AsvImportLegalSubjectEntity ls : legalSubject) {
            Integer organId = ls.getAsvImportAuthOrgContractEntities()
                    .stream().findFirst().map(AsvImportAuthOrgContractEntity::getId).orElse(0);

            AsvImportResponse response = new AsvImportResponse();
            response.setId(ls.getId())
                    .setName(ls.getFullName())
                    .setInn(ls.getInn())
                    .setKpp(ls.getKpp())
                    .setDescription(ls.getDescription())
                    .setAuthOrg(organId);

            asvImportResponses.add(response);
        }
        //Доделать
        return asvImportResponses;
    }

//    @Override
//    public List<AsvImportResponse> getLegalSubjectOld(/**String name, String inn, String kpp, Integer top, Integer any, Boolean getAll**/String inn, String kpp) {
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery<AsvImportResponse> query = builder.createQuery(AsvImportResponse.class);
//        Root<AsvImportLegalSubjectEntity> root = query.from(AsvImportLegalSubjectEntity.class);
//        Join<AsvImportLegalSubjectEntity, AsvImportAuthOrgContractEntity> joinOrgan = root.join("asvImportAuthOrgContractEntities", JoinType.LEFT);
//        List<Predicate> allPredicates = new ArrayList<>();
//        allPredicates.add(builder.like(root.get("inn"), inn));
//        allPredicates.add(builder.like(root.get("kpp"), kpp));
//        query.select(
//                builder.construct(AsvImportResponse.class,
//                        root.get("id"),
//                        root.get("fullName"),
//                        root.get("inn"),
//                        root.get("kpp"),
//                        joinOrgan.get("id"))
//        );
//        query.where(builder.and(allPredicates.toArray(new Predicate[]{})));
//        Query emQuery = em.createQuery(query);
//        List<AsvImportResponse> responses = emQuery.getResultList();
//        responses.get(0);
//        return responses;
//    }
}
