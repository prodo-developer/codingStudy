package com.modernJava8.chapter2;

import java.util.function.Consumer;

/**
 * 컨슈머 실습
 */
public class ConsumerTest {
    public static void main(String[] args) {

        // 1차 실습
        Consumer<String> print = new Consumer<String>() {
            @Override
            public void accept(String value) {
                System.out.println(value);
            }
        };

        print.accept("hello");

        // 람다 실습
        Consumer<String> print2 = value -> System.out.println("Hello " + value);

        print2.accept("prodo");
        print2.accept("sungrak");
    }
}