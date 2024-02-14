package ru.rosniivh.swr.repository.asv;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportAuthOrgContractEntity;

@Repository
public interface AsvImportAuthOrgContractRepository extends JpaRepository<AsvImportAuthOrgContractEntity, Integer> {
    List<AsvImportAuthOrgContractEntity> findByParentId(@Param("parentId") Integer parentId);
}
