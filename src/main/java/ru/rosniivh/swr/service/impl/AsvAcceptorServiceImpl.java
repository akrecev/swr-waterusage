package ru.rosniivh.swr.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rosniivh.swr.domain.object.asv.AsvAcceptorEntity;
import ru.rosniivh.swr.filter.AsvAcceptorFilter;
import ru.rosniivh.swr.repository.AsvAcceptorRepository;
import ru.rosniivh.swr.domain.catalog.asv.AsvAcceptorDto;
import ru.rosniivh.swr.service.AsvAcceptorService;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AsvAcceptorServiceImpl implements AsvAcceptorService {

    @Autowired
    private AsvAcceptorRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AsvAcceptorDto> getByFilter(AsvAcceptorFilter filter, Integer limit) {
        List<AsvAcceptorEntity> entitys = repository.findAll(filter,limit);
        return entitys.stream()
                .map(entity -> modelMapper.map(entity, AsvAcceptorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AsvAcceptorEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public AsvAcceptorEntity getById() {
        return repository.findById(1).orElseThrow();
    }
}
