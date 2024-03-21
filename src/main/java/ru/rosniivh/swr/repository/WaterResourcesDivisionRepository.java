package ru.rosniivh.swr.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.rosniivh.swr.domain.catalog.WaterResourcesDivisionEntity;

public interface WaterResourcesDivisionRepository extends JpaRepository<WaterResourcesDivisionEntity, Integer> {
    @Query("SELECT b FROM WaterResourcesDivisionEntity b " + "WHERE ','||b.gisOrgIds||',' like :gisOrgId")
    List<WaterResourcesDivisionEntity> findByGisOrgId(@Param("gisOrgId") String gisOrgId);
}
