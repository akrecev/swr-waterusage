package ru.rosniivh.swr.service;

import java.util.List;
import ru.rosniivh.swr.dto.filter.UidCodeNameFilter;

public interface AsvImportOkved22016Service {

    List<UidCodeNameFilter> getOkvedList(String term);
}
