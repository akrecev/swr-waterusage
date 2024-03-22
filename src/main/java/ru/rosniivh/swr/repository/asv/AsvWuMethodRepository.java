package ru.rosniivh.swr.repository.asv;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.rosniivh.swr.domain.catalog.asv.AsvWuMethodEntity;

@RepositoryRestResource(path = "asvWuMethods", excerptProjection = AsvWuMethodEntity.class)
public interface AsvWuMethodRepository extends CrudRepository<AsvWuMethodEntity, Integer> {
}
