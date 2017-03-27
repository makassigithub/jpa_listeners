package com.makas.listeners;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.makas.bean.Person;

public class NameListener {
 
	@PrePersist 
	public void reportNameLength(Person p){
		
		String name = p.getFullName();
		System.out.println("NameListener says: " + name + " contains "+ name.length() + " characters");
	}
	
 @PreUpdate
public void checkIfFullName (Person p){
		
		String name = p.getFullName();
		if(!name.contains(" ")){
			System.out.println("NameListener says: " + "This name is not a full name");
		}else {System.out.println("NameListener says: " + "This is full name");}
	}	
}
