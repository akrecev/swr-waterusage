package ru.rosniivh.swr.service.impl;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.rosniivh.swr.domain.catalog.asv.AsvAcceptorEntity;
import ru.rosniivh.swr.dto.report.AsvAcceptorSearchResponse;
import ru.rosniivh.swr.filter.AsvAcceptorFilter;
import ru.rosniivh.swr.repository.asv.AsvAcceptorRepository;
import ru.rosniivh.swr.service.AsvAcceptorService;

@RequiredArgsConstructor
@Service
public class AsvAcceptorServiceImpl implements AsvAcceptorService {

    private final AsvAcceptorRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public List<AsvAcceptorSearchResponse> getByFilter(AsvAcceptorFilter filter, Integer limit) {
        List<AsvAcceptorEntity> entitys = repository.findAll(filter, limit);
        List<AsvAcceptorSearchResponse> result = new ArrayList<>();
        for (AsvAcceptorEntity acceptor : entitys) {
            AsvAcceptorSearchResponse resp = new AsvAcceptorSearchResponse();
            resp.setUid(acceptor.getId())
                    .setFio(acceptor.getFio())
                    .setPosition(acceptor.getPosition())
                    .setBasis(acceptor.getBasis())
                    .setNotes(acceptor.getNotes())
                    .setAuthOrgId(
                            (acceptor.getAuth() != null) ? acceptor.getAuth().getId() : null)
                    .setAuthOrgName(
                            (acceptor.getAuth() != null) ? acceptor.getAuth().getFullName() : "");
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
