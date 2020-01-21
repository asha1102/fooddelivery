package com.app.dao;

import java.util.List;

import com.app.pojos.FoodCategory;

public interface IFoodCategoryDao {

	FoodCategory getCategorydetails(int categoryid);

	List<FoodCategory> getAllCategorydetails();

	String createNewCategory(FoodCategory c);

	String deleteFoodcategory(int categoryid);

	String updateFoodCategory(FoodCategory c);

	FoodCategory getCategorydetails(String categoryname);

	

}
