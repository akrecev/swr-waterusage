package ru.rosniivh.swr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.rosniivh.swr.domain.catalog.RfSubjectEntity;

@Repository
public interface RfSubjectRepository extends JpaRepository<RfSubjectEntity, Integer>,
        JpaSpecificationExecutor<RfSubjectEntity> {

}
