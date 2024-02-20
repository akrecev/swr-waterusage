package ru.rosniivh.swr.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rosniivh.swr.dto.report.AsvDocumentResponse;
import ru.rosniivh.swr.repository.AsvDocumentRepository;
import ru.rosniivh.swr.service.AsvDocumentService;

@Service
public class AsvDocumentServiceImpl implements AsvDocumentService {

    @Autowired
    private AsvDocumentRepository repository;

    @Override
    public List<AsvDocumentResponse> getAsvDocuments(String inn, String kpp) {
        //        List<AsvDocumentEntity> documents = repository.getDocByInnAndKpp(inn, kpp);
        //        List<AsvDocumentResponse> result = new ArrayList<>();
        //        for(AsvDocumentEntity doc : documents) {
        //            result.add(new AsvDocumentResponse(doc.getRegNumber(), doc.getRegDate(), doc.getDocTypeId()));
        //        }
        //        return result;
        return null;
    }
}
