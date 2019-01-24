package com.cignex.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cignex.model.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	static List<Customer> customers;
	static {
		customers = new ArrayList<Customer>();
		customers.add(new Customer("pinal", "22", "36"));
		customers.add(new Customer("ram", "25", "95"));
		customers.add(new Customer("narayan", "24", "65"));
		customers.add(new Customer("maulik", "22", "98"));
		customers.add(new Customer("aalap", "24", "94"));
	}

	@GetMapping("/{customerName}")
	Customer getCustomer(@PathVariable("customerName") String customerName) {
		return customers.stream().filter(customer -> customer.getName().equals(customerName)).findFirst().get();
	}
	@PostMapping("/save")
	Customer add(@RequestBody Customer customer) {
		System.out.println(customer.getName());
		customers.add(customer);
		return customer;
	}
	@GetMapping(value="/list")
	List<Customer> getAll(){
		return customers;
	}
	
	
}
