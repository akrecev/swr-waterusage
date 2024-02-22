package ru.rosniivh.swr.service;

import java.util.List;
import java.util.TreeMap;
import ru.rosniivh.swr.dto.report.FilterReport;

public interface AsvAdmOperationService {
    TreeMap<Integer, String> getOpersByIds(List<Integer> ids);

    FilterReport getById(Integer id);
}
