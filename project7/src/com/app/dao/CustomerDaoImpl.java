package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Customer;



@Repository
@Transactional
public class CustomerDaoImpl implements ICustomerDao{
	
	@Autowired
	private SessionFactory sf;
	
	@Override 
	public Customer getCustomerDetail(int cid) {
		
		return sf.getCurrentSession().get(Customer.class, cid);
		
	}
	@Override
	public List<Customer>getAllCustomerDetails()
	{
		return sf.getCurrentSession().createQuery( "select c form Customer c  where c.role='customer'",Customer.class ).getResultList();
	}
	

	@Override
	public String createNewCustomer(Customer c) {
		
		sf.getCurrentSession().persist(c);
		return "Customer created with ID "+c.getCid();
	}
	
	@Override 
	public String deleteCustomer(int CustomerId) {
		Session hs=sf.getCurrentSession();
		Customer c=hs.get(Customer.class, CustomerId);
		if(c != null)
		{
			hs.delete(c);
			return "Customer deleted for ID "+CustomerId;
		}
		return "Customer not found : Can't be deleted";
	}
	
	@Override
	public String updateCustomer(Customer c) {
		sf.getCurrentSession().update(c);
		return "Customers update";
	}
	
	@Override
	public String addNewCustomer(Customer c) {
		//v -- transient POJO
		sf.getCurrentSession().persist(c);//v --persistent
		return "Vendor registered successfully : ID "+c.getCid();
	}
	
	
	}


