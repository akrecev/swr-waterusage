package ru.rosniivh.swr.service;

import java.util.List;
import java.util.Map;
import ru.rosniivh.swr.dto.report.AsvDocumentResponse;
import ru.rosniivh.swr.dto.report.CountDocFAWR;

public interface AsvDocumentService {
    List<AsvDocumentResponse> getAsvDocuments(String inn, String kpp);

    Map<String, String> getDocumentWuOkved(Integer uid);

    List<CountDocFAWR> getCountDocFAWR(Integer year, Integer quarter);
}
