package ru.rosniivh.swr.service;

import java.util.List;
import java.util.TreeMap;

public interface AsvContractService {
    TreeMap<Integer, String> getContractsByIds(List<Integer> ids);
}
