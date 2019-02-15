package com.mathsOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;

public class NumberInput {

	public static void main(String[] args) {
		
		double number1 = 8;
		double number2 = 20;
		List<Integer> listNum = new ArrayList<>();
		listNum.add(1);
		listNum.add(2);
		listNum.add(4);
		listNum.add(8);
		
		int keyNum = 2;
		int [] arrayNum = {12,32,44,2};
		
		testa test = ()-> System.out.println("test");
		test.tesing();
		DoubleBinaryOperator add = (num, num2)-> (number1+ number2);
		System.out.println(add.applyAsDouble(number1, number2));
		
		Consumer<Integer> doubleNumber = numN -> System.out.println(2*numN);
		doubleNumber.accept((int) number2);
		
		operateNumber(arrayNum, keyNum, Wrapperconsumer((v, k) -> System.out.println(v / k)));
		operateNumber(listNum, keyNum, (v, k) -> System.out.println(v * k));
		operateNumber(listNum, keyNum, (v,k) -> System.out.println(v+k));
		operateNumber(listNum, keyNum, (v,k) -> System.out.println(v-k));
	}
	/*	This method only print addition but by adding one more parameter, it can perform all mathematical operations
	 * private static void operateNumber(int[] arrayNum, int keyNum) {
			for (int i : arrayNum) {
				System.out.println(i+keyNum);
			}

		}*/
	
	private static void operateNumber(int[] arrayNum, int numa, BiConsumer<Integer, Integer> consumer) {
		for (int i : arrayNum) {
			consumer.accept(i, numa);
		}

	}
	private static void operateNumber(List<Integer> arrayNum, int numa, BiConsumer<Integer, Integer> consumer) {
		for (int i : arrayNum) {
			consumer.accept(i, numa);
		}

	}
	private static BiConsumer<Integer, Integer> Wrapperconsumer(BiConsumer<Integer, Integer> consumer){
		return (v, k) -> {
			try{
				consumer.accept(v, k);
			}catch (ArithmeticException e) {
				System.out.println(e.getMessage() + "  Exception caught");
			}
		};
		
	}

}
interface testa {
	void tesing();
}
