package ru.rosniivh.swr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rosniivh.swr.domain.object.asv.AsvDocumentEntity;
import ru.rosniivh.swr.dto.report.AsvDocumentResponse;
import ru.rosniivh.swr.repository.AsvDocumentRepository;
import ru.rosniivh.swr.service.AsvDocumentService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AsvDocumentServiceImpl implements AsvDocumentService {

    @Autowired
    private AsvDocumentRepository repository;

    @Override
    public List<AsvDocumentResponse> getAsvDocuments(String inn, String kpp) {
        List<AsvDocumentEntity> documents = repository.getDocByInnAndKpp(inn, kpp);
        List<AsvDocumentResponse> result = new ArrayList<>();
        for(AsvDocumentEntity doc : documents) {
            result.add(new AsvDocumentResponse(doc.getRegNumber(), doc.getRegDate(), doc.getDocType().getId()));
        }
        return result;
    }
}
