package ru.rosniivh.swr.service;

import ru.rosniivh.swr.dto.filter.UidCodeNameFilter;

import java.util.List;

public interface AsvImportOkved22016Service {

    List<UidCodeNameFilter> getOkvedList(String term);
}
