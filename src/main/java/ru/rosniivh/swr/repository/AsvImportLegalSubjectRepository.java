package ru.rosniivh.swr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rosniivh.swr.domain.object.asv.AsvImportLegalSubjectEntity;
import ru.rosniivh.swr.filter.AsvImportLegalSubjectFilter;

import java.util.List;

@Repository
public interface AsvImportLegalSubjectRepository extends JpaRepository<AsvImportLegalSubjectEntity, Integer>,
        JpaSpecificationExecutor<AsvImportLegalSubjectEntity> {

    default List<AsvImportLegalSubjectEntity> findAll(AsvImportLegalSubjectFilter filter) {
        return filter == null ? findAll() : findAll(filter.toSpecification());
    }

    @Query(value = "SELECT ls FROM AsvImportLegalSubjectEntity ls WHERE ls.fullName LIKE :fullName")
    List<AsvImportLegalSubjectEntity> getByFullName(String fullName);

    @Query(value = "SELECT ls FROM AsvImportLegalSubjectEntity ls WHERE ls.inn LIKE %?1%")
    List<AsvImportLegalSubjectEntity> getByInn(String inn);
}
