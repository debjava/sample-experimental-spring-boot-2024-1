package com.ddlab.rnd.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ddlab.rnd.entity.BadObject;
import com.ddlab.rnd.entity.Employee;
import com.ddlab.rnd.exception.BadRequestException;
import com.ddlab.rnd.exception.NoSuchEmployeeException;

@RestController
public class EmpController {
	
	@PutMapping(value = "/v1/emp")
	public ResponseEntity<Employee> getEmpInfo(@RequestBody Employee emp) {
		if(emp.getId() == null || emp.getId().intValue() == 0) {
			throw new IllegalArgumentException("Invalid Employee Id");
		}
		Employee employee = new Employee(123, "John Abrahm", "Permanent", new String[] {"Admin"});
		return ResponseEntity.ok().body(employee);
	}
	
	@PutMapping(value = "/v2/emp")
	public ResponseEntity<?> getEmpDetails(@RequestBody Employee emp) {
		System.out.println("Employee-------->"+emp);
		if(emp.getId() == null || emp.getId().intValue() == 0) {
			BadObject badObj = new BadObject("Invalid Employee Id", "Provide proper employee id");
			return ResponseEntity.ok().body(badObj);
		}
		Employee employee = new Employee(123, "John Abrahm", "Permanent", new String[] {"Admin"});
		return ResponseEntity.ok().body(employee);
	}
	
	@PutMapping(value = "/v3/emp")
	public ResponseEntity<Employee> getEmpDetail(@RequestBody Employee emp) {
		System.out.println("Employee-------->"+emp);
		if(emp.getId() == null || emp.getId().intValue() == 0) {
			throw new BadRequestException("Invalid Employee Id");
		}
		Employee employee = new Employee(123, "John Abrahm", "Permanent", new String[] {"Admin"});
		return ResponseEntity.ok().body(employee);
	}
	
	@PutMapping(value = "/v4/emp")
	public ResponseEntity<Employee> getMoreEmpInfo(@RequestBody Employee emp) {
		Employee employee = null;
		System.out.println("Employee-------->" + emp);
		if (emp.getId() == null || emp.getId().intValue() <= 0 ) {
			throw new NoSuchEmployeeException("No such employee exists with this id");
		}
		employee = new Employee(123, "John Abrahm", "Permanent", new String[] {"Admin"});
		return ResponseEntity.ok().body(employee);
	}
	
	@PutMapping(value = "/v5/emp")
	public ResponseEntity<Employee> getMoreEmpDetails(@RequestBody Employee emp) {
		Employee employee = null;
		System.out.println("Employee-------->" + emp);
		String role1 = emp.getRoles()[1];
		System.out.println("Role1---->"+role1);
		employee = new Employee(123, "John Abrahm", "Permanent", new String[] {"Admin"});
		return ResponseEntity.ok().body(employee);
	}
	
	

}
