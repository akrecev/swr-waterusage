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
@Table(name = "o_asv_contract", schema = "dbo")
public class AsvContractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

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

    @Column(name = "reg_number", length = Integer.MAX_VALUE)
    private String regNumber;

    @Column(name = "wu_begin_date")
    private LocalDate wuBeginDate;

    @Column(name = "wu_end_date")
    private LocalDate wuEndDate;

    @Column(name = "stop_date")
    private LocalDate stopDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organ_id")
    private AsvImportAuthOrgContractEntity organ;

    @Column(name = "organ_fio", length = Integer.MAX_VALUE)
    private String organFio;

    @Column(name = "organ_basis", length = Integer.MAX_VALUE)
    private String organBasis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "water_user_id")
    private AsvImportLegalSubjectEntity waterUser;

    @Column(name = "water_user_fio", length = Integer.MAX_VALUE)
    private String waterUserFio;

    @Column(name = "water_user_basis", length = Integer.MAX_VALUE)
    private String waterUserBasis;

    @Column(name = "water_object_id")
    private Integer waterObjectId;

    @Column(name = "letter_wo_type", length = Integer.MAX_VALUE)
    private String letterWoType;

    @Column(name = "letter_aim", length = Integer.MAX_VALUE)
    private String letterAim;

    @Column(name = "wu_kind", length = Integer.MAX_VALUE)
    private String wuKind;

    @Column(name = "letter_method", length = Integer.MAX_VALUE)
    private String letterMethod;

    @Column(name = "letter_influence", length = Integer.MAX_VALUE)
    private String letterInfluence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hep_id")
    private HeParcelEntity hep;

    @Column(name = "location", length = Integer.MAX_VALUE)
    private String location;

    @Column(name = "has_param_calc")
    private Integer hasParamCalc;

    @Column(name = "morf_length")
    private Double morfLength;

    @Column(name = "morf_distance_from")
    private Double morfDistanceFrom;

    @Column(name = "morf_distance_to")
    private Double morfDistanceTo;

    @Column(name = "morf_square")
    private Double morfSquare;

    @Column(name = "morf_useful_volume")
    private Double morfUsefulVolume;

    @Column(name = "morf_volume")
    private Double morfVolume;

    @Column(name = "morf_depth_min")
    private Double morfDepthMin;

    @Column(name = "morf_depht_avg")
    private Double morfDephtAvg;

    @Column(name = "morf_depth_max")
    private Double morfDepthMax;

    @Column(name = "morf_other", length = Integer.MAX_VALUE)
    private String morfOther;

    @Column(name = "hydr_cons")
    private Double hydrCons;

    @Column(name = "hydr_drain_volume")
    private Double hydrDrainVolume;

    @Column(name = "hydr_speed_min")
    private Double hydrSpeedMin;

    @Column(name = "hydr_speed_max")
    private Double hydrSpeedMax;

    @Column(name = "hydr_level_amplitude")
    private Double hydrLevelAmplitude;

    @Column(name = "hydr_adverse_period", length = Integer.MAX_VALUE)
    private String hydrAdversePeriod;

    @Column(name = "hydr_other", length = Integer.MAX_VALUE)
    private String hydrOther;

    @Column(name = "qual_date")
    private LocalDate qualDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "izv_id")
    private AsvIzvEntity izv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ukizv_i_id")
    private AsvUkizvIEntity ukizvI;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ukizv_k_id")
    private AsvUkizvKEntity ukizvK;

    @Column(name = "qual_other", length = Integer.MAX_VALUE)
    private String qualOther;

    @Column(name = "param_method", length = Integer.MAX_VALUE)
    private String paramMethod;

    @Column(name = "wu_start_period", length = Integer.MAX_VALUE)
    private String wuStartPeriod;

    @Column(name = "has_observation_program")
    private Integer hasObservationProgram;

    @Column(name = "organ_text", length = Integer.MAX_VALUE)
    private String organText;

    @Column(name = "need_withdrawal_report")
    private Integer needWithdrawalReport;

    @Column(name = "fine_order", length = Integer.MAX_VALUE)
    private String fineOrder;

    @Column(name = "penalty_order", length = Integer.MAX_VALUE)
    private String penaltyOrder;

    @Column(name = "assignee_id")
    private Integer assigneeId;

    @Column(name = "transfer_doc_num", length = Integer.MAX_VALUE)
    private String transferDocNum;

    @Column(name = "transfer_doc_date")
    private LocalDate transferDocDate;

    @Column(name = "transfet_doc_end_date")
    private LocalDate transfetDocEndDate;

    @Column(name = "transfer_status", length = Integer.MAX_VALUE)
    private String transferStatus;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @Column(name = "organ_name", length = Integer.MAX_VALUE)
    private String organName;

    @Column(name = "water_user_name", length = Integer.MAX_VALUE)
    private String waterUserName;

    @Column(name = "water_user_inn", length = Integer.MAX_VALUE)
    private String waterUserInn;

    @Column(name = "water_user_ogrn", length = Integer.MAX_VALUE)
    private String waterUserOgrn;

    @Column(name = "water_user_okato", length = Integer.MAX_VALUE)
    private String waterUserOkato;

    @Column(name = "water_user_address", length = Integer.MAX_VALUE)
    private String waterUserAddress;

    @Column(name = "payment_rate_change_period", length = Integer.MAX_VALUE)
    private String paymentRateChangePeriod;

    @Column(name = "organ_bank_number", length = Integer.MAX_VALUE)
    private String organBankNumber;

    @Column(name = "organ_bank_name", length = Integer.MAX_VALUE)
    private String organBankName;

    @Column(name = "organ_bank_inn", length = Integer.MAX_VALUE)
    private String organBankInn;

    @Column(name = "organ_bank_kpp", length = Integer.MAX_VALUE)
    private String organBankKpp;

    @Column(name = "organ_bank_bik", length = Integer.MAX_VALUE)
    private String organBankBik;

    @Column(name = "organ_bank_oktmo", length = Integer.MAX_VALUE)
    private String organBankOktmo;

    @Column(name = "observation_program_points", length = Integer.MAX_VALUE)
    private String observationProgramPoints;

    @Column(name = "usage_period", length = Integer.MAX_VALUE)
    private String usagePeriod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kbk_id")
    private AsvKbkEntity kbk;

    @Column(name = "old_code", length = Integer.MAX_VALUE)
    private String oldCode;

    @Column(name = "reg_date")
    private LocalDate regDate;

    @Column(name = "order_number", length = Integer.MAX_VALUE)
    private String orderNumber;

    @Column(name = "auction", length = Integer.MAX_VALUE)
    private String auction;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "isolated_water_use_id")
    private AsvIsolatedWaterUseEntity isolatedWaterUse;

    @Column(name = "parameter_show")
    private Integer parameterShow;

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
        AsvContractEntity that = (AsvContractEntity) o;
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
