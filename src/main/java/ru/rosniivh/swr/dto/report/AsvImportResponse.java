package ru.rosniivh.swr.dto.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AsvImportResponse {
    private int uid;
    private String name;
    private String inn;
    private String kpp;
    private String description;
    private Integer authOrg;
}
