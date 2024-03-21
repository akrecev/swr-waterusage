package ru.rosniivh.swr.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.rosniivh.swr.domain.catalog.RfSubjectEntity;

@Repository
public interface RfSubjectRepository
        extends JpaRepository<RfSubjectEntity, Integer>, JpaSpecificationExecutor<RfSubjectEntity> {

    List<RfSubjectEntity> findByFdId(@Param("fd") Integer uid);

    List<RfSubjectEntity> findByConstNumber(String constNumber);
}
