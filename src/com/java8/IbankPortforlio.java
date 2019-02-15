package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IbankPortforlio {

	public static void main(String[] args) {
		List<String> accountStatusICMS = Arrays.asList("Open", "Active", "Active9", "Pending", "DRE");
		System.out.println("Enter AccoutnStatus");
		Scanner scanner = new Scanner(System.in);
		String value = scanner.nextLine();
				 
		if(accountStatusICMS.stream().anyMatch(a->a.equalsIgnoreCase(value))){
			System.out.println("Available");
		}else{
			System.out.println("No Available");
		}
		
		scanner.close();
	}
	
	
}
