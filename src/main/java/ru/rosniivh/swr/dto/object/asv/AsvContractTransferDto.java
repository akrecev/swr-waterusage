package ru.rosniivh.swr.dto.object.asv;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AsvContractTransferDto {
    private Integer id;
    private String conclusionPlace;
    private LocalDate signDate;
    private LocalDate regDate;
    private String regNumber;
    private String orderNumber;
    private LocalDate wuEndDate;
    private LocalDate stopDate;
    private String rightholderFirstname;
    private String rightholderMiddlename;
    private String rightholderLastname;
    private String rightholderPost;
    private String rightholderBasis;
    private Integer assigneeId;
    private String assigneeFirstname;
    private String assigneeMiddlename;
    private String assigneeLastname;
    private String assigneePost;
    private String assigneeBasis;
    private BigDecimal payment;
    private String notes;
    private String oldCode;
}
