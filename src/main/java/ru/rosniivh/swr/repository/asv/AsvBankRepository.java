package ru.rosniivh.swr.repository.asv;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.rosniivh.swr.domain.catalog.asv.AsvBankEntity;
import ru.rosniivh.swr.domain.projections.AsvBankProjections;

@RepositoryRestResource(path = "asvBanks", excerptProjection = AsvBankProjections.class)
public interface AsvBankRepository extends CrudRepository<AsvBankEntity, Integer> {
    List<AsvBankEntity> findByOrderByCode();
}
