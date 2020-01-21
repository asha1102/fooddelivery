package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "cuisine")
public class Cuisine {
	
	private Integer cuisineid;
	private String cuisinename;
//	private List<FoodCategory> categories=new ArrayList<>();
	
	
	
	public Cuisine() {
		super();
		System.out.println("in cuisine constr");
	}


	public Cuisine(Integer cuisineid, String cuisinename) {
		super();
		this.cuisineid = cuisineid;
		this.cuisinename = cuisinename;
	}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCuisineid() {
		return cuisineid;
	}


	public void setCuisineid(Integer cuisineid) {
		this.cuisineid = cuisineid;
	}

   @Column(length = 20)
	public String getCuisinename() {
		return cuisinename;
	}


	

	public void setCuisinename(String cuisinename) {
		this.cuisinename = cuisinename;
	}


	@Override
	public String toString() {
		return "Cuisine [cuisineid=" + cuisineid + ", cuisinename=" + cuisinename + "]";
	}
	
	
	
	/*
	 * @OneToMany(mappedBy = "selectedcuisine",cascade = CascadeType.ALL) public
	 * List<FoodCategory> getCategories() { return categories; }
	 * 
	 * 
	 * public void setCategories(List<FoodCategory> categories) { this.categories =
	 * categories; }
	 */


	/*
	 * @Override public String toString() { return "Cuisine [cuisineid=" + cuisineid
	 * + ", cuisinename=" + cuisinename + "]"; }
	 */

	

}
