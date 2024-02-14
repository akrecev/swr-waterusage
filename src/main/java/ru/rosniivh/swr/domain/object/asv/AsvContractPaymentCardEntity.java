package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_contract_payment_card", schema = "dbo")
public class AsvContractPaymentCardEntity {
    @Id
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "card_date")
    private LocalDate cardDate;

    @Column(name = "card_num", length = Integer.MAX_VALUE)
    private String cardNum;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @Column(name = "begin_date")
    private LocalDate beginDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "executor", length = Integer.MAX_VALUE)
    private String executor;

    @Column(name = "reg_number", length = Integer.MAX_VALUE)
    private String regNumber;

    @Column(name = "reg_date")
    private LocalDate regDate;

    @Column(name = "old_code", length = Integer.MAX_VALUE)
    private String oldCode;

    @Column(name = "mark_del")
    private Integer markDel;

}