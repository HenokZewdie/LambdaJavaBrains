package com.mathsOperation;

import java.util.function.BiConsumer;
import java.util.function.Function;

public class ExceptionHandling {

	public static void main(String[] args) {

		int numa = 0;
		int[] arrayNum = { 12, 32, 44, 2 };

		//Anonymous class... can ONLY create one instance
		 BiConsumer<Integer, String> consumer = new BiConsumer<Integer, String>() {
			
			@Override
			public void accept(Integer t, String u) {
				System.out.println(t + u);
			}
		};
		
		BiConsumer<Integer, String> consumer2 = (t, u) -> System.out.println(t+u);
		Function<Integer, String> fun = new Function<Integer, String>(){

			@Override
			public String apply(Integer t) {
				int k = Integer.sum(78, 8);
				return t.toString();
			}
			
		};
		Function<Integer, String> fun1 = t-> {
				int k = Integer.sum(78, 8);
				return t.toString();
			};
		
		
		operateNumber(arrayNum, numa, Wrapperconsumer((v, k) -> System.out.println(v / k)));
	}
	
	private static void operateNumber(int[] arrayNum, int numa, BiConsumer<Integer, Integer> consumer) {
		for (int i : arrayNum) {
			consumer.accept(i, numa);
		}

	}

	private static BiConsumer<Integer, Integer> Wrapperconsumer(BiConsumer<Integer, Integer> consumer) {
		return (v, k) -> {
			try {
				consumer.accept(v, k);
			} catch (ArithmeticException e) {
				System.out.println(e.getMessage() + "  Exception caught");
			}
		};

	}

}
