package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Objects;

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

    @Column(name = "conclusion_place")
    private String conclusionPlace;

    @Column(name = "sign_date")
    private LocalDate signDate;

    @Column(name = "reg_number")
    private String regNumber;

    @Column(name = "wu_begin_date")
    private LocalDate wuBeginDate;

    @Column(name = "wu_end_date")
    private LocalDate wuEndDate;

    @Column(name = "stop_date")
    private LocalDate stopDate;

    @Column(name = "organ_fio")
    private String organFio;

    @Column(name = "organ_basis")
    private String organBasis;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "water_user_id")
    private AsvImportLegalSubjectEntity waterUser;

    @Column(name = "water_user_fio")
    private String waterUserFio;

    @Column(name = "water_user_basis")
    private String waterUserBasis;

    @Column(name = "water_object_id")
    private Integer waterObjectId;

    @Column(name = "letter_wo_type")
    private String letterWoType;

    @Column(name = "letter_aim")
    private String letterAim;

    @Column(name = "wu_kind")
    private String wuKind;

    @Column(name = "letter_method")
    private String letterMethod;

    @Column(name = "letter_influence")
    private String letterInfluence;

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

    @Column(name = "hydr_adverse_period")
    private String hydrAdversePeriod;

    @Column(name = "hydr_other")
    private String hydrOther;

    @Column(name = "qual_date")
    private LocalDate qualDate;

    @Column(name = "qual_other")
    private String qualOther;

    @Column(name = "param_method")
    private String paramMethod;

    @Column(name = "wu_start_period")
    private String wuStartPeriod;

    @Column(name = "has_observation_program")
    private Integer hasObservationProgram;

    @Column(name = "organ_text")
    private String organText;

    @Column(name = "need_withdrawal_report")
    private Integer needWithdrawalReport;

    @Column(name = "fine_order")
    private String fineOrder;

    @Column(name = "penalty_order")
    private String penaltyOrder;

    @Column(name = "assignee_id")
    private Integer assigneeId;

    @Column(name = "transfer_doc_num")
    private String transferDocNum;

    @Column(name = "transfer_doc_date")
    private LocalDate transferDocDate;

    @Column(name = "transfet_doc_end_date")
    private LocalDate transfetDocEndDate;

    @Column(name = "transfer_status")
    private String transferStatus;

    @Column(name = "notes")
    private String notes;

    @Column(name = "organ_name")
    private String organName;

    @Column(name = "water_user_name")
    private String waterUserName;

    @Column(name = "water_user_inn")
    private String waterUserInn;

    @Column(name = "water_user_ogrn")
    private String waterUserOgrn;

    @Column(name = "water_user_okato")
    private String waterUserOkato;

    @Column(name = "water_user_address")
    private String waterUserAddress;

    @Column(name = "payment_rate_change_period")
    private String paymentRateChangePeriod;

    @Column(name = "organ_bank_number")
    private String organBankNumber;

    @Column(name = "organ_bank_name")
    private String organBankName;

    @Column(name = "organ_bank_inn")
    private String organBankInn;

    @Column(name = "organ_bank_kpp")
    private String organBankKpp;

    @Column(name = "organ_bank_bik")
    private String organBankBik;

    @Column(name = "organ_bank_oktmo")
    private String organBankOktmo;

    @Column(name = "observation_program_points")
    private String observationProgramPoints;

    @Column(name = "usage_period")
    private String usagePeriod;

    @Column(name = "old_code")
    private String oldCode;

    @Column(name = "reg_date")
    private LocalDate regDate;

    @Column(name = "order_number")
    private String orderNumber;

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