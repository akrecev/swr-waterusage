package ru.rosniivh.swr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rosniivh.swr.domain.catalog.RfSubjectEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportAuthOrgContractEntity;
import ru.rosniivh.swr.dto.report.FilterReport;
import ru.rosniivh.swr.repository.AsvImportAuthOrgContractRepository;
import ru.rosniivh.swr.repository.RfSubjectRepository;
import ru.rosniivh.swr.service.AsvImportAuthOrgContractService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AsvImportAuthOrgContractServiceImpl implements AsvImportAuthOrgContractService {

    @Autowired
    private AsvImportAuthOrgContractRepository repository;

    @Autowired
    private RfSubjectRepository rfsRepository;

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
        //Не понятно зачем нужен этот код,
        //т.к. rfs с id 82 и так попадает в filterReports
        return filterReports;
    }
}
