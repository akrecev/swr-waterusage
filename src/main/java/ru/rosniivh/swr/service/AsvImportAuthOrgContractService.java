package ru.rosniivh.swr.service;

import ru.rosniivh.swr.dto.report.FilterReport;

import java.util.List;

public interface AsvImportAuthOrgContractService {
    List<FilterReport> getRfSubjectsWithOrgsByBvu(Integer bvuId);
}
