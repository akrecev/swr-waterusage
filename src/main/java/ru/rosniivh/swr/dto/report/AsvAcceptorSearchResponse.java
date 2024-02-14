package ru.rosniivh.swr.dto.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AsvAcceptorSearchResponse {
    private int uid;
    private String fio;
    private String position;
    private String basis;
    private String notes;
    private Integer authOrgId;
    private String authOrgName;
}
