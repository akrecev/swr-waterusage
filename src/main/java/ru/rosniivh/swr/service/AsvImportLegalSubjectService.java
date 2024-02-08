package ru.rosniivh.swr.service;

import ru.rosniivh.swr.domain.object.asv.AsvImportLegalSubjectEntity;
import ru.rosniivh.swr.dto.object.asv.AsvImportLegalSubjectDto;
import ru.rosniivh.swr.filter.AsvImportLegalSubjectFilter;

import java.util.List;

public interface AsvImportLegalSubjectService {

    List<AsvImportLegalSubjectDto> getByFilter(AsvImportLegalSubjectFilter filter);

    AsvImportLegalSubjectEntity getById(Integer id);

    List<AsvImportLegalSubjectDto> getByFullName(String fullName);

    List<AsvImportLegalSubjectDto> getByInn(String inn);
}
