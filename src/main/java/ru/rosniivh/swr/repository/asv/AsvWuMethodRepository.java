package ru.rosniivh.swr.repository.asv;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.rosniivh.swr.domain.catalog.asv.AsvWuMethodEntity;
import ru.rosniivh.swr.domain.projections.AsvWuMethodsProjections;

@RepositoryRestResource(path = "asvWuMethods", excerptProjection = AsvWuMethodsProjections.class)
public interface AsvWuMethodRepository extends CrudRepository<AsvWuMethodEntity, Integer> {}
