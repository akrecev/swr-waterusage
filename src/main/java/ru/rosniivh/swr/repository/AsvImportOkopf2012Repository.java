package ru.rosniivh.swr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportOkopf2012Entity;

@Repository
public interface AsvImportOkopf2012Repository extends JpaRepository<AsvImportOkopf2012Entity, Integer> {}
