package ru.rosniivh.swr.service;

import ru.rosniivh.swr.dto.report.FilterReport;

import java.util.List;
import java.util.TreeMap;

public interface AsvAdmOperationService {
    TreeMap<Integer, String> getOpersByIds(List<Integer> ids);

    FilterReport getById(Integer id);
}
