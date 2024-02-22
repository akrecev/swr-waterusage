package ru.rosniivh.swr.dto.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthOrgFilterReport {
    private Integer uid;
    private String fullname;
    private String code;
}
