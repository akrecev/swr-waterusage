package ru.rosniivh.swr.dto.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AsvDocumentResponse {
    private String regNumber;
    private LocalDate regDate;
    private Integer asvRegType;
}
