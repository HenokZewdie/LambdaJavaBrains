package com.java8;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SolutionByJavaSimplified {

	public static void main(String[] args) {
		List<PersonData> listPerson = Arrays.asList(
				new PersonData("Henok", "Zewdie", 33),
				new PersonData("Ermias", "Zewdie", 33),
				new PersonData("Tizita", "Zewdie", 5),
				new PersonData("Mena", "Henok", 5), 
				new PersonData("Eliana", "Henok", 3),
				new PersonData("Raya", "Ameha", 35), 
				new PersonData("Taeme", "Ameha", 25),
				new PersonData("Ameha", "Fisseha", 25),
				new PersonData("Meti", "Fikre", 3),
				new PersonData("Hawi", "Fikre", 35), 
				new PersonData("Emuti", "Ashenafi", 32),
				new PersonData("Zewdie", "Wordoffa", 33),
				new PersonData("Fikre", "Gudeta", 33),
				new PersonData("Tigist", "Ashenafi", 32));

		for(PersonData ln: listPerson){
			for(PersonData fn: listPerson){
				if(fn.getLastName().equalsIgnoreCase(ln.getFirstName())){
					System.out.println(ln.getFirstName() + "  "  + ln.getLastName() +  " Matchs");
				}
			}
		}
	List<PersonData> ageList = listPerson.stream()
										.filter(b -> b.getAge() > 10)
										.collect(Collectors.toList());
	List<Integer> newList = new ArrayList<>();
		for(PersonData as: ageList){
			newList.add(as.getAge());
		}
		//Sort by FirstName in the reverse order by changing the argument 
		Collections.sort(listPerson, (a, b)->b.getFirstName().compareTo(a.getFirstName()));
		
		//Check from the list if the age is less than 10 and FirstName is start with M == Mena
		listPerson.stream().allMatch(a->a.getAge()<10 && a.getFirstName().startsWith("M")); // returns boolean
		
		// Print All the elements (p ->true Functor)
		printByCondition(listPerson, p ->true, p->System.out.println(p));
		//listPerson
		
		System.out.println();
		System.out.println("My Children");
		printByCondition(listPerson, t->t.getLastName().startsWith("H"), t->System.out.println(t));
		
		System.out.println();
		System.out.println("Name start with E");
		System.out.println();
		
		printByCondition(listPerson, dre -> dre.getFirstName().startsWith("E"), pac -> System.out.println(pac.getFirstName()));
		listPerson.stream()
				  .filter(a -> a.getFirstName().startsWith("E"))
				  .forEach(System.out::println);
		
		List<String> test = listPerson.stream()
				   .map(z -> z.getFirstName().concat(z.getLastName()))
				   .collect(Collectors.toList());
		
	}

	public static void printByCondition(List<PersonData> listPersonNames, Predicate<PersonData> predicate, Consumer<PersonData> consumer) {
		for (PersonData p : listPersonNames) {
			boolean b = predicate.test(p);
			if (b) {
				consumer.accept(p);
			}

		}
	}
}