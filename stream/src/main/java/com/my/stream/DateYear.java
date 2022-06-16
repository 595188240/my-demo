package com.my.stream;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @author ffdeng2
 * @date 2022-6-1 10:13
 */
public class DateYear {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.of(2016, 3, 1), LocalTime.of(0, 0));
        LocalDateTime tempDateTime = LocalDateTime.from(localDateTime);
        long year = tempDateTime.until(now, ChronoUnit.YEARS);
        System.out.println(year);
        now = now.minusYears(year);
        System.out.println(now);
        long month = tempDateTime.until(now, ChronoUnit.MONTHS);
        System.out.println(month);
        now = now.minusMonths(month);
        System.out.println(now);
        long days = tempDateTime.until(now, ChronoUnit.DAYS);
        System.out.println(days);
    }
}
