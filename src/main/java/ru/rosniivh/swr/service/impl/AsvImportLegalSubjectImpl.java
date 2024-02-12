package ru.rosniivh.swr.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rosniivh.swr.domain.object.asv.AsvImportLegalSubjectEntity;
import ru.rosniivh.swr.dto.object.asv.AsvImportLegalSubjectDto;
import ru.rosniivh.swr.filter.AsvImportLegalSubjectFilter;
import ru.rosniivh.swr.repository.asv.AsvImportLegalSubjectRepository;
import ru.rosniivh.swr.service.AsvImportLegalSubjectService;

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
                .map(entity -> modelMapper.map(entity, AsvImportLegalSubjectDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AsvImportLegalSubjectEntity getById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<AsvImportLegalSubjectDto> getByFullName(String fullName) {
        return repository.getByFullName(fullName).stream()
                .map(entity -> modelMapper.map(entity, AsvImportLegalSubjectDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AsvImportLegalSubjectDto> getByInn(String inn) {
        return repository.getByInn(inn).stream()
                .map(entity -> modelMapper.map(entity, AsvImportLegalSubjectDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AsvImportLegalSubjectDto> getByType(
            Integer type,
            String name,
            String ogrn,
            String okpo,
            String postAddress,
            String legalAddress,
            String okato,
            String inn) {
        if (type.equals(1)) {
            return repository.getByTypeOne(name, ogrn, okpo, postAddress, legalAddress, okato).stream()
                    .map(entity -> modelMapper.map(entity, AsvImportLegalSubjectDto.class))
                    .collect(Collectors.toList());
        } else {
            return repository.getByTypeTwo(inn, name).stream()
                    .map(entity -> modelMapper.map(entity, AsvImportLegalSubjectDto.class))
                    .collect(Collectors.toList());
        }
    }
}
