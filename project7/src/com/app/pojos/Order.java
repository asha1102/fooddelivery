package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetail")

public class Order {
	
	private Integer orderid;
	
	//private Customer selectedcustomer;
	
	private String billing;
	//private Restaurant selectedrestaurant;
	
	public Order() {
		System.out.println("on order contsr");
	}

	public Order(String billing) {
		super();
		this.billing = billing;
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	
	/*
	 * @OneToMany(mappedBy = "selectedorder",cascade = CascadeType.ALL) public
	 * Customer getSelectedcustomer() { return selectedcustomer; }
	 * 
	 * public void setSelectedcustomer(Customer selectedcustomer) {
	 * this.selectedcustomer = selectedcustomer; }
	 */
	 

	public String getBilling() {
		return billing;
	}

	public void setBilling(String billing) {
		this.billing = billing;
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", billing=" + billing + "]";
	}

	

	/*
	 * @Override public String toString() { return "Order [orderid=" + orderid +
	 * ", selectedcustomer=" + selectedcustomer + ", billing=" + billing + "]"; }
	 */
	
/*	public Restaurant getSelectedrestaurant() {
		return selectedrestaurant;
	}

	public void setSelectedrestaurant(Restaurant selectedrestaurant) {
		this.selectedrestaurant = selectedrestaurant;
	}
*/
	/*@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", selectedcustomer=" + selectedcustomer + ", billing=" + billing
				+ " selectedrestaurant=" + selectedrestaurant + "]";
	}*/
	
	
	
	
	

}
