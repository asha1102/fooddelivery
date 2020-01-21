package com.app.dao;

import java.util.List;

import com.app.pojos.Customer;

public interface ICustomerDao {

	

	Customer getCustomerDetail(int cid);

	List<Customer> getAllCustomerDetails();


	String deleteCustomer(int CustomerId);

	String updateCustomer(Customer c);

	String createNewCustomer(Customer c);

	String addNewCustomer(Customer c);

	

	

}
