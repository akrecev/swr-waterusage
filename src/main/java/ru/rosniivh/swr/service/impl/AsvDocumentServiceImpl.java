package ru.rosniivh.swr.service.impl;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rosniivh.swr.domain.catalog.RfSubjectEntity;
import ru.rosniivh.swr.domain.catalog.asv.*;
import ru.rosniivh.swr.domain.object.asv.AsvDocumentEntity;
import ru.rosniivh.swr.domain.object.asv.AsvImportLegalSubjectEntity;
import ru.rosniivh.swr.dto.report.AsvDocumentResponse;
import ru.rosniivh.swr.dto.report.CountDocFAWR;
import ru.rosniivh.swr.repository.asv.AsvDocumentRepository;
import ru.rosniivh.swr.service.AsvDocumentService;
import ru.rosniivh.swr.util.ForServiceUtil;

@RequiredArgsConstructor
@Service
public class AsvDocumentServiceImpl implements AsvDocumentService {

    private final AsvDocumentRepository repository;

    @Override
    public List<AsvDocumentResponse> getAsvDocuments(String inn, String kpp) {
        List<AsvDocumentEntity> documents = repository.getDocByInnAndKpp(inn, kpp);
        return documents.stream()
                .map(doc -> new AsvDocumentResponse(
                        doc.getRegNumber(), doc.getRegDate(), doc.getDocType().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, String> getDocumentWuOkved(Integer uid) {
        if (uid == null) {
            return Collections.emptyMap();
        }

        Map<String, String> result = new HashMap<>();

        Optional<AsvDocumentEntity> document = repository.findById(uid);
        if (document.isPresent()) {
            Optional<AsvImportLegalSubjectEntity> legalSubject = document.map(AsvDocumentEntity::getWaterUser);
            Optional<AsvLegalSubjectTypeEntity> lsType = legalSubject.map(AsvImportLegalSubjectEntity::getSubjectType);
            result.put("wuUid", String.valueOf(legalSubject.map(AsvImportLegalSubjectEntity::getId).orElseThrow()));
            result.put("wuType", String.valueOf(lsType.map(AsvLegalSubjectTypeEntity::getId).orElseThrow()));
        }
        return result;
    }

    @Override
    public List<CountDocFAWR> getCountDocFAWR(Integer year, Integer quarter) {
        LocalDate start = ForServiceUtil.startQuarterDate(year, quarter);
        LocalDate end = ForServiceUtil.endQuarterDate(year, quarter);
        List<AsvDocumentEntity> documents = repository.getDocByRange(start, end);
        return documents.stream().map(doc -> {
            AsvStatusEntity status = doc.getStatus();
            AsvImportAuthOrgContractEntity organ = doc.getOrgan();
            AsvAuthOrgTypeEntity orgType = organ.getOrgType();
            AsvRegTypeEntity regType = doc.getDocType();
            RfSubjectEntity docRfs = doc.getRfSubject();
            RfSubjectEntity orgRfs = organ.getRfSubjectNew();

            CountDocFAWR docFAWR = new CountDocFAWR();
            docFAWR.setUid(Objects.requireNonNull(doc.getId()));
            docFAWR.setRegNum(Objects.requireNonNull(doc.getRegNumber()));
            docFAWR.setSingDate(Objects.requireNonNull(doc.getSignDate()));
            docFAWR.setDocType(Objects.requireNonNull(regType.getId()));
            docFAWR.setStatus(Objects.requireNonNull(status.getId()));
            docFAWR.setUidOrg(Objects.requireNonNull(organ.getId()));
            docFAWR.setNameOrg(Objects.requireNonNull(organ.getDescription()));
            docFAWR.setOrgType(Objects.requireNonNull(orgType.getId()));

            if (docRfs != null) {
                docFAWR.setUidRfDoc(docRfs.getId());
                docFAWR.setNameRfDoc(docRfs.getName());
            }

            if (orgRfs != null) {
                docFAWR.setUidRfOrg(orgRfs.getId());
                docFAWR.setNameRfOrg(orgRfs.getName());
            }
            return docFAWR;
        }).collect(Collectors.toList());
    }
}
