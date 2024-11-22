package com.ddlab.rnd.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Employee {
	
	@Id @GeneratedValue
	private Integer id;
	private String name;
	private String status;
	private String[] roles;

}
