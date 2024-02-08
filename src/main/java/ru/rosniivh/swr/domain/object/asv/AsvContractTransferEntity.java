package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

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

    @Column(name = "conclusion_place")
    private String conclusionPlace;

    @Column(name = "sign_date")
    private LocalDate signDate;

    @Column(name = "reg_date")
    private LocalDate regDate;

    @Column(name = "reg_number")
    private String regNumber;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "wu_end_date")
    private LocalDate wuEndDate;

    @Column(name = "stop_date")
    private LocalDate stopDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "rightholder_id")
    private AsvImportLegalSubjectEntity rightholder;

    @Column(name = "rightholder_firstname")
    private String rightholderFirstname;

    @Column(name = "rightholder_middlename")
    private String rightholderMiddlename;

    @Column(name = "rightholder_lastname")
    private String rightholderLastname;

    @Column(name = "rightholder_post")
    private String rightholderPost;

    @Column(name = "rightholder_basis")
    private String rightholderBasis;

    @Column(name = "assignee_id")
    private Integer assigneeId;

    @Column(name = "assignee_firstname")
    private String assigneeFirstname;

    @Column(name = "assignee_middlename")
    private String assigneeMiddlename;

    @Column(name = "assignee_lastname")
    private String assigneeLastname;

    @Column(name = "assignee_post")
    private String assigneePost;

    @Column(name = "assignee_basis")
    private String assigneeBasis;

    @Column(name = "payment")
    private BigDecimal payment;

    @Column(name = "notes")
    private String notes;

    @Column(name = "old_code")
    private String oldCode;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        AsvContractTransferEntity that = (AsvContractTransferEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}