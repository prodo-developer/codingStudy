package com.fastJava8;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
1. BiFunction은 2개의 인자(Type T, U)를 받고 1개의 객체(Type R)를 리턴하는 함수형 인터페이스
2. apply()에 2개의 인자를 전달하면 그 결과가 리턴
**/
public class Chapter9Section1 {

	public static void main(String[] args) {
		Supplier<String> supplier = getStringSupplier();
		System.out.println(supplier.get());
		
		BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
		Function<Integer, Function<Integer, Integer>> curriedAdd = x -> y -> x + y;
		
		Function<Integer, Integer> addThree = curriedAdd.apply(3);
		int result = addThree.apply(10);
		System.out.println(result);
	}

	public static Supplier<String> getStringSupplier() {
		String hello = "Hello";
		Supplier<String> supplier = () -> {
			String world = "World";
			return hello + world;
		};
		
		return supplier;
	}
}
