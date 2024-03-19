package ru.rosniivh.swr.repository.asv;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rosniivh.swr.domain.object.asv.AsvDocumentEntity;

@Repository
public interface AsvDocumentRepository
        extends JpaRepository<AsvDocumentEntity, Integer>, JpaSpecificationExecutor<AsvDocumentEntity> {

    @Query("SELECT doc FROM AsvDocumentEntity doc LEFT JOIN doc.organ "
            + "LEFT JOIN doc.status "
            + "LEFT JOIN doc.docType "
            + "WHERE doc.organ.inn = ?1 AND doc.organ.kpp = ?2 AND doc.status.id = 1 AND doc.markDel = false")
    List<AsvDocumentEntity> getDocByInnAndKpp(String inn, String kpp);

    @Query("SELECT doc FROM AsvDocumentEntity doc " + "LEFT JOIN doc.organ "
            + "LEFT JOIN doc.docType "
            + "LEFT JOIN doc.rfSubject"
            + " LEFT JOIN doc.status "
            + "WHERE doc.status.id <> 8 AND doc.signDate BETWEEN ?1 AND ?2")
    List<AsvDocumentEntity> getDocByRange(LocalDate start, LocalDate end);
}
