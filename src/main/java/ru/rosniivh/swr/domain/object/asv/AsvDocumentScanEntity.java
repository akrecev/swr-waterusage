package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_document_scan", schema = "dbo")
public class AsvDocumentScanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "document_id")
    private Integer documentId;

    @Column(name = "path", length = Integer.MAX_VALUE)
    private String path;

    @Column(name = "name_old", length = Integer.MAX_VALUE)
    private String nameOld;

    @Column(name = "size", length = Integer.MAX_VALUE)
    private String size;

    @Column(name = "author_name", length = Integer.MAX_VALUE)
    private String authorName;

    @Column(name = "date_create")
    private Instant dateCreate;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "old_code", length = Integer.MAX_VALUE)
    private String oldCode;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy
                ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass()
                : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass()
                : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        AsvDocumentScanEntity that = (AsvDocumentScanEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this)
                        .getHibernateLazyInitializer()
                        .getPersistentClass()
                        .hashCode()
                : getClass().hashCode();
    }
}
