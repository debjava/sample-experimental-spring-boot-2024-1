package com.ddlab.rnd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@Entity(name="Customer") @Table(name="customer")
public class Customer {
	
	@Id @GeneratedValue
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	public Customer(String firstName) {
		this.firstName = firstName;
	}

}
