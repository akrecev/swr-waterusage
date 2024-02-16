package ru.rosniivh.swr.dto.object.asv;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AsvDecisionDto {
    private Integer id;
    private Integer isNewDecision;
    private Integer isDefense;
    private String conclusionPlace;
    private LocalDate signDate;
    private String decisionNumber;
    private String regNumber;
    private String orderNumber;
    private String addNumber;
    private LocalDate regDate;
    private LocalDate wuBeginDate;
    private LocalDate wuEndDate;
    private LocalDate stopDate;
    private String periodText;
    private String organFio;
    private String organLastName;
    private String organFirstName;
    private String organMiddleName;
    private String organPost;
    private String organBasis;
    private String letterWoType;
    private String letterAim;
    private String aimNotes;
    private String wuKind;
    private String letterMethod;
    private String letterInfluence;
    private String location;
    private Integer needReportWithdrawal;
    private Integer needReportDischarge;
    private Integer needReportQuality;
    private String oldCode;
    private String oldParentCode;
    private String varNum;
}
