package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.auth.UserEntity;
import ru.rosniivh.swr.domain.catalog.asv.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_adm_operation", schema = "dbo")
public class AsvAdmOperationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oper_type_id")
    private AsvOperationTypeEntity operType;

    @Column(name = "uin", length = Integer.MAX_VALUE)
    private String uin;

    @Column(name = "doc_num", length = Integer.MAX_VALUE)
    private String docNum;

    @Column(name = "doc_date")
    private LocalDate docDate;

    @Column(name = "year")
    private Integer year;

    @Column(name = "quarter")
    private Integer quarter;

    @Column(name = "payment_period")
    private LocalDate paymentPeriod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auth_id")
    private AsvImportAuthOrgContractEntity auth;

    @Column(name = "admin_id")
    private Integer adminId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private AsvContractEntity contract;

    @Column(name = "contract_income_id")
    private Integer contractIncomeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "add_agr_id")
    private AsvAdditionalAgreementEntity addAgr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "water_user_id")
    private AsvImportLegalSubjectEntity waterUser;

    @Column(name = "summ")
    private Double summ;

    @Column(name = "summ_in")
    private Double summIn;

    @Column(name = "summ_out")
    private Double summOut;

    @Column(name = "calc_summ")
    private Double calcSumm;

    @Column(name = "corrected")
    private Integer corrected;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oper_id")
    private AsvAdmOperationEntity oper;

    @Column(name = "oper_old_code", length = Integer.MAX_VALUE)
    private String operOldCode;

    @Column(name = "return_status", length = Integer.MAX_VALUE)
    private String returnStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aim_id")
    private AsvWuAimPaymentEntity aim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_id")
    private AsvUsageTargetEntity target;

    @Column(name = "decision_num", length = Integer.MAX_VALUE)
    private String decisionNum;

    @Column(name = "decision_date")
    private LocalDate decisionDate;

    @Column(name = "return_application_num", length = Integer.MAX_VALUE)
    private String returnApplicationNum;

    @Column(name = "return_application_date")
    private LocalDate returnApplicationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_account_id")
    private AsvImportBankAccountEntity bankAccount;

    @Column(name = "payment_application_num", length = Integer.MAX_VALUE)
    private String paymentApplicationNum;

    @Column(name = "payment_application_date")
    private LocalDate paymentApplicationDate;

    @Column(name = "overpaid")
    private Double overpaid;

    @Column(name = "budget_system_date")
    private LocalDate budgetSystemDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_card_id")
    private AsvContractPaymentCardEntity paymentCard;

    @Column(name = "payment_card_old", length = Integer.MAX_VALUE)
    private String paymentCardOld;

    @Column(name = "fin_debt_flag")
    private Integer finDebtFlag;

    @Column(name = "fin_sum")
    private Double finSum;

    @Column(name = "fin_sum_old")
    private Double finSumOld;

    @Column(name = "manual_calc")
    private Integer manualCalc;

    @Column(name = "excess_param")
    private Double excessParam;

    @Column(name = "auction_num", length = Integer.MAX_VALUE)
    private String auctionNum;

    @Column(name = "auction_date")
    private LocalDate auctionDate;

    @Column(name = "ufk_doc_num", length = Integer.MAX_VALUE)
    private String ufkDocNum;

    @Column(name = "ufk_doc_date")
    private LocalDate ufkDocDate;

    @Column(name = "write_off_basis", length = Integer.MAX_VALUE)
    private String writeOffBasis;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @Column(name = "executor", length = Integer.MAX_VALUE)
    private String executor;

    @Column(name = "mark_del")
    private Integer markDel;

    @Column(name = "posted")
    private Integer posted;

    @Column(name = "request_old_code", length = Integer.MAX_VALUE)
    private String requestOldCode;

    @Column(name = "old_code", length = Integer.MAX_VALUE)
    private String oldCode;

    @Column(name = "inserted_on")
    private Instant insertedOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inserted_by")
    private UserEntity insertedBy;

    @Column(name = "updated_on")
    private Instant updatedOn;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kek_id")
    private AsvKekEntity kek;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_account_id")
    private AsvPlanAccountEntity planAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kbk_id")
    private AsvKbkAdmEntity kbk;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        AsvAdmOperationEntity that = (AsvAdmOperationEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}