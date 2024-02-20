package ru.rosniivh.swr.repository.asv;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportOkved22016Entity;

import java.util.List;

@Repository
public interface AsvImportOkved22016Repository extends JpaRepository<AsvImportOkved22016Entity, Integer> {

    @Query(value = "SELECT okved FROM AsvImportOkved22016Entity okved " +
            "WHERE okved.code LIKE %?1% OR okved.name LIKE %?1%")
    List<AsvImportOkved22016Entity> findAllByCodeOrName(String term);
}
