package ru.rosniivh.swr.service;

import java.util.List;
import java.util.TreeMap;

public interface AsvAdmOperationService {
    TreeMap<Integer, String> getOpersByIds(List<Integer> ids);
}
