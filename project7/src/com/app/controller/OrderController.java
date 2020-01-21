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

import com.app.dao.IOrderDao;
import com.app.pojos.Order;

@RestController
@RequestMapping("/Order")

public class OrderController {
	
	
	

	@Autowired
	private IOrderDao dao;
	public OrderController() {
		System.out.println("in order controller");
	}
	
	@GetMapping("/{Order_id}")
	public ResponseEntity<?>getOrderDetails(@PathVariable int Order_id){
		System.out.println("in  order dtls"+Order_id);
		Order c = dao.getOrderDetails(Order_id);
		if(c!= null) {
			return new ResponseEntity<Order>(c,HttpStatus.OK);
			
		}
		return new ResponseEntity<String>("order not found ", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping
	public ResponseEntity<?>getAllOrderDetail(){
		List<Order>allOrder = dao.getAllOrderDetail();
				if(allOrder.size()==0) {
					return new ResponseEntity<String>("No order", HttpStatus.NO_CONTENT);
				}
		return new ResponseEntity<List<Order>>(allOrder,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String>createNewOrder(@RequestBody Order c){
		System.out.println("in order detail");
		try {
			return new ResponseEntity<String>(dao.createNewOrder(c), HttpStatus.CREATED);
		}catch(RuntimeException e) {
			return new ResponseEntity<String>("Order not created"+ e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
     @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteCuisine(@PathVariable int orderId){
	 System.out.println("in del cuisine" +orderId);
	  return new ResponseEntity<String>(dao.deleteOrder(orderId),HttpStatus.OK);
}
     @PutMapping("/{orderId}")
 	public ResponseEntity<String> updateOrder(@PathVariable int orderId, @RequestBody Order c) {
 		System.out.println("in update Customer " + orderId + " " + c);
 		
 		Order existingOrder = dao.getOrderDetails(orderId);
 		if (existingOrder != null) {
 			// assign cid to updated stock
 			c.setOrderid(orderId);
 			try {
 				return new ResponseEntity<String>(dao.updateOrder(c), HttpStatus.OK);
 			} catch (RuntimeException e) {
 				return new ResponseEntity<String>("order not updated : " + e.getMessage(),
 						HttpStatus.INTERNAL_SERVER_ERROR);
 			}
 		}
 		return new ResponseEntity<String>("order not Found", HttpStatus.NOT_FOUND);


 	}
	

}
