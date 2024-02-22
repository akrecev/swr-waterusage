package ru.rosniivh.swr.service;

import java.util.List;

import ru.rosniivh.swr.dto.report.AuthOrgFilterReport;
import ru.rosniivh.swr.dto.report.FilterReport;

public interface AsvImportAuthOrgContractService {
    List<FilterReport> getRfSubjectsWithOrgsByBvu(Integer bvuId);

    List<AuthOrgFilterReport> paymentHierarchy(Integer id);
}
