package ru.rosniivh.swr.dto.object.asv;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.rosniivh.swr.domain.object.asv.AsvImportLegalSubjectEntity;

import javax.persistence.*;
import java.time.LocalDate;

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
    private String organLastname;
    private String organFirstname;
    private String organMiddlename;
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
