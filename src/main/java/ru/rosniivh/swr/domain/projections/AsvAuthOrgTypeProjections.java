package ru.rosniivh.swr.domain.projections;

import org.springframework.data.rest.core.config.Projection;
import ru.rosniivh.swr.domain.catalog.asv.AsvAuthOrgTypeEntity;

@Projection(name = "filter", types = AsvAuthOrgTypeEntity.class)
public interface AsvAuthOrgTypeProjections {
    Integer getId();

    String getCode();

    String getName();
}
