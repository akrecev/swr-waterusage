package ru.rosniivh.swr.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "o_asv_contract_transfer", schema = "dbo")
public class AsvContractTransferEntity {
    @Id
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "conclusion_place")
    private String conclusionPlace;

    @Column(name = "sign_date")
    private LocalDate signDate;

    @Column(name = "reg_date")
    private LocalDate regDate;

    @Lob
    @Column(name = "reg_number")
    private String regNumber;

    @Lob
    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "wu_end_date")
    private LocalDate wuEndDate;

    @Column(name = "stop_date")
    private LocalDate stopDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "rightholder_id")
    private AsvImportLegalSubjectEntity rightholder;

    @Lob
    @Column(name = "rightholder_firstname")
    private String rightholderFirstname;

    @Lob
    @Column(name = "rightholder_middlename")
    private String rightholderMiddlename;

    @Lob
    @Column(name = "rightholder_lastname")
    private String rightholderLastname;

    @Lob
    @Column(name = "rightholder_post")
    private String rightholderPost;

    @Lob
    @Column(name = "rightholder_basis")
    private String rightholderBasis;

    @Column(name = "assignee_id")
    private Integer assigneeId;

    @Lob
    @Column(name = "assignee_firstname")
    private String assigneeFirstname;

    @Lob
    @Column(name = "assignee_middlename")
    private String assigneeMiddlename;

    @Lob
    @Column(name = "assignee_lastname")
    private String assigneeLastname;

    @Lob
    @Column(name = "assignee_post")
    private String assigneePost;

    @Lob
    @Column(name = "assignee_basis")
    private String assigneeBasis;

    @Column(name = "payment")
    private BigDecimal payment;

    @Lob
    @Column(name = "notes")
    private String notes;

    @Lob
    @Column(name = "old_code")
    private String oldCode;

}