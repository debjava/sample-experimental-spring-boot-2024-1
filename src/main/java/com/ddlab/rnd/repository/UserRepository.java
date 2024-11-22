package com.ddlab.rnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ddlab.rnd.entity.Customer;

@Repository
public interface UserRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByFirstName(String firstName); // Exact Search 
	List<Customer> findByFirstNameIgnoreCase(String firstName); // Case Insensitive Search
	
	@Query("select c from Customer c where c.firstName like %:name%")
	List<Customer> searchByFirstName(@Param("name") String name);
	
	@Query("select c from Customer c where c.firstName like %:name%")
	List<Customer> searchByFirstNameWithoutParam(String name);
	
	
}
