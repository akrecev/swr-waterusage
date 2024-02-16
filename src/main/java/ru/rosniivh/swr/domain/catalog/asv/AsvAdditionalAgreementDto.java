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
public class AsvAdditionalAgreementDto {

    private Integer id;
    private Integer contractId;
    private String regNumber;
    private String addAgrNumber;
    private LocalDate signDate;
    private LocalDate regDate;
    private Integer npp;
    private String wuStartPeriod;
    private Integer hasObservationProgram;
    private String observationProgramPoints;
    private String organText;
    private String organName;
    private String organFio;
    private String organBasis;
    private String waterUserName;
    private String waterUserFio;
    private String waterUserBasis;
    private String notes;
    private String oldCode;
    private String orderNumber;
}
