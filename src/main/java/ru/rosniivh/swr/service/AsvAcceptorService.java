package ru.rosniivh.swr.service;

import java.util.List;
import ru.rosniivh.swr.domain.catalog.asv.AsvAcceptorEntity;
import ru.rosniivh.swr.dto.report.AsvAcceptorSearchResponse;
import ru.rosniivh.swr.filter.AsvAcceptorFilter;

public interface AsvAcceptorService {
    List<AsvAcceptorSearchResponse> getByFilter(AsvAcceptorFilter filter, Integer limit);

    List<AsvAcceptorEntity> getAll();

    AsvAcceptorEntity getById();
}
