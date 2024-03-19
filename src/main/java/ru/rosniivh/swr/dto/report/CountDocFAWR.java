package ru.rosniivh.swr.dto.report;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CountDocFAWR {
    private Integer uid;
    private String regNum;
    private LocalDate singDate;
    private Integer docType;
    private Integer status;
    private Integer uidOrg;
    private String nameOrg;
    private Integer orgType;
    private Integer uidRfDoc;
    private String nameRfDoc;
    private Integer uidRfOrg;
    private String nameRfOrg;
}
