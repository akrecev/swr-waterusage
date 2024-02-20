package ru.rosniivh.swr.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportOkved22016Entity;
import ru.rosniivh.swr.dto.filter.UidCodeNameFilter;
import ru.rosniivh.swr.repository.asv.AsvImportOkved22016Repository;
import ru.rosniivh.swr.service.AsvImportOkved22016Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AsvImportOkved22016ServiceImpl implements AsvImportOkved22016Service {

    private final AsvImportOkved22016Repository repository;

    @Override
    public List<UidCodeNameFilter> getOkvedList(String term) {
        List<AsvImportOkved22016Entity> entity;

        switch (term) {
            case null, "" -> entity = repository.findAll();
            default -> entity = repository.findAllByCodeOrName(term);
        }

        return entity.stream().map(e -> new UidCodeNameFilter(
               e.getId(),
               e.getName(),
               e.getCode()
       )).collect(Collectors.toList());
    }
}
