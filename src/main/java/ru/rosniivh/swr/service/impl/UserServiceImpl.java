package ru.rosniivh.swr.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.rosniivh.swr.domain.catalog.BasinWaterManagementBoardEntity;
import ru.rosniivh.swr.domain.catalog.RfSubjectEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportAuthOrgContractEntity;
import ru.rosniivh.swr.exception.DataNotFoundException;
import ru.rosniivh.swr.model.security.SwrUser;
import ru.rosniivh.swr.repository.RfSubjectRepository;
import ru.rosniivh.swr.repository.asv.AsvImportAuthOrgContractRepository;
import ru.rosniivh.swr.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final AsvImportAuthOrgContractRepository asvImportAuthOrgContractRepository;
    private final RfSubjectRepository rfSubjectRepository;

    private static final int FEDERAL_DISTRICT_SEA = 9;
    private static final String CONS_NUMBER_SEA = "00";

    @Override
    public List<RfSubjectEntity> getUserRfs() {
        AbstractAuthenticationToken auth =
                (AbstractAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        SwrUser principal = (SwrUser) auth.getPrincipal();
        BasinWaterManagementBoardEntity basinWaterManagementBoard =
                principal.getUser().getBwm();
        List<RfSubjectEntity> rfSubjects = new ArrayList<>();
        AsvImportAuthOrgContractEntity org = principal.getUser().getAuthOrg();
        if (org != null) {
            List<RfSubjectEntity> rfSubjectList = this.getAuthOrgHierarchyRfs(org.getId());
            rfSubjects.addAll(rfSubjectList);
            List<RfSubjectEntity> seas = rfSubjectRepository.findByFdId(FEDERAL_DISTRICT_SEA);
            rfSubjects.addAll(seas);
        } else if (basinWaterManagementBoard != null) {
            basinWaterManagementBoard
                    .getWaterResourcesDivisions()
                    .forEach(wrd -> rfSubjects.addAll(wrd.getRfSubjects()));
        }
        if (rfSubjects.isEmpty()) {
            rfSubjects.addAll(rfSubjectRepository.findAll());
        }

        List<RfSubjectEntity> rfSubjectSeaList = rfSubjectRepository.findByConstNumber(CONS_NUMBER_SEA);
        rfSubjects.addAll(rfSubjectSeaList);

        return new HashSet<>(rfSubjects)
                .stream().toList().stream()
                        .sorted(Comparator.comparing(RfSubjectEntity::getConstNumber)
                                .thenComparing(RfSubjectEntity::getName))
                        .collect(Collectors.toList());
    }

    private List<RfSubjectEntity> getAuthOrgHierarchyRfs(Integer id) {
        List<Integer> list = this.getAuthOrgHierarchyIds(id);
        return list.stream()
                .filter((a) -> asvImportAuthOrgContractRepository
                                .findById(a)
                                .orElseThrow(
                                        () -> new DataNotFoundException("AsvImportAuthOrgContractEntity not found"))
                                .getRfSubjectNew()
                        != null)
                .map((a) -> asvImportAuthOrgContractRepository
                        .findById(a)
                        .orElseThrow(() -> new DataNotFoundException("AsvImportAuthOrgContractEntity not found"))
                        .getRfSubjectNew())
                .distinct()
                .collect(Collectors.toList());
    }

    private List<Integer> getAuthOrgHierarchyIds(Integer id) {
        if (asvImportAuthOrgContractRepository
                        .findById(id)
                        .orElseThrow(() -> new DataNotFoundException("AsvImportAuthOrgContractEntity not found"))
                        .getOrgType()
                        .getId()
                == 10) {
            return asvImportAuthOrgContractRepository.findAll().stream()
                    .map(AsvImportAuthOrgContractEntity::getId)
                    .collect(Collectors.toList());
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> todo = new ArrayList<>();
        list.add(id);
        todo.add(id);
        while (todo.size() > 0) {
            Integer i = todo.remove(0);
            List<Integer> curlist = asvImportAuthOrgContractRepository.findByParentId(i).stream()
                    .map(AsvImportAuthOrgContractEntity::getId)
                    .toList();
            list.addAll(curlist);
            todo.addAll(curlist);
        }
        return list;
    }
}
