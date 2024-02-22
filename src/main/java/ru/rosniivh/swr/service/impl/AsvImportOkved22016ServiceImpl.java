package ru.rosniivh.swr.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportOkved22016Entity;
import ru.rosniivh.swr.dto.filter.UidCodeNameFilter;
import ru.rosniivh.swr.repository.asv.AsvImportOkved22016Repository;
import ru.rosniivh.swr.service.AsvImportOkved22016Service;

@RequiredArgsConstructor
@Service
public class AsvImportOkved22016ServiceImpl implements AsvImportOkved22016Service {

    private final AsvImportOkved22016Repository repository;

    @Override
    public List<UidCodeNameFilter> getOkvedList(String term) {
        List<AsvImportOkved22016Entity> entity;

        if ("".equals(term) || term == null) {
            entity = repository.findAll();
        } else {
            entity = repository.findAllByCodeOrName(term);
        }

        return entity.stream()
                .map(e -> new UidCodeNameFilter(e.getId(), e.getName(), e.getCode()))
                .collect(Collectors.toList());
    }
}
