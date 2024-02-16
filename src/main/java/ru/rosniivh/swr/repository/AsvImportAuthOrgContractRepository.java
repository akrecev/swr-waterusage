package ru.rosniivh.swr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportAuthOrgContractEntity;

import java.util.List;

@Repository
public interface AsvImportAuthOrgContractRepository extends JpaRepository<AsvImportAuthOrgContractEntity, Integer>,
        JpaSpecificationExecutor<AsvImportAuthOrgContractEntity> {

    @Query(value = "SELECT organ FROM AsvImportAuthOrgContractEntity organ " +
            "LEFT JOIN organ.rfSubjectNew " +
            "WHERE organ.parentId = ?1")
    List<AsvImportAuthOrgContractEntity> getRfsWithOrganByBvuId(Integer bvuID);
}
