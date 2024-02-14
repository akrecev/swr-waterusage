package ru.rosniivh.swr.domain.catalog.asv;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AsvContractDto {
    private Integer id;
    private String conclusionPlace;
    private LocalDate signDate;
    private String regNumber;
    private LocalDate wuBeginDate;
    private LocalDate wuEndDate;
    private LocalDate stopDate;
    private String organFio;
    private String organBasis;
    private String waterUserFio;
    private String waterUserBasis;
    private Integer waterObjectId;
    private String letterWoType;
    private String letterAim;
    private String wuKind;
    private String letterMethod;
    private String letterInfluence;
    private String location;
    private Integer hasParamCalc;
    private Double morfLength;
    private Double morfDistanceFrom;
    private Double morfDistanceTo;
    private Double morfSquare;
    private Double morfUsefulVolume;
    private Double morfVolume;
    private Double morfDepthMin;
    private Double morfDephtAvg;
    private Double morfDepthMax;
    private String morfOther;
    private Double hydrCons;
    private Double hydrDrainVolume;
    private Double hydrSpeedMin;
    private Double hydrSpeedMax;
    private Double hydrLevelAmplitude;
    private String hydrAdversePeriod;
    private String hydrOther;
    private LocalDate qualDate;
    private String qualOther;
    private String paramMethod;
    private String wuStartPeriod;
    private Integer hasObservationProgram;
    private String organText;
    private Integer needWithdrawalReport;
    private String fineOrder;
    private String penaltyOrder;
    private Integer assigneeId;
    private String transferDocNum;
    private LocalDate transferDocDate;
    private LocalDate transfetDocEndDate;
    private String transferStatus;
    private String notes;
    private String organName;
    private String waterUserName;
    private String waterUserInn;
    private String waterUserOgrn;
    private String waterUserOkato;
    private String waterUserAddress;
    private String paymentRateChangePeriod;
    private String organBankNumber;
    private String organBankName;
    private String organBankInn;
    private String organBankKpp;
    private String organBankBik;
    private String organBankOktmo;
    private String observationProgramPoints;
    private String usagePeriod;
    private String oldCode;
    private LocalDate regDate;
    private String orderNumber;
    private String auction;
}
