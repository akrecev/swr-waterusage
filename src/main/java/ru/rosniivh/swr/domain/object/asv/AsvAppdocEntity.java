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
@Table(name = "o_asv_appdoc", schema = "dbo")
public class AsvAppdocEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "doc_num", length = Integer.MAX_VALUE)
    private String docNum;

    @Column(name = "doc_date")
    private LocalDate docDate;

    @Column(name = "stage")
    private Integer stage;

    @Column(name = "substage")
    private Integer substage;

    @Column(name = "document_id")
    private Integer documentId;

    @Column(name = "document_code", length = Integer.MAX_VALUE)
    private String documentCode;

    @Column(name = "wo_link", length = Integer.MAX_VALUE)
    private String woLink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_status_id")
    private AsvReviewStatusEntity reviewStatus;

    @Column(name = "in_number", length = Integer.MAX_VALUE)
    private String inNumber;

    @Column(name = "in_date")
    private LocalDate inDate;

    @Column(name = "in_letter_date")
    private LocalDate inLetterDate;

    @Column(name = "in_letter_num", length = Integer.MAX_VALUE)
    private String inLetterNum;

    @Column(name = "sign_date")
    private LocalDate signDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acceptor_id")
    private AsvAcceptorEntity acceptor;

    @Column(name = "acceptor_code", length = Integer.MAX_VALUE)
    private String acceptorCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "checker_id")
    private AsvRegistratorEntity checker;

    @Column(name = "checker_code", length = Integer.MAX_VALUE)
    private String checkerCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "complect_decision_id")
    private AsvComplectDecisionEntity complectDecision;

    @Column(name = "complect_decision_date")
    private LocalDate complectDecisionDate;

    @Column(name = "refuse_date")
    private LocalDate refuseDate;

    @Column(name = "refuse_letter_num", length = Integer.MAX_VALUE)
    private String refuseLetterNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "refusor_id")
    private AsvRefusorEntity refusor;

    @Column(name = "refusor_code", length = Integer.MAX_VALUE)
    private String refusorCode;

    @Column(name = "check_auth_done")
    private Integer checkAuthDone;

    @Column(name = "check_use_done")
    private Integer checkUseDone;

    @Column(name = "check_param_done")
    private Integer checkParamDone;

    @Column(name = "check_agreement_done")
    private Integer checkAgreementDone;

    @Column(name = "check_term_done")
    private Integer checkTermDone;

    @Column(name = "check_payment_done")
    private Integer checkPaymentDone;

    @Column(name = "other_rules", length = Integer.MAX_VALUE)
    private String otherRules;

    @Column(name = "other_rules_done")
    private Integer otherRulesDone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "check_decision_id")
    private AsvCheckDecisionEntity checkDecision;

    @Column(name = "check_decision_date")
    private LocalDate checkDecisionDate;

    @Column(name = "conclusion_refuse_letter_num", length = Integer.MAX_VALUE)
    private String conclusionRefuseLetterNum;

    @Column(name = "conclusion_refusor_id")
    private Integer conclusionRefusorId;

    @Column(name = "conclusion_refusor_code", length = Integer.MAX_VALUE)
    private String conclusionRefusorCode;

    @Column(name = "reg_date")
    private LocalDate regDate;

    @Column(name = "reg_number", length = Integer.MAX_VALUE)
    private String regNumber;

    @Column(name = "document_number", length = Integer.MAX_VALUE)
    private String documentNumber;

    @Column(name = "materials_send_date")
    private LocalDate materialsSendDate;

    @Column(name = "new_master")
    private Integer newMaster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_water_user_id")
    private AsvImportLegalSubjectEntity docWaterUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_auth_id")
    private AsvImportAuthOrgContractEntity docAuth;

    @Column(name = "doc_type_code", length = Integer.MAX_VALUE)
    private String docTypeCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_target_id")
    private AsvUsageTargetEntity docTarget;

    @Column(name = "doc_wo_name", length = Integer.MAX_VALUE)
    private String docWoName;

    @Column(name = "doc_wo_id")
    private Integer docWoId;

    @Column(name = "doc_wo_code", length = Integer.MAX_VALUE)
    private String docWoCode;

    @Column(name = "doc_wo_code_name", length = Integer.MAX_VALUE)
    private String docWoCodeName;

    @Column(name = "doc_hep_code", length = Integer.MAX_VALUE)
    private String docHepCode;

    @Column(name = "doc_hep_name", length = Integer.MAX_VALUE)
    private String docHepName;

    @Column(name = "doc_hep_map_link", length = Integer.MAX_VALUE)
    private String docHepMapLink;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @Column(name = "receipt_date")
    private LocalDate receiptDate;

    @Column(name = "registration_transfer_date")
    private LocalDate registrationTransferDate;

    @Column(name = "accept_date")
    private LocalDate acceptDate;

    @Column(name = "document_list", length = Integer.MAX_VALUE)
    private String documentList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conclusion_signer_id")
    private AsvConclusionSignerEntity conclusionSigner;

    @Column(name = "conclusion_signer_code", length = Integer.MAX_VALUE)
    private String conclusionSignerCode;

    @Column(name = "check_other_rules_done")
    private Integer checkOtherRulesDone;

    @Column(name = "reg_order_number", length = Integer.MAX_VALUE)
    private String regOrderNumber;

    @Column(name = "swr_check_done")
    private Integer swrCheckDone;

    @Column(name = "swr_reg_done")
    private Integer swrRegDone;

    @Column(name = "auth_id")
    private Integer authId;

    @Column(name = "mark_del")
    private Integer markDel;

    @Column(name = "posted")
    private Integer posted;

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
        AsvAppdocEntity that = (AsvAppdocEntity) o;
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
