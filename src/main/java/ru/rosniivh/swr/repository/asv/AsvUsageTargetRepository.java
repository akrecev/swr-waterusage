package ru.rosniivh.swr.repository.asv;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.rosniivh.swr.domain.catalog.asv.AsvUsageTargetEntity;
import ru.rosniivh.swr.domain.projections.AsvUsageTargetProjections;

@RepositoryRestResource(path = "asvUsageTargets", excerptProjection = AsvUsageTargetProjections.class)
public interface AsvUsageTargetRepository extends CrudRepository<AsvUsageTargetEntity, Integer> {
    @Query("SELECT c FROM AsvUsageTargetEntity c " + "LEFT JOIN c.regType type "
            + "WHERE c.isOld = 0 and type.id = 1 and c.id not in (1, 3, 4)")
    List<AsvUsageTargetEntity> getAquatoryTargets();
}
