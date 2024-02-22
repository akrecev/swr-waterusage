package ru.rosniivh.swr.service.impl;

import java.util.*;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rosniivh.swr.domain.catalog.asv.AsvLegalSubjectTypeEntity;
import ru.rosniivh.swr.domain.object.asv.AsvDocumentEntity;
import ru.rosniivh.swr.domain.object.asv.AsvImportLegalSubjectEntity;
import ru.rosniivh.swr.dto.report.AsvDocumentResponse;
import ru.rosniivh.swr.repository.AsvDocumentRepository;
import ru.rosniivh.swr.service.AsvDocumentService;

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
}
