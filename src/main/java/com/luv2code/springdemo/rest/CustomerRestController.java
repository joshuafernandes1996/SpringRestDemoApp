package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	//add mapping to get customers
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomers(@PathVariable int id){
		
		Customer cus = customerService.getCustomer(id);
		
		if(cus == null) {
			throw new CustomerNotFoundException("No customer with id: " + id);
		}
				
		return customerService.getCustomer(id);
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer newCustomer) {

		newCustomer.setId(0);
		customerService.saveCustomer(newCustomer);
		
		return newCustomer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer newCustomer) {

		customerService.saveCustomer(newCustomer);
		
		return newCustomer;
	}
	
	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable int id) {
		
		Customer cus = customerService.getCustomer(id);
		
		if(cus != null) {
			customerService.deleteCustomer(id);
			return "Delete Customer for ID: " + id;
		}

		throw new CustomerNotFoundException("Customer with id: "+id+" does not exist");
		
	}

}
