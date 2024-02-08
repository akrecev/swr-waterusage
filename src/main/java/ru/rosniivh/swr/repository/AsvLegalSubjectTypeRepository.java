package ru.rosniivh.swr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rosniivh.swr.domain.catalog.asv.AsvLegalSubjectTypeEntity;

@Repository
public interface AsvLegalSubjectTypeRepository extends JpaRepository<AsvLegalSubjectTypeEntity, Integer> {}
