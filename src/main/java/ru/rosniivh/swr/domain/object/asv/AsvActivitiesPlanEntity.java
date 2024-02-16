package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.catalog.asv.AsvDocTypeEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportAuthOrgContractEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_activities_plan", schema = "dbo")
public class AsvActivitiesPlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "date")
    private String date;

    @Column(name = "number")
    private String number;

    @Column(name = "posted")
    private Integer posted;

    @Column(name = "deletion_mark")
    private Integer deletionMark;

    @Column(name = "old_code_confirmation_document")
    private String oldCodeConfirmationDocument;

    @Column(name = "old_code_users")
    private String oldCodeUsers;

    @Column(name = "comment")
    private String comment;

    @Column(name = "old_code_organ")
    private String oldCodeOrgan;

    @Column(name = "old_code")
    private String oldCode;

    @Column(name = "document_id")
    private Integer documentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auth_org_id")
    private AsvImportAuthOrgContractEntity authOrg;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "date_datetime")
    private Instant dateDatetime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dicision_id")
    private AsvDecisionEntity dicision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "additional_agreement_id")
    private AsvAdditionalAgreementEntity additionalAgreement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_type_id")
    private AsvDocTypeEntity docType;

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
        AsvActivitiesPlanEntity that = (AsvActivitiesPlanEntity) o;
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
