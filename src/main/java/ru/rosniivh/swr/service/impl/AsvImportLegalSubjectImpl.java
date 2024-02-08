package ru.rosniivh.swr.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rosniivh.swr.domain.object.asv.AsvImportLegalSubjectEntity;
import ru.rosniivh.swr.dto.object.asv.AsvImportLegalSubjectDto;
import ru.rosniivh.swr.filter.AsvImportLegalSubjectFilter;
import ru.rosniivh.swr.repository.AsvImportLegalSubjectRepository;
import ru.rosniivh.swr.service.AsvImportLegalSubjectService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AsvImportLegalSubjectImpl implements AsvImportLegalSubjectService {

    @Autowired
    private AsvImportLegalSubjectRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AsvImportLegalSubjectDto> getByFilter(AsvImportLegalSubjectFilter filter) {
        List<AsvImportLegalSubjectEntity> entitys = repository.findAll(filter);
        return entitys.stream()
                .map(entity -> modelMapper.map(entity, AsvImportLegalSubjectDto.class)).collect(Collectors.toList());
    }

    @Override
    public AsvImportLegalSubjectEntity getById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<AsvImportLegalSubjectDto> getByFullName(String fullName) {
        return repository.getByFullName(fullName).stream()
                .map(entity -> modelMapper.map(entity, AsvImportLegalSubjectDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<AsvImportLegalSubjectDto> getByInn(String inn) {
        return repository.getByInn(inn).stream()
                .map(entity -> modelMapper.map(entity, AsvImportLegalSubjectDto.class)).collect(Collectors.toList());
    }
}
