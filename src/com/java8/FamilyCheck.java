package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiPredicate;

public class FamilyCheck {
	
	public static void getByCondiction(List<PersonData> listData, BiPredicate<String, List<PersonData>> biPredicate){
		Map<String, List<PersonData>> sib = new HashMap<>();
		for(PersonData p: listData){
			if(biPredicate.test(p.getLastName(), listData)){
				if(sib.containsKey(p.getLastName())){
					List<PersonData> sibList = new ArrayList<>();
					sibList.addAll(sib.get(p.getLastName()));
					sibList.add(p);
					sib.put(p.getLastName(), sibList);
				}else{
				sib.put(p.getLastName(), Arrays.asList(p));
				}
			}
			
		}
		Collections.sort(sib.entrySet().iterator().next().getValue(), (a,b)->a.getLastName().compareTo(b.getLastName()));
		
		
		for(Entry<String, List<PersonData>> entry: sib.entrySet()){
			for( PersonData ts: entry.getValue()){
				System.out.println(entry.getKey() + " is the Father of " + ts.getFirstName());
			}
			
		}
	}
public static void main(String[] args) {

	List<PersonData> listPerson = Arrays.asList(
			new PersonData("Henok", "Zewdie", 33),
			new PersonData("Ermias", "Zewdie", 36),
			new PersonData("Tizita", "Zewdie", 38),
			new PersonData("Mena", "Henok", 5), 
			new PersonData("Eliana", "Henok", 3),
			new PersonData("Raya", "Ameha", 35), 
			new PersonData("Taeme", "Ameha", 40),
			new PersonData("Ameha", "Fisseha", 25),
			new PersonData("Meti", "Fikre", 10),
			new PersonData("Hawi", "Fikre", 9), 
			new PersonData("Emuti", "Ashenafi", 32),
			new PersonData("Zewdie", "Wordoffa", 83),
			new PersonData("Fikre", "Gudeta", 41),
			new PersonData("Tigist", "Ashenafi", 36));
	
	boolean test = listPerson.stream().anyMatch(p->p.getLastName().equalsIgnoreCase(""));
	
	getByCondiction(listPerson, (p, listData)-> listData.stream().anyMatch(s->s.getLastName().equalsIgnoreCase(p)));
	
	
			
	}
}
