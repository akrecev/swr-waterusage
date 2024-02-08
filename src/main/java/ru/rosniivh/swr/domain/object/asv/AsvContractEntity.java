package ru.rosniivh.swr.domain.object.asv;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_contract", schema = "dbo")
public class AsvContractEntity {
    @Id
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "conclusion_place")
    private String conclusionPlace;

    @Column(name = "sign_date")
    private LocalDate signDate;

    @Lob
    @Column(name = "reg_number")
    private String regNumber;

    @Column(name = "wu_begin_date")
    private LocalDate wuBeginDate;

    @Column(name = "wu_end_date")
    private LocalDate wuEndDate;

    @Column(name = "stop_date")
    private LocalDate stopDate;

    @Lob
    @Column(name = "organ_fio")
    private String organFio;

    @Lob
    @Column(name = "organ_basis")
    private String organBasis;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "water_user_id")
    private AsvImportLegalSubjectEntity waterUser;

    @Lob
    @Column(name = "water_user_fio")
    private String waterUserFio;

    @Lob
    @Column(name = "water_user_basis")
    private String waterUserBasis;

    @Column(name = "water_object_id")
    private Integer waterObjectId;

    @Lob
    @Column(name = "letter_wo_type")
    private String letterWoType;

    @Lob
    @Column(name = "letter_aim")
    private String letterAim;

    @Lob
    @Column(name = "wu_kind")
    private String wuKind;

    @Lob
    @Column(name = "letter_method")
    private String letterMethod;

    @Lob
    @Column(name = "letter_influence")
    private String letterInfluence;

    @Lob
    @Column(name = "location")
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

    @Lob
    @Column(name = "morf_other")
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

    @Lob
    @Column(name = "hydr_adverse_period")
    private String hydrAdversePeriod;

    @Lob
    @Column(name = "hydr_other")
    private String hydrOther;

    @Column(name = "qual_date")
    private LocalDate qualDate;

    @Lob
    @Column(name = "qual_other")
    private String qualOther;

    @Lob
    @Column(name = "param_method")
    private String paramMethod;

    @Lob
    @Column(name = "wu_start_period")
    private String wuStartPeriod;

    @Column(name = "has_observation_program")
    private Integer hasObservationProgram;

    @Lob
    @Column(name = "organ_text")
    private String organText;

    @Column(name = "need_withdrawal_report")
    private Integer needWithdrawalReport;

    @Lob
    @Column(name = "fine_order")
    private String fineOrder;

    @Lob
    @Column(name = "penalty_order")
    private String penaltyOrder;

    @Column(name = "assignee_id")
    private Integer assigneeId;

    @Lob
    @Column(name = "transfer_doc_num")
    private String transferDocNum;

    @Column(name = "transfer_doc_date")
    private LocalDate transferDocDate;

    @Column(name = "transfet_doc_end_date")
    private LocalDate transfetDocEndDate;

    @Lob
    @Column(name = "transfer_status")
    private String transferStatus;

    @Lob
    @Column(name = "notes")
    private String notes;

    @Lob
    @Column(name = "organ_name")
    private String organName;

    @Lob
    @Column(name = "water_user_name")
    private String waterUserName;

    @Lob
    @Column(name = "water_user_inn")
    private String waterUserInn;

    @Lob
    @Column(name = "water_user_ogrn")
    private String waterUserOgrn;

    @Lob
    @Column(name = "water_user_okato")
    private String waterUserOkato;

    @Lob
    @Column(name = "water_user_address")
    private String waterUserAddress;

    @Lob
    @Column(name = "payment_rate_change_period")
    private String paymentRateChangePeriod;

    @Lob
    @Column(name = "organ_bank_number")
    private String organBankNumber;

    @Lob
    @Column(name = "organ_bank_name")
    private String organBankName;

    @Lob
    @Column(name = "organ_bank_inn")
    private String organBankInn;

    @Lob
    @Column(name = "organ_bank_kpp")
    private String organBankKpp;

    @Lob
    @Column(name = "organ_bank_bik")
    private String organBankBik;

    @Lob
    @Column(name = "organ_bank_oktmo")
    private String organBankOktmo;

    @Lob
    @Column(name = "observation_program_points")
    private String observationProgramPoints;

    @Lob
    @Column(name = "usage_period")
    private String usagePeriod;

    @Lob
    @Column(name = "old_code")
    private String oldCode;

    @Column(name = "reg_date")
    private LocalDate regDate;

    @Lob
    @Column(name = "order_number")
    private String orderNumber;

    @Lob
    @Column(name = "auction")
    private String auction;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        AsvContractEntity that = (AsvContractEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}