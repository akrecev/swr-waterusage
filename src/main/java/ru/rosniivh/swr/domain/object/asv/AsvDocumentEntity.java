package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import lombok.*;
import ru.rosniivh.swr.domain.catalog.RfSubjectEntity;
import ru.rosniivh.swr.domain.catalog.asv.*;
import ru.rosniivh.swr.domain.object.HeParcelEntity;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_documents", schema = "dbo")
public class AsvDocumentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="doc_type_id")
    private AsvRegTypeEntity docType;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="status")
    private AsvStatusEntity status;

    @Column(name = "sign_date")
    private LocalDate signDate;

    @Column(name = "reg_date")
    private LocalDate regDate;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="rfs_id")
    private RfSubjectEntity rfSubject;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JoinColumn(name="organ_id")
    private AsvImportAuthOrgContractEntity organ;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="hep_id")
    private HeParcelEntity hepId;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="aim_id")
    private AsvUsageTargetEntity aim;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="wu_kind_id")
    private AsvWuKindEntity wuKind;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="method_id")
    private AsvWuMethodEntity method;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="influence_id")
    private AsvUsageEffectEntity influence;

    @Column(name = "reg_number", length = Integer.MAX_VALUE)
    private String regNumber;

    @Column(name = "wu_begin_date")
    private LocalDate wuBeginDate;

    @Column(name = "wu_end_date")
    private LocalDate wuEndDate;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="water_user_id")
    private AsvImportLegalSubjectEntity waterUser;

    @Column(name = "conclusion_place", length = Integer.MAX_VALUE)
    private String conclusionPlace;

    @Column(name = "key")
    private Integer key;

    @Column(name = "water_objects", length = Integer.MAX_VALUE)
    private String waterObjects;

    @Column(name = "old_code", length = Integer.MAX_VALUE)
    private String oldCode;

    @Column(name = "npp_registr_form", length = Integer.MAX_VALUE)
    private String nppRegistrForm;

    @Column(name = "registered")
    private Integer registered;

    @Column(name = "date_start")
    private LocalDate dateStart;

    @Column(name = "date_stop")
    private LocalDate dateStop;

    @Column(name = "sz1")
    private Boolean sz1;

    @Column(name = "sz2")
    private Boolean sz2;

    @Column(name = "sz3")
    private Boolean sz3;

    @Column(name = "sz4")
    private Boolean sz4;

    @Column(name = "sz5")
    private Boolean sz5;

    @Column(name = "sz6")
    private Boolean sz6;

    @Column(name = "sz7")
    private Boolean sz7;

    @Column(name = "sz8")
    private Boolean sz8;

    @Column(name = "sz9")
    private Boolean sz9;

    @Column(name = "sz10")
    private Boolean sz10;

    @Column(name = "sz11")
    private Boolean sz11;

    @Column(name = "pa1")
    private Boolean pa1;

    @Column(name = "pa2")
    private Boolean pa2;

    @Column(name = "pa3")
    private Boolean pa3;

    @Column(name = "pa4")
    private Boolean pa4;

    @Column(name = "pa5")
    private Boolean pa5;

    @Column(name = "pa6")
    private Boolean pa6;

    @Column(name = "order2054")
    private Boolean order2054;

    @Column(name = "mark_del")
    private Boolean markDel;

    @Column(name = "dop_terminated")
    private Boolean dopTerminated;

}