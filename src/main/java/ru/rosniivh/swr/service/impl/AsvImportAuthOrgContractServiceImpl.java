package ru.rosniivh.swr.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportAuthOrgContractEntity;
import ru.rosniivh.swr.dto.report.AuthOrgFilterReport;
import ru.rosniivh.swr.dto.report.FilterReport;
import ru.rosniivh.swr.repository.RfSubjectRepository;
import ru.rosniivh.swr.repository.asv.AsvImportAuthOrgContractRepository;
import ru.rosniivh.swr.service.AsvImportAuthOrgContractService;

@RequiredArgsConstructor
@Service
public class AsvImportAuthOrgContractServiceImpl implements AsvImportAuthOrgContractService {

    private final AsvImportAuthOrgContractRepository repository;
    private final RfSubjectRepository rfsRepository;

    @Override
    public List<FilterReport> getRfSubjectsWithOrgsByBvu(Integer bvuId) {
        List<AsvImportAuthOrgContractEntity> authOrgans = repository.getRfsWithOrganByBvuId(bvuId);
        List<FilterReport> filterReports = new ArrayList<>();
        for (AsvImportAuthOrgContractEntity organ : authOrgans) {
            FilterReport fr = new FilterReport();
            fr.setUid(organ.getRfSubjectNew().getId())
                    .setName(organ.getRfSubjectNew().getName())
                    .setCode(organ.getRfSubjectNew().getConstNumber());
            filterReports.add(fr);
        }
        //        if (bvuId.equals(347)) {
        //            RfSubjectEntity rfs = rfsRepository.findById(82).orElseThrow();
        //            FilterReport filterReport = new FilterReport();
        //            filterReport.setUid(rfs.getId())
        //                        .setName(rfs.getName())
        //                        .setCode(rfs.getConstNumber());
        //            filterReports.add(filterReport);
        //        }
        // Непонятно зачем нужен этот код,
        // т.к. rfs с id 82 и так попадает в filterReports
        return filterReports;
    }

    @Override
    public List<AuthOrgFilterReport> paymentHierarchy(Integer id) {
        List<Integer> orgs = getAuthOrgHierarchyIds(id);
        List<AuthOrgFilterReport> authOrgs = new ArrayList<>();
        orgs.forEach(orgId -> {
            AsvImportAuthOrgContractEntity organ = repository.findById(orgId).orElseThrow();
            Integer orgTypeId = organ.getOrgType().getId();
            if (orgTypeId != 8 && orgTypeId != 9) {
                authOrgs.add(new AuthOrgFilterReport(organ.getId(), organ.getFullName(), organ.getCode()));
            }
        });
        return authOrgs;
    }

    private List<Integer> getAuthOrgHierarchyIds(Integer id) {
        List<Integer> list = new ArrayList<>();
        List<Integer> todo = new ArrayList<>();
        list.add(id);
        todo.add(id);
        while(todo.size()>0){
            Integer i = todo.remove(0);
            List<Integer> curlist = repository.findByParentId(i).stream()
                    .map(AsvImportAuthOrgContractEntity::getId).toList();
            list.addAll(curlist);
            todo.addAll(curlist);
        }
        return list;
    }
}
