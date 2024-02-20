package ru.rosniivh.swr.service;

import java.util.List;
import ru.rosniivh.swr.dto.report.AsvDocumentResponse;

public interface AsvDocumentService {
    List<AsvDocumentResponse> getAsvDocuments(String inn, String kpp);
}
