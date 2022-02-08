package com.test.stream;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ffdeng2
 */
public class TestSum {

    public static void main(String[] args) {
        List<Integer> list = Stream.of(1, 2, 3, 3, 7, 8, 4, 0).collect(Collectors.toList());
        System.out.println(list.stream().mapToInt(Integer::intValue).sum());

        IntSummaryStatistics intSummaryStatistics = list.stream().mapToInt(s -> s).summaryStatistics();
        System.out.println(intSummaryStatistics.getAverage());

        List<String> list2 = Stream.of("1","3").collect(Collectors.toList());
        System.out.println(list2.stream().mapToInt(Integer::parseInt).sum());
    }

}
