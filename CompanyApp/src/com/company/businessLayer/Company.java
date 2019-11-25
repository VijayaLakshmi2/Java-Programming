package com.company.businessLayer;

import java.util.ArrayList;

import com.company.entities.Person;

public class Company {
	
	ArrayList<Person> persons=new ArrayList<Person>();

	public Person getPerson() {
		Person person1 = null;
		for(Person person:persons){
			if(person.getName().equalsIgnoreCase("Vijaya"))
				person1= person;
		}
		return person1;
	}

	public void addPersons(Person person) {
		persons.add(person);
	}

	public Person getNoOfEmployee() {
		Person person1 = null;
		for(Person person:persons){
			if(person.getName().equalsIgnoreCase("Vijaya"))
				person1= person;
		}
		return person1;
	}
	

}
