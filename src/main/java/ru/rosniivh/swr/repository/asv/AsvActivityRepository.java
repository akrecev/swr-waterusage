package ru.rosniivh.swr.repository.asv;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.rosniivh.swr.domain.catalog.asv.AsvActivityEntity;
import ru.rosniivh.swr.domain.projections.AsvActivityProjection;

@RepositoryRestResource(path = "asvActivities", excerptProjection = AsvActivityProjection.class)
public interface AsvActivityRepository extends CrudRepository<AsvActivityEntity, Integer> {}
