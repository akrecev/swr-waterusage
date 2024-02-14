package ru.rosniivh.swr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rosniivh.swr.domain.object.asv.AsvAdmOperationEntity;

import java.util.List;

@Repository
public interface AsvAdmOperationRepository extends JpaRepository<AsvAdmOperationEntity, Integer>,
        JpaSpecificationExecutor<AsvAdmOperationEntity> {

    @Query("SELECT oper FROM AsvAdmOperationEntity oper LEFT JOIN oper.operType WHERE oper.id IN (?1)")
    List<AsvAdmOperationEntity> getOperByIds(List<Integer> ids);
}
