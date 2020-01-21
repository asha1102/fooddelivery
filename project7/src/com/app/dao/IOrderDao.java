package com.app.dao;

import java.util.List;

import com.app.pojos.Order;

public interface IOrderDao {

	Order getOrderDetails(int orderid);

	List<Order> getAllOrderDetail();

	String createNewOrder(Order c);

	String deleteOrder(int orderId);

	String updateOrder(Order c);

}
