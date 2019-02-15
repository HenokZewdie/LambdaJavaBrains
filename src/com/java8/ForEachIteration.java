package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ForEachIteration {

	public static void main(String[] args) {
		List<PersonData> listPerson = Arrays.asList
				(new PersonData("Henok", "Zewdie", 33),
				new PersonData("Mena", "Henok", 5), 
				new PersonData("Eliana", "Henok", 3),
				new PersonData("Emuti", "Ashenafi", 32));

		//Forloop
		System.out.println("By For Loop");
		for(int i=0; i<listPerson.size(); i++){
			System.out.println(listPerson.get(i));
		}
		//For in
		System.out.println("By For in");
		for(PersonData pd: listPerson){
			System.out.println(pd);
		}
		System.out.println("By Foreach");
		//foreach with methodReference
		listPerson.forEach(System.out::println);
		System.out.println("By Forach2");
		//foreach with lambda
		listPerson.forEach(a -> System.out.println(a.getLastName()));
		System.out.println("Stream");
		//stream
		listPerson.stream()
		.filter(a -> a.getAge() < 8) //Intermediate 
		.forEach(p->System.out.println(p.getFirstName())); //Terminate
		System.out.println("#############################S");
		Stream<PersonData> test = listPerson.stream().filter(a->a.getFirstName().startsWith("E"));
		test.map(a->a.getLastName().equalsIgnoreCase("henok")).forEach(System.out::println);
	}

}
