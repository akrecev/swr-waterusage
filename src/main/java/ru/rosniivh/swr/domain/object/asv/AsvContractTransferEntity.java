package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.catalog.RfSubjectEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportAuthOrgContractEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvRfSubjectEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvStatusEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_contract_transfer", schema = "dbo")
public class AsvContractTransferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private AsvContractEntity contract;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status")
    private AsvStatusEntity status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rfs_id")
    private RfSubjectEntity rfs;

    @Column(name = "conclusion_place", length = Integer.MAX_VALUE)
    private String conclusionPlace;

    @Column(name = "sign_date")
    private LocalDate signDate;

    @Column(name = "reg_date")
    private LocalDate regDate;

    @Column(name = "reg_number", length = Integer.MAX_VALUE)
    private String regNumber;

    @Column(name = "order_number", length = Integer.MAX_VALUE)
    private String orderNumber;

    @Column(name = "wu_end_date")
    private LocalDate wuEndDate;

    @Column(name = "stop_date")
    private LocalDate stopDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rightholder_id")
    private AsvImportLegalSubjectEntity rightholder;

    @Column(name = "rightholder_firstname", length = Integer.MAX_VALUE)
    private String rightholderFirstName;

    @Column(name = "rightholder_middlename", length = Integer.MAX_VALUE)
    private String rightholderMiddleName;

    @Column(name = "rightholder_lastname", length = Integer.MAX_VALUE)
    private String rightholderLastName;

    @Column(name = "rightholder_post", length = Integer.MAX_VALUE)
    private String rightholderPost;

    @Column(name = "rightholder_basis", length = Integer.MAX_VALUE)
    private String rightholderBasis;

    @Column(name = "assignee_id")
    private Integer assigneeId;

    @Column(name = "assignee_firstname", length = Integer.MAX_VALUE)
    private String assigneeFirstName;

    @Column(name = "assignee_middlename", length = Integer.MAX_VALUE)
    private String assigneeMiddleName;

    @Column(name = "assignee_lastname", length = Integer.MAX_VALUE)
    private String assigneeLastName;

    @Column(name = "assignee_post", length = Integer.MAX_VALUE)
    private String assigneePost;

    @Column(name = "assignee_basis", length = Integer.MAX_VALUE)
    private String assigneeBasis;

    @Column(name = "payment", precision = 38, scale = 2)
    private BigDecimal payment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organ_id")
    private AsvImportAuthOrgContractEntity organ;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @Column(name = "old_code", length = Integer.MAX_VALUE)
    private String oldCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asv_rfs_id")
    private AsvRfSubjectEntity asvRfs;

    @Column(name = "asv_document_id")
    private Integer asvDocumentId;

    @Column(name = "mark_del")
    private Integer markDel;

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
        AsvContractTransferEntity that = (AsvContractTransferEntity) o;
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
