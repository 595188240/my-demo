package com.test.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ffdeng2
 */
public class TestReduce {

    public static void main(String[] args) {
        List<Integer> list = Stream.of(1, 2, 3, 3, 7, 8, 4, 0).collect(Collectors.toList());
        Integer reduce = list.stream().reduce((x, y) -> x + y).get();
        System.out.println(reduce);
    }

}
