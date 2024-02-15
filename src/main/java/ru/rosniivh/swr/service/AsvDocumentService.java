package ru.rosniivh.swr.service;

import ru.rosniivh.swr.dto.report.AsvDocumentResponse;

import java.util.List;

public interface AsvDocumentService {
    List<AsvDocumentResponse> getAsvDocuments(String inn, String kpp);
}
