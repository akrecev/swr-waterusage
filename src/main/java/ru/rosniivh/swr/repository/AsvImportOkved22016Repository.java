package ru.rosniivh.swr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportOkved22016Entity;

@Repository
public interface AsvImportOkved22016Repository extends JpaRepository<AsvImportOkved22016Entity, Integer> {
}
