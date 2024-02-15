package ru.rosniivh.swr.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rosniivh.swr.domain.catalog.asv.AsvAcceptorEntity;
import ru.rosniivh.swr.filter.AsvAcceptorFilter;
import ru.rosniivh.swr.repository.AsvAcceptorRepository;
import ru.rosniivh.swr.dto.catalog.asv.AsvAcceptorDto;
import ru.rosniivh.swr.service.AsvAcceptorService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AsvAcceptorServiceImpl implements AsvAcceptorService {

    @Autowired
    private AsvAcceptorRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AsvAcceptorSearchResponse> getByFilter(AsvAcceptorFilter filter, Integer limit) {
        List<AsvAcceptorEntity> entitys = repository.findAll(filter,limit);
        List<AsvAcceptorSearchResponse> result = new ArrayList<>();
        for (AsvAcceptorEntity acceptor : entitys) {
            AsvAcceptorSearchResponse resp = new AsvAcceptorSearchResponse();
            resp.setUid(acceptor.getId())
                    .setFio(acceptor.getFio())
                    .setPosition(acceptor.getPosition())
                    .setBasis(acceptor.getBasis())
                    .setNotes(acceptor.getNotes())
                    .setAuthOrgId( (acceptor.getAuth() != null) ? acceptor.getAuth().getId() :null)
                    .setAuthOrgName((acceptor.getAuth() != null) ? acceptor.getAuth().getFullname() : "");
            result.add(resp);
        }

        return result;
//        return entitys.stream()
//               // .map(entity -> modelMapper.map(entity, AsvAcceptorDto.class))
//                .map(entity -> modelMapper.map(entity, new AsvAcceptorSearchResponse(
//                        entity.getId(),
//                        entity.getFio(),
//                        entity.getPosition(),
//                        entity.getBasis(),
//                        entity.getNotes(),
//                        entity.getAuth().getId(),
//                        entity.getAuth().getFullname()
//                )))
//                .collect(Collectors.toList());
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
