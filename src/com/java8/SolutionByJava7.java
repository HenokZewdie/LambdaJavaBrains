package com.java8;

import java.util.*;

public class SolutionByJava7 {

	public static void main(String[] args) {
		List<PersonData> listPerson = Arrays.asList
				(new PersonData("Henok", "Zewdie", 33),
				new PersonData("Mena", "Henok", 5), 
				new PersonData("Eliana", "Henok", 3),
				new PersonData("Emuti", "Ashenafi", 32));

		// Sort all by FirstName
		Collections.sort(listPerson, new Comparator<PersonData>() {
			@Override
			public int compare(PersonData arg0, PersonData arg1) {
				return arg0.getFirstName().compareToIgnoreCase(arg1.getFirstName());
			}
		});
		// Print All the elements
		System.out.println("Print ALL");
		printAllP(listPerson);
		// Print all the elements that are my children
		System.out.println();
		System.out.println("My Children");
		
		myChilderen(listPerson);
		//Print by Condition
		
		System.out.println();
		System.out.println("Name start with E");
		
		printByCondition(listPerson, new Condition() {	
			@Override
			public boolean CheckstartWith(PersonData data) {
				return data.getFirstName().startsWith("E");
			}
		});
		System.out.println();
		System.out.println("Name start with M");
		
		printByCondition(listPerson, new Condition() {
			
			@Override
			public boolean CheckstartWith(PersonData data) {
				return data.getFirstName().startsWith("M");
			}
		});
	}

	public static void printAllP(List<PersonData> listPerson) {
		for (PersonData p : listPerson) {
			System.out.println(p);
		}
	}

	public static void printByCondition(List<PersonData> listPerson, Condition condition) {
		for (PersonData p : listPerson) {
			if (condition.CheckstartWith(p)) {
				System.out.println(p);
			}

		}
	}

	public static void myChilderen(List<PersonData> listPerson) {
		for (PersonData data : listPerson) {
			if (data.getLastName().startsWith("H")) {
				System.out.println(data.getFirstName() + " is my daughter");
			}
		}
	}
}

interface Condition {
	boolean CheckstartWith(PersonData data);
}