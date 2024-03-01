package ru.rosniivh.swr.service.impl;

import java.util.List;
import java.util.TreeMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rosniivh.swr.domain.object.asv.AsvContractEntity;
import ru.rosniivh.swr.repository.asv.AsvContractRepository;
import ru.rosniivh.swr.service.AsvContractService;

@RequiredArgsConstructor
@Service
public class AsvContractServiceImpl implements AsvContractService {

    private final AsvContractRepository repository;

    @Override
    public TreeMap<Integer, String> getContractsByIds(List<Integer> ids) {
        TreeMap<Integer, String> result = new TreeMap<>();
        List<AsvContractEntity> contracts = repository.getContractByIds(ids);
        for (AsvContractEntity con : contracts) {
            result.put(con.getId(), con.getRegNumber());
        }
        return result;
    }
}
