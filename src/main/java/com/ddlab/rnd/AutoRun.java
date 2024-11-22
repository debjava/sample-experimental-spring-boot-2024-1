package com.ddlab.rnd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ddlab.rnd.entity.Customer;
import com.ddlab.rnd.repository.UserRepository;

@Component
public class AutoRun {

	@Autowired
	private UserRepository userRepo;
	
	private void saveAllCustomers() {
		List<Customer> userList = List.of(new Customer("Ram"), new Customer("John"), 
				new Customer("shYAM"), new Customer("RAdha"), new Customer("harI"));
		userRepo.saveAll(userList);
	}
	
	public void searchUserByName() {
		String name = "ram";
//		List<Customer> customerList = userRepo.findByFirstName(name); // Provides empty result set 
		List<Customer> customerList = userRepo.findByFirstNameIgnoreCase(name); // Provides result
		if(customerList.isEmpty()) {
			System.out.println("No such customers ...");
		} else {
			System.out.println("List of Customers--->"+customerList);
		}
	}
	
	public void searchName() {
		String name = "am";
		List<Customer> customerList = userRepo.searchByFirstNameWithoutParam(name); 
		if(customerList.isEmpty()) {
			System.out.println("No such customers ...");
		} else {
			System.out.println("List of Customers--->"+customerList);
		}
	}

	@EventListener(ApplicationReadyEvent.class)
	public void run() {
		searchName();
	}
}
