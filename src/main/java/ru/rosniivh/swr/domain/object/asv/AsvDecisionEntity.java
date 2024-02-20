package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.catalog.RfSubjectEntity;
import ru.rosniivh.swr.domain.catalog.asv.*;
import ru.rosniivh.swr.domain.object.HeParcelEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_decision", schema = "dbo")
public class AsvDecisionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private AsvDecisionEntity parent;

    @Column(name = "is_new_decision")
    private Integer isNewDecision;

    @Column(name = "is_defense")
    private Integer isDefense;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status")
    private AsvStatusEntity status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rfs_id")
    private RfSubjectEntity rfs;

    @Column(name = "conclusion_place")
    private String conclusionPlace;

    @Column(name = "sign_date")
    private LocalDate signDate;

    @Column(name = "decision_number")
    private String decisionNumber;

    @Column(name = "reg_number")
    private String regNumber;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "add_number")
    private String addNumber;

    @Column(name = "reg_date")
    private LocalDate regDate;

    @Column(name = "wu_begin_date")
    private LocalDate wuBeginDate;

    @Column(name = "wu_end_date")
    private LocalDate wuEndDate;

    @Column(name = "stop_date")
    private LocalDate stopDate;

    @Column(name = "period_text")
    private String periodText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organ_id")
    private AsvImportAuthOrgContractEntity organ;

    @Column(name = "organ_fio")
    private String organFio;

    @Column(name = "organ_lastname")
    private String organLastName;

    @Column(name = "organ_firstname")
    private String organFirstName;

    @Column(name = "organ_middlename")
    private String organMiddleName;

    @Column(name = "organ_post")
    private String organPost;

    @Column(name = "organ_basis")
    private String organBasis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "water_user_id")
    private AsvImportLegalSubjectEntity waterUser;

    @Column(name = "letter_wo_type")
    private String letterWoType;

    @Column(name = "letter_aim")
    private String letterAim;

    @Column(name = "aim_notes")
    private String aimNotes;

    @Column(name = "wu_kind")
    private String wuKind;

    @Column(name = "letter_method")
    private String letterMethod;

    @Column(name = "letter_influence")
    private String letterInfluence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hep_id")
    private HeParcelEntity hep;

    @Column(name = "location")
    private String location;

    @Column(name = "need_report_withdrawal")
    private Integer needReportWithdrawal;

    @Column(name = "need_report_discharge")
    private Integer needReportDischarge;

    @Column(name = "need_report_quality")
    private Integer needReportQuality;

    @Column(name = "old_code")
    private String oldCode;

    @Column(name = "old_parent_code")
    private String oldParentCode;

    @Column(name = "var_num")
    private String varNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wot_id")
    private AsvWaterObjectTypeEntity wot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aim_id")
    private AsvUsageTargetEntity aim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "influence_id")
    private AsvUsageEffectEntity influence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wu_kind_id")
    private AsvWuKindEntity wuKind1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "method_id")
    private AsvWuMethodEntity method;

    @Column(name = "asv_rfs_id")
    private Integer asvRfsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asv_activities_plan_id")
    private AsvActivitiesPlanEntity asvActivitiesPlan;

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
        AsvDecisionEntity that = (AsvDecisionEntity) o;
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
