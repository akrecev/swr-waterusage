package ru.rosniivh.swr.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rosniivh.swr.domain.object.asv.AsvAdmOperationEntity;
import ru.rosniivh.swr.dto.report.FilterReport;
import ru.rosniivh.swr.repository.AsvAdmOperationRepository;
import ru.rosniivh.swr.service.AsvAdmOperationService;

@Service
public class AsvAdmOperationServiceImpl implements AsvAdmOperationService {

    @Autowired
    private AsvAdmOperationRepository repository;

    @Override
    public TreeMap<Integer, String> getOpersByIds(List<Integer> ids) {
        TreeMap<Integer, String> result = new TreeMap<>();
        List<AsvAdmOperationEntity> admOperations = repository.getOperByIds(ids);
        List<FilterReport> filterReports = new ArrayList<>();
        for (AsvAdmOperationEntity oper : admOperations) {
            filterReports.add(new FilterReport(
                    oper.getId(),
                    oper.getDocNum(),
                    oper.getDocDate(),
                    oper.getOperType().getName()));
        }
        for (FilterReport r : filterReports) {
            result.put(r.getUid(), r.getCode() + " №" + r.getName());
        }
        return result;
    }
}
