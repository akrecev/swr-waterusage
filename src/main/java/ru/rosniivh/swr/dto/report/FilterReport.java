package ru.rosniivh.swr.dto.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    public FilterReport(Integer uid, String name, Date code, String type) {
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        this.uid = uid;
        this.name = name + " от " +  formatter.format(code);
        this.code = type;
    }
}
