package ru.rosniivh.swr.domain.projections;

import org.springframework.data.rest.core.config.Projection;
import ru.rosniivh.swr.domain.catalog.asv.AsvWuMethodEntity;

@Projection(name = "filter", types = AsvWuMethodEntity.class)
public interface AsvWuMethodsProjections {

    Integer getId();

    String getCode();

    String getName();
}
