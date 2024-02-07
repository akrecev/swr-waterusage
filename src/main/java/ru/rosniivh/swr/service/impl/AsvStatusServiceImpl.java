package ru.rosniivh.swr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rosniivh.swr.domain.AsvStatusEntity;
import ru.rosniivh.swr.repository.AsvStatusRepository;
import ru.rosniivh.swr.service.AsvStatusService;

@Service
public class AsvStatusServiceImpl implements AsvStatusService {

    @Autowired
    private AsvStatusRepository repository;

    @Override
    public AsvStatusEntity getById(Integer id) {
        return repository.findById(id).get();
    }
}
