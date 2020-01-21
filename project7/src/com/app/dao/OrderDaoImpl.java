package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Order;
@Repository
@Transactional

public class OrderDaoImpl implements IOrderDao{
	
	
	@Autowired
	private SessionFactory sf;
	@Override
	public Order getOrderDetails(int orderid) {
		return sf.getCurrentSession().get(Order.class, orderid);
		
	}
	
	@Override
	public List<Order> getAllOrderDetail(){
		return sf.getCurrentSession().createQuery("select c from Order c",Order.class).getResultList();
	}
	
	@Override
	 public String createNewOrder(Order c) {
		sf.getCurrentSession().persist(c);
		return "Order created with ID "+c.getOrderid();
	}
	
	@Override
	public String deleteOrder(int orderId) {
      Session hs = sf.getCurrentSession();
      Order c = hs.get(Order.class, orderId);
      if(c!= null) {
    	  hs.delete(c);
    	  return "order deleted for ID" +orderId;
      }
      return "order cant be found";
	}
	@Override 
	public String updateOrder(Order c) {
		sf.getCurrentSession().update(c);
		return "order update";
	}


}
