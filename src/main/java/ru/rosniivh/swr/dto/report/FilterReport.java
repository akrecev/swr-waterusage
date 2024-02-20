package ru.rosniivh.swr.dto.report;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FilterReport {
    private Integer uid;
    private String name;
    private String code;
    private Integer numCode;

    public FilterReport(Integer uid, String name, LocalDate code, String type) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.uid = uid;
        this.name = name + " от " + code.format(pattern);
        this.code = type;
    }
}
