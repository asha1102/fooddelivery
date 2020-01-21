package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ICustomerDao;
import com.app.pojos.Customer;



@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private ICustomerDao dao;

	public CustomerController() {
		System.out.println("in customer controller ctor");
	}

	// REST service method to ret a stock by id
	@GetMapping("/{customer_id}") // template URI variable
	public ResponseEntity<?> getCustomerDetail(@PathVariable int customer_id) {
		System.out.println("in get customer dtls " + customer_id);
		Customer c = dao.getCustomerDetail(customer_id);
		if (c!= null)
			return new ResponseEntity<Customer>(c, HttpStatus.OK);
		// invalid id
		return new ResponseEntity<String>("Customer Not Found : Invalid ID", HttpStatus.NOT_FOUND);

	}
	
	@GetMapping
	public ResponseEntity<?>getAllCustomerDetails(){
		List<Customer>allCustomers=dao.getAllCustomerDetails();
		if(allCustomers.size() ==0) {
			return new ResponseEntity<String>("No customer ",HttpStatus.NO_CONTENT);
		}
			return new ResponseEntity<List<Customer>>(allCustomers,HttpStatus.OK);
			
		}
	
	
	@PostMapping
	public ResponseEntity<String> createNewCustomer(@RequestBody Customer c) {
		System.out.println("in create new Customer " + c);
		try {
			return new ResponseEntity<String>(dao.createNewCustomer(c), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return new ResponseEntity<String>("Customer not created : " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping("/{cid}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int cid) {
		System.out.println("in del customer " + cid);
		return new ResponseEntity<String>(dao.deleteCustomer(cid), HttpStatus.OK);
	}
	
	
	@PutMapping("/{cid}")
	public ResponseEntity<String> updateCustomer(@PathVariable int cid, @RequestBody Customer c) {
		System.out.println("in update Customer " + cid + " " + c);
		
		Customer existingCustomer = dao.getCustomerDetail(cid);
		if (existingCustomer != null) {
			// assign cid to updated stock
			c.setCid(cid);
			try {
				return new ResponseEntity<String>(dao.updateCustomer(c), HttpStatus.OK);
			} catch (RuntimeException e) {
				return new ResponseEntity<String>("Customer not updated : " + e.getMessage(),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<String>("Customer not Found", HttpStatus.NOT_FOUND);


	}
}


