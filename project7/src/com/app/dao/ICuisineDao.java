package com.app.dao;

import java.util.List;

import com.app.pojos.Cuisine;

public interface ICuisineDao {

	Cuisine getCuisineDetails(String cuisinename);

	List<Cuisine> getAllCuisineDetail();

	String createNewCuisine(Cuisine c);

	String deleteCuisine(int CuisineId);

	String updateCuisine(Cuisine c);

	Cuisine getCuisineDetails(int cuisineId);

}
