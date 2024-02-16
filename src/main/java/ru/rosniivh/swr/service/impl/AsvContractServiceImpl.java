package ru.rosniivh.swr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rosniivh.swr.domain.object.asv.AsvContractEntity;
import ru.rosniivh.swr.repository.AsvContractRepository;
import ru.rosniivh.swr.service.AsvContractService;

import java.util.List;
import java.util.TreeMap;

@Service
public class AsvContractServiceImpl implements AsvContractService {

    @Autowired
    private AsvContractRepository repository;

    @Override
    public TreeMap<Integer, String> getContractsByIds(List<Integer> ids) {
        TreeMap<Integer, String> result = new TreeMap<>();
        List<AsvContractEntity> contracts = repository.getContractByIds(ids);
        for(AsvContractEntity con : contracts) {
            result.put(con.getId(), con.getRegNumber());
        }
        return result;
    }
}
