package ru.rosniivh.swr.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.YearMonth;

import static java.time.temporal.IsoFields.QUARTER_OF_YEAR;

@UtilityClass
public final class ForServiceUtil {

    public static LocalDate startQuarterDate(Integer year, Integer quarter) {
        return YearMonth.of(year, 1).with(QUARTER_OF_YEAR, quarter).atDay(1);
    }

    public static LocalDate endQuarterDate(Integer year, Integer quarter) {
        return YearMonth.of(year, 3).with(QUARTER_OF_YEAR, quarter).atEndOfMonth();
    }
}
