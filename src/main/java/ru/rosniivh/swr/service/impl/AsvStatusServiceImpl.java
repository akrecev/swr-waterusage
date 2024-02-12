package ru.rosniivh.swr.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rosniivh.swr.domain.catalog.asv.AsvStatusEntity;
import ru.rosniivh.swr.repository.asv.AsvStatusRepository;
import ru.rosniivh.swr.service.AsvStatusService;

@Service
@RequiredArgsConstructor
public class AsvStatusServiceImpl implements AsvStatusService {
    private final AsvStatusRepository repository;

    @Override
    public AsvStatusEntity getById(Integer id) {
        return repository.findById(id).get();
    }
}
