package ru.rosniivh.swr.service;

import java.util.List;
import ru.rosniivh.swr.domain.object.asv.AsvImportLegalSubjectEntity;
import ru.rosniivh.swr.dto.object.asv.AsvImportLegalSubjectDto;
import ru.rosniivh.swr.filter.AsvImportLegalSubjectFilter;

public interface AsvImportLegalSubjectService {

    List<AsvImportLegalSubjectDto> getByFilter(AsvImportLegalSubjectFilter filter);

    AsvImportLegalSubjectEntity getById(Integer id);

    List<AsvImportLegalSubjectDto> getByFullName(String fullName);

    List<AsvImportLegalSubjectDto> getByInn(String inn);

    List<AsvImportLegalSubjectDto> getByType(Integer type, String name, String ogrn, String okpo, String postAddress,
                                             String legalAddress, String okato, String inn);
}
