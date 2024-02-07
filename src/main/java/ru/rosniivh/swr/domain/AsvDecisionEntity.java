package ru.rosniivh.swr.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "o_asv_decision", schema = "dbo")
public class AsvDecisionEntity {
    @Id
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "is_new_decision")
    private Integer isNewDecision;

    @Column(name = "is_defense")
    private Integer isDefense;

    @Lob
    @Column(name = "conclusion_place")
    private String conclusionPlace;

    @Column(name = "sign_date")
    private LocalDate signDate;

    @Lob
    @Column(name = "decision_number")
    private String decisionNumber;

    @Lob
    @Column(name = "reg_number")
    private String regNumber;

    @Lob
    @Column(name = "order_number")
    private String orderNumber;

    @Lob
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

    @Lob
    @Column(name = "period_text")
    private String periodText;

    @Lob
    @Column(name = "organ_fio")
    private String organFio;

    @Lob
    @Column(name = "organ_lastname")
    private String organLastname;

    @Lob
    @Column(name = "organ_firstname")
    private String organFirstname;

    @Lob
    @Column(name = "organ_middlename")
    private String organMiddlename;

    @Lob
    @Column(name = "organ_post")
    private String organPost;

    @Lob
    @Column(name = "organ_basis")
    private String organBasis;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "water_user_id")
    private AsvImportLegalSubjectEntity waterUser;

    @Lob
    @Column(name = "letter_wo_type")
    private String letterWoType;

    @Lob
    @Column(name = "letter_aim")
    private String letterAim;

    @Lob
    @Column(name = "aim_notes")
    private String aimNotes;

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

    @Column(name = "need_report_withdrawal")
    private Integer needReportWithdrawal;

    @Column(name = "need_report_discharge")
    private Integer needReportDischarge;

    @Column(name = "need_report_quality")
    private Integer needReportQuality;

    @Lob
    @Column(name = "old_code")
    private String oldCode;

    @Lob
    @Column(name = "old_parent_code")
    private String oldParentCode;

    @Lob
    @Column(name = "var_num")
    private String varNum;

}