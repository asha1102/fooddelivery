package com.app.dao;

import java.util.List;

import com.app.pojos.Restaurant;

public interface IRestaurantDao {

	Restaurant getRestaurantDetail(int rid);

	List<Restaurant> getAllRestaurantDetails();

	String newCreateRestaurant(Restaurant r);

	String deleteRestaurant(int rid);

	String updateRestaurant(Restaurant r);

}
