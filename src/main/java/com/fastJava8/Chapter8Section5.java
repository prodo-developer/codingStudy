package com.fastJava8;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 리듀스를 활용한 예제
 */
public class Chapter8Section5 {

    public static void main(String[] args) {
        List<Integer> numbers = Stream.of(3, 5, -3 ,3 ,4, 5)
                .collect(Collectors.toList());
        System.out.println(numbers);

        Set<Integer> collectSet = Stream.of(3, 5, -3, 3, 4, 5)
                .collect(Collectors.toSet());
        System.out.println(collectSet);

        List<Integer> collect = Stream.of(3, 5, -3, 3, 4, 5)
                .collect(Collectors.mapping(x -> Math.abs(x), Collectors.toList()));
        System.out.println(collect);

        Set<Integer> collectSet2 = Stream.of(3, 5, -3, 3, 4, 5)
                .collect(Collectors.mapping(x -> Math.abs(x), Collectors.toSet()));
        System.out.println(collectSet2);

        int sum = Stream.of(3, 5, -3, 3, 4, 5)
                .collect(Collectors.reducing(0, (x, y) -> x + y));
        System.out.println(sum);
    }
}