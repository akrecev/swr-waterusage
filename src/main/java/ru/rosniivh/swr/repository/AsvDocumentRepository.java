package ru.rosniivh.swr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rosniivh.swr.domain.object.asv.AsvDocumentEntity;

@Repository
public interface AsvDocumentRepository
        extends JpaRepository<AsvDocumentEntity, Integer>, JpaSpecificationExecutor<AsvDocumentEntity> {

    @Query("SELECT doc FROM AsvDocumentEntity doc " + "LEFT JOIN doc.organ "
            + "LEFT JOIN doc.status "
            + "LEFT JOIN doc.docType "
            + "WHERE doc.organ.inn = ?1 AND doc.organ.kpp = ?2 AND doc.status.id = 1 AND doc.markDel = false")
    List<AsvDocumentEntity> getDocByInnAndKpp(String inn, String kpp);
}
