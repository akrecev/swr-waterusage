package ru.rosniivh.swr.repository.asv;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.rosniivh.swr.domain.catalog.asv.AsvActivityEntity;
import ru.rosniivh.swr.domain.projections.AsvActivityProjections;

@RepositoryRestResource(path = "asvActivities", excerptProjection = AsvActivityProjections.class)
public interface AsvActivityRepository extends CrudRepository<AsvActivityEntity, Integer> {}
