package com.modernJava8.stream_ch3;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamExamples2 {
    private static final List<Integer> NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static void main(String[] args) {

        Stream.of(1, 2, 3, 4, 5)
                .forEach(i -> System.out.print(i + " "));
        System.out.println("\n==================================");

        Integer result = null;
        for (final Integer number : NUMBERS) {
            if (number > 3 && number < 9) {
                final Integer newNumber = number * 2;
                if (newNumber > 10) {
                    result = newNumber;
                    break;
                }
            }
        }
        System.out.println("\n==================================");
        System.out.println("Imperative Result: " + result);

        Optional<Integer> resultStream = NUMBERS.stream()
                .filter(number -> number > 3 && number < 9)
                .map(number -> number * 2)
                .filter(number -> number > 10)
                .findFirst();

        System.out.println(resultStream);

    }
}