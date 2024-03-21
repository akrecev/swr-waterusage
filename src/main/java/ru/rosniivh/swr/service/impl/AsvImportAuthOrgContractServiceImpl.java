package ru.rosniivh.swr.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import ru.rosniivh.swr.domain.catalog.RfSubjectEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportAuthOrgContractEntity;
import ru.rosniivh.swr.dto.report.AuthOrgFilterReport;
import ru.rosniivh.swr.dto.report.FilterReport;
import ru.rosniivh.swr.repository.RfSubjectRepository;
import ru.rosniivh.swr.repository.asv.AsvImportAuthOrgContractRepository;
import ru.rosniivh.swr.service.AbstractForService;
import ru.rosniivh.swr.service.AsvImportAuthOrgContractService;

@Service
public class AsvImportAuthOrgContractServiceImpl extends AbstractForService implements AsvImportAuthOrgContractService {

    private final AsvImportAuthOrgContractRepository repository;
    private final RfSubjectRepository rfsRepository;

    public AsvImportAuthOrgContractServiceImpl(
            AsvImportAuthOrgContractRepository repository, RfSubjectRepository rfsRepository) {
        super(repository);
        this.repository = repository;
        this.rfsRepository = rfsRepository;
    }

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

    @Override
    public List<FilterReport> getRfSubjectsByOrg(List<Integer> orgIds) {
        List<Integer> organIds = new ArrayList<>();
        orgIds.forEach(orgId -> {
            organIds.addAll(getAuthOrgHierarchyIds(orgId));
        });
        List<AsvImportAuthOrgContractEntity> organs = repository.findOrganByIds(organIds);
        Set<FilterReport> filterReports = organs.stream()
                .map(organ -> {
                    RfSubjectEntity rfs = organ.getRfSubjectNew();
                    FilterReport fr = new FilterReport();
                    fr.setUid(rfs.getId()).setName(rfs.getName()).setCode(rfs.getConstNumber());
                    return fr;
                })
                .collect(Collectors.toSet());
        return filterReports.stream().toList();
    }
}
