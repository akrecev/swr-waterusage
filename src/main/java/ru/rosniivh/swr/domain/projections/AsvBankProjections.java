package ru.rosniivh.swr.domain.projections;

import org.springframework.data.rest.core.config.Projection;
import ru.rosniivh.swr.domain.catalog.asv.AsvBankEntity;

/**
 * Projection for {@link ru.rosniivh.swr.domain.catalog.asv.AsvBankEntity}
 */
@Projection(name = "filter", types = AsvBankEntity.class)
public interface AsvBankProjections {
    Integer getId();

    String getCode();

    String getName();

    String getCorrAccount();

    String getCity();

    String getAddress();

    String getPhone();
}
