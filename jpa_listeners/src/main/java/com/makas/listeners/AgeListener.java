package com.makas.listeners;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import com.makas.bean.Person;

public class AgeListener {
    
	
	@PrePersist
	@PreUpdate
	public void listenAge(Person p){
		//simple logic down here
		if(p.getAge()>10 && p.getAge()<20){
			System.out.println(" AgeListener says: This person is a teenager");
		   }else if (p.getAge()>20){
			   System.out.println("AgeListener says: This guy is a mature");
		   }
	}
	
	@PreRemove
	public void checkRemoval(Person p) throws Exception{
		
		if(p.getAge()==18){
		  throw new IllegalArgumentException("AgeListener says: Cannot remove an 18 tears old");
		}
	}
}
