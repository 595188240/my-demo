package com.test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

/**
 * @author ffdeng2
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        intList.stream().forEach(i -> System.out.println(i));

        long between = ChronoUnit.DAYS.between(LocalDate.of(2021, 7, 20), LocalDate.now());
        System.out.println(between);
    }

}
