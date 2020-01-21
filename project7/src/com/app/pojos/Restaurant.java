package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "restraunt")
public class Restaurant {
	
	private Integer rid;
	private String rname;
	private String raddress;
	private String rcity;
	
	
	public Restaurant() {
		super();
		System.out.println("in restraunt constr");
	}


	public Restaurant( String rname, String raddress, String rcity) {
		super();
		
		this.rname = rname;
		this.raddress = raddress;
		this.rcity = rcity;
	}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getRid() {
		return rid;
	}


	public void setRid(Integer rid) {
		this.rid = rid;
	}

@Column(length=20)
	public String getRname() {
		return rname;
	}


	public void setRname(String rname) {
		this.rname = rname;
	}


	public String getRaddress() {
		return raddress;
	}


	public void setRaddress(String raddress) {
		this.raddress = raddress;
	}

@Column(length= 20)
	public String getRcity() {
		return rcity;
	}


	public void setRcity(String rcity) {
		this.rcity = rcity;
	}


	@Override
	public String toString() {
		return "Restaurant [rid=" + rid + ", rname=" + rname + ", raddress=" + raddress + ", rcity=" + rcity + "]";
	}
	
	
	
	
	

}
