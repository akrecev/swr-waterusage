package ru.rosniivh.swr.service;

import ru.rosniivh.swr.domain.catalog.asv.AsvAcceptorEntity;
import ru.rosniivh.swr.dto.catalog.asv.AsvAcceptorDto;
import ru.rosniivh.swr.filter.AsvAcceptorFilter;

import java.util.List;

public interface AsvAcceptorService {
    List<AsvAcceptorDto> getByFilter (AsvAcceptorFilter filter,Integer limit);

    List<AsvAcceptorEntity> getAll();

    AsvAcceptorEntity getById();

}
