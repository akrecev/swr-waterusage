package ru.rosniivh.swr.repository.asv;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.rosniivh.swr.domain.catalog.asv.AsvAuthOrgTypeEntity;
import ru.rosniivh.swr.domain.projections.AsvAuthOrgTypeProjections;

@RepositoryRestResource(path = "asvAuthOrgTypes", excerptProjection = AsvAuthOrgTypeProjections.class)
public interface AsvAuthOrgTypeRepository extends CrudRepository<AsvAuthOrgTypeEntity, Integer> {}
