package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FoodCategory")
public class FoodCategory {
	
	
	private Integer categoryid;
	private String categoryname;
	//private Cuisine selectedCuisine;
	
	
	
	public FoodCategory() {
		super();
		System.out.println("in foodcategory constr");
	}

	public FoodCategory(Integer categoryid, String categoryname) {
		super();
		this.categoryid = categoryid;
		this.categoryname = categoryname;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	
    @Column(length =20)
	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	/*
	 * @ManyToOne //mandatory
	 * 
	 * @JoinColumn(name = "category_id") public Cuisine getSelectedCuisine() {
	 * return selectedCuisine; }
	 * 
	 * public void setSelectedCuisine(Cuisine selectedCuisine) {
	 * this.selectedCuisine = selectedCuisine; }
	 */

	@Override
	public String toString() {
		return "FoodCategory [categoryid=" + categoryid + ", categoryname=" + categoryname + "]";
	}

	/*
	 * @Override public String toString() { return "FoodCategory [categoryid=" +
	 * categoryid + ", categoryname=" + categoryname + "]"; }
	 */
	
	
	
	
	
	
	
	

}
