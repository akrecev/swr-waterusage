package ru.rosniivh.swr.domain.projections;

import org.springframework.data.rest.core.config.Projection;
import ru.rosniivh.swr.domain.catalog.asv.AsvUsageTargetEntity;

@Projection(name = "filter", types = AsvUsageTargetEntity.class)
public interface AsvUsageTargetProjections {
    Integer getId();

    String getCode();

    String getName();

    String getIsOld();

    Integer getVarNum();
}
