package ru.rosniivh.swr.dto.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
        this.name = name + " от " +  code.format(pattern);
        this.code = type;
    }
}
