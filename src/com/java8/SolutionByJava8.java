package com.java8;

import java.util.*;

public class SolutionByJava8 {

	public static void main(String[] args) {
		List<PersonData> listPerson = Arrays.asList(
				new PersonData("Henok", "Zewdie", 33),
				new PersonData("Mena", "Henok", 5), 
				new PersonData("Eliana", "Henok", 3),
				new PersonData("Emuti", "Ashenafi", 32));

	/*	// Sort all by FirstName
		Collections.sort(listPerson, new Comparator<PersonData>() {
			@Override
			public int compare(PersonData arg0, PersonData arg1) {
				return arg0.getFirstName().compareToIgnoreCase(arg1.getFirstName());
			}
		});*/
		//Java8 Equivalent Line 13-18
		Collections.sort(listPerson, (arg0, arg1)->arg0.getFirstName().compareToIgnoreCase(arg1.getFirstName()));
		
		// Print All the elements
		System.out.println("Print ALL");
		//printAllP(listPerson);
		printByCondition(listPerson, p ->true);
		
		
		// Print all the elements that are my children
		System.out.println();
		System.out.println("My Children");
		//myChilderen(listPerson);
		printByCondition(listPerson, t->t.getLastName().startsWith("H"));
		
		//Print by Condition
		System.out.println();
		System.out.println("Name start with E");
		
/*		printByCondition(listPerson, new Condition() {	
			@Override
			public boolean CheckstartWith(PersonData data) {
				return data.getFirstName().startsWith("E");
			}
		});*/
		//Java8 Equivalent line 35-40
		printByCondition(listPerson, data -> data.getFirstName().startsWith("E"));
		
		System.out.println();
		System.out.println("Name start with M");
		
		/*printByCondition(listPerson, new Condition() {
			
			@Override
			public boolean CheckstartWith(PersonData data) {
				return data.getFirstName().startsWith("M");
			}
		});*/
		
		printByCondition(listPerson, dre -> dre.getFirstName().startsWith("M"));
		listPerson.forEach(a -> System.out.println(a));
	}

	/*public static void printAllP(List<PersonData> listPerson) {
		for (PersonData p : listPerson) {
			System.out.println(p);
		}
	}*/

	public static void printByCondition(List<PersonData> listPerson, Condition condition) {
		for (PersonData p : listPerson) {
			if (condition.CheckstartWith(p)) {
				System.out.println(p);
			}

		}
	}

	/*public static void myChilderen(List<PersonData> listPerson) {
		for (PersonData data : listPerson) {
			if (data.getLastName().startsWith("H")) {
				System.out.println(data.getFirstName() + " is my daughter");
			}
		}
	}*/
}