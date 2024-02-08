package ru.rosniivh.swr.domain.object;

import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_confirmation_document", schema = "dbo")
public class ConfirmationDocumentEntity {
    @Id
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "doc_number")
    private String docNumber;

    @Column(name = "doc_date")
    private LocalDate docDate;

    @Column(name = "in_number")
    private String inNumber;

    @Column(name = "in_date")
    private LocalDate inDate;

    @Column(name = "out_number")
    private String outNumber;

    @Column(name = "out_date")
    private LocalDate outDate;

    @Column(name = "storage_location")
    private String storageLocation;

    @Column(name = "file_size")
    private Integer fileSize;

    @Column(name = "file_content")
    private byte[] fileContent;

    @Column(name = "inserted_on", nullable = false)
    private Instant insertedOn;

    @Column(name = "updated_on")
    private Instant updatedOn;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "confirmed")
    private Boolean confirmed;

    @Column(name = "confirmed_on")
    private Instant confirmedOn;

    @Column(name = "confirmed_by")
    private Integer confirmedBy;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        ConfirmationDocumentEntity that = (ConfirmationDocumentEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}