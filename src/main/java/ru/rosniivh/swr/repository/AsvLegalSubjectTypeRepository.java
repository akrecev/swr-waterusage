package ru.rosniivh.swr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rosniivh.swr.domain.object.asv.AsvLegalSubjectTypeEntity;

@Repository
public interface AsvLegalSubjectTypeRepository extends JpaRepository<AsvLegalSubjectTypeEntity, Integer> {
}
