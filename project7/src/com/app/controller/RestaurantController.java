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

import com.app.dao.IRestaurantDao;
import com.app.pojos.Restaurant;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	private IRestaurantDao dao;
	public RestaurantController() {
		System.out.println("in restrauant cnstr");
		
	}
	
	@GetMapping("/{restaurant_id}") // template URI variable
	public ResponseEntity<?> getRestaurantDetail(@PathVariable int restaurant_id) {
		System.out.println("in get stock dtls " + restaurant_id);
		Restaurant r = dao.getRestaurantDetail(restaurant_id);
		if (r!= null)
			return new ResponseEntity<Restaurant>(r, HttpStatus.OK);
		// invalid id
		return new ResponseEntity<String>("Restaurant Not Found : Invalid ID", HttpStatus.NOT_FOUND);

	}
	
	@GetMapping
	public ResponseEntity<?>getAllRestaurantDetails(){
		List<Restaurant>allRestaurant=dao.getAllRestaurantDetails();
		if(allRestaurant.size() ==0) {
			return new ResponseEntity<String>("No restaurant ",HttpStatus.NO_CONTENT);
		}
			return new ResponseEntity<List<Restaurant>>(allRestaurant,HttpStatus.OK);
			
		}
	
	
	@PostMapping
	public ResponseEntity<String> newCreateRestaurant(@RequestBody Restaurant d) {
		System.out.println("in create new Restaurant " + d);
		try {
			return new ResponseEntity<String>(dao.newCreateRestaurant(d), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return new ResponseEntity<String>("restaurant not created : " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping("/{rid}")
	public ResponseEntity<String> deleteRestaurant(@PathVariable int rid) {
		System.out.println("in del restaurant " + rid);
		return new ResponseEntity<String>(dao.deleteRestaurant(rid), HttpStatus.OK);
	}
	
	
	@PutMapping("/{rid}")
	public ResponseEntity<String>  updateRestaurant(@PathVariable int rid, @RequestBody Restaurant r) {
		System.out.println("in update Customer " + rid + " " + r);
		
		Restaurant existingRestaurant = dao.getRestaurantDetail(rid);
		if (existingRestaurant != null) {
			// assign rid to updated stock
			r.setRid(rid);
			try {
				return new ResponseEntity<String>(dao.updateRestaurant(r), HttpStatus.OK);
			} catch (RuntimeException e) {
				return new ResponseEntity<String>("Restaurant not updated : " + e.getMessage(),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<String>("Restaurant not Found", HttpStatus.NOT_FOUND);


	}
	
	
	

}
