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
public class AsvDocumentResponse {
    private String regNumber;
    private LocalDate regDate;
    private Integer asvRegType;
}
