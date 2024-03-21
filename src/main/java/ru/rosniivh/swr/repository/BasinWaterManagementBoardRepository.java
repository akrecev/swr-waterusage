package ru.rosniivh.swr.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.rosniivh.swr.domain.catalog.BasinWaterManagementBoardEntity;

public interface BasinWaterManagementBoardRepository extends JpaRepository<BasinWaterManagementBoardEntity, Integer> {
    @Query("SELECT b FROM BasinWaterManagementBoardEntity b " + "WHERE ','||b.gisOrgIds||',' like :gisOrgId")
    List<BasinWaterManagementBoardEntity> findByGisOrgId(@Param("gisOrgId") String gisOrgId);
}
