package ru.rosniivh.swr.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import ru.rosniivh.swr.dto.object.asv.AsvImportLegalSubjectDto;
import ru.rosniivh.swr.dto.report.AsvImportResponse;
import ru.rosniivh.swr.filter.AsvImportLegalSubjectFilter;

public interface AsvImportLegalSubjectService {

    List<AsvImportLegalSubjectDto> getByFilter(AsvImportLegalSubjectFilter filter);

    List<AsvImportLegalSubjectDto> getByType(
            Integer type,
            String name,
            String ogrn,
            String okpo,
            String postAddress,
            String legalAddress,
            String okato,
            String inn);

    List<AsvImportResponse> getLegalSubject(AsvImportLegalSubjectFilter filter);

//    List<AsvImportResponse> getLegalSubjectOld(String inn, String kpp);
}
