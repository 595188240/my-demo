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
        //Optional<Integer> result1 = intList.stream().reduce(Integer::sum);
        //System.out.println(result1.get());

        //Integer reduce = intList.stream().reduce(100, Integer::sum);
        //System.out.println(reduce);

        //Integer reduce = intList.parallelStream().reduce(100, Integer::sum);
        //System.out.println(reduce);

        long between = ChronoUnit.DAYS.between(LocalDate.of(2021, 7, 20), LocalDate.now());
        System.out.println(between);
    }

}
