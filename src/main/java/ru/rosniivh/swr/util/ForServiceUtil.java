package ru.rosniivh.swr.util;

import static java.time.temporal.IsoFields.QUARTER_OF_YEAR;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class ForServiceUtil {

    public static LocalDate startQuarterDate(Integer year, Integer quarter) {
        return YearMonth.of(year, 1).with(QUARTER_OF_YEAR, quarter).atDay(1);
    }

    public static LocalDate endQuarterDate(Integer year, Integer quarter) {
        return YearMonth.of(year, 3).with(QUARTER_OF_YEAR, quarter).atEndOfMonth();
    }

    public static Integer findArray(List<Integer> items, Integer item) {
        for (int i = 0; i < items.size(); i++) {
            if (item == items.get(i)) {
                return i;
            }
        }
        return -1;
    }
}
