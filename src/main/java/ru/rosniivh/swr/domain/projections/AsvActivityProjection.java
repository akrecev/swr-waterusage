package ru.rosniivh.swr.domain.projections;

import org.springframework.data.rest.core.config.Projection;
import ru.rosniivh.swr.domain.catalog.asv.AsvActivityEntity;

@Projection(name = "filter", types = AsvActivityEntity.class)
public interface AsvActivityProjection {
    Integer getId();

    String getCode();

    String getDescription();
}
