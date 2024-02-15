package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_documents", schema = "dbo")
public class AsvDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "doc_type_id")
    private Integer docTypeId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "sign_date")
    private LocalDate signDate;

    @Column(name = "reg_date")
    private LocalDate regDate;

    @Column(name = "rfs_id")
    private Integer rfsId;

    @Column(name = "organ_id")
    private Integer organId;

    @Column(name = "hep_id")
    private Integer hepId;

    @Column(name = "aim_id")
    private Integer aimId;

    @Column(name = "wu_kind_id")
    private Integer wuKindId;

    @Column(name = "method_id")
    private Integer methodId;

    @Column(name = "influence_id")
    private Integer influenceId;

    @Column(name = "reg_number", length = Integer.MAX_VALUE)
    private String regNumber;

    @Column(name = "wu_begin_date")
    private LocalDate wuBeginDate;

    @Column(name = "wu_end_date")
    private LocalDate wuEndDate;

    @Column(name = "water_user_id")
    private Integer waterUserId;

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