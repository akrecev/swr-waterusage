package ru.rosniivh.swr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rosniivh.swr.domain.object.asv.AsvContractEntity;

import java.util.List;

@Repository
public interface AsvContractRepository extends JpaRepository<AsvContractEntity, Integer>,
        JpaSpecificationExecutor<AsvContractEntity> {

    @Query("SELECT c FROM AsvContractEntity c WHERE c.id IN (?1)")
    List<AsvContractEntity> getContractByIds(List<Integer> ids);
}
