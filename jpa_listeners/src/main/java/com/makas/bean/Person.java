package com.makas.bean;
import javax.persistence.*;
import java.util.Date;

/**
 * Hello world!
 *
 */
@Entity
@Table(name ="Human")
@EntityListeners({
	com.makas.listeners.AgeListener.class,
	com.makas.listeners.NameListener.class
})
public class Person 
{
  @Id @ GeneratedValue
  private int id;
  
  @Column(name = "full_name" ,nullable = false)
  private String fullName;
  
  @Transient
  private int age;
  
  @Temporal(TemporalType.DATE)
  private Date DateOfBirth;

  public Person(String fullName, int age, Date dateOfBirth) {
		super();
		this.fullName = fullName;
		this.age = age;
		DateOfBirth = dateOfBirth;
	}

	public Person() {
		super();
	}
	  
	  
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getFullName() {
	return fullName;
}

public void setFullName(String fullName) {
	this.fullName = fullName;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public Date getDateOfBirth() {
	return DateOfBirth;
}

public void setDateOfBirth(Date dateOfBirth) {
	DateOfBirth = dateOfBirth;
}


}
