package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.catalog.asv.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_additional_agreement", schema = "dbo")
public class AsvAdditionalAgreementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status")
    private AsvStatusEntity status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private AsvContractEntity contract;

    @Column(name = "reg_number", length = Integer.MAX_VALUE)
    private String regNumber;

    @Column(name = "add_agr_number", length = Integer.MAX_VALUE)
    private String addAgrNumber;

    @Column(name = "sign_date")
    private LocalDate signDate;

    @Column(name = "reg_date")
    private LocalDate regDate;

    @Column(name = "npp")
    private Integer npp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reducing_reason_id")
    private AsvReducingReasonEntity reducingReason;

    @Column(name = "wu_start_period", length = Integer.MAX_VALUE)
    private String wuStartPeriod;

    @Column(name = "has_observation_program")
    private Integer hasObservationProgram;

    @Column(name = "observation_program_points", length = Integer.MAX_VALUE)
    private String observationProgramPoints;

    @Column(name = "organ_text", length = Integer.MAX_VALUE)
    private String organText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kbk_id")
    private AsvKbkEntity kbk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organ_id")
    private AsvImportAuthOrgContractEntity organ;

    @Column(name = "organ_name", length = Integer.MAX_VALUE)
    private String organName;

    @Column(name = "organ_fio", length = Integer.MAX_VALUE)
    private String organFio;

    @Column(name = "organ_basis", length = Integer.MAX_VALUE)
    private String organBasis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "water_user_id")
    private AsvImportLegalSubjectEntity waterUser;

    @Column(name = "water_user_name", length = Integer.MAX_VALUE)
    private String waterUserName;

    @Column(name = "water_user_fio", length = Integer.MAX_VALUE)
    private String waterUserFio;

    @Column(name = "water_user_basis", length = Integer.MAX_VALUE)
    private String waterUserBasis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "termination_basis_id")
    private AsvTerminationBasisEntity terminationBasis;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @Column(name = "old_code", length = Integer.MAX_VALUE)
    private String oldCode;

    @Column(name = "order_number", length = Integer.MAX_VALUE)
    private String orderNumber;

    @Column(name = "asv_document_id")
    private Integer asvDocumentId;

    @Column(name = "wu_end_date")
    private LocalDate wuEndDate;

    @Column(name = "stop_date")
    private LocalDate stopDate;

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
        AsvAdditionalAgreementEntity that = (AsvAdditionalAgreementEntity) o;
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
