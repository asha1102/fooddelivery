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

import com.app.dao.ICuisineDao;
import com.app.pojos.Cuisine;
import com.app.pojos.Customer;

@RestController
@RequestMapping("/Cuisine")
public class CuisineController {
	
	@Autowired
	private ICuisineDao dao;
	public CuisineController() {
		System.out.println("in cuisine controller");
	}
	
	@GetMapping("/{Cuisine_name}")
	public ResponseEntity<?>getCuisineDetails(@PathVariable String Cuisine_name){
		System.out.println("in  cuisine dtls"+Cuisine_name);
		Cuisine c = dao.getCuisineDetails(Cuisine_name);
		if(c!= null) {
			return new ResponseEntity<Cuisine>(c,HttpStatus.OK);
			
		}
		return new ResponseEntity<String>("cuisine not found ", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping
	public ResponseEntity<?>getAllCuisineDetail(){
		List<Cuisine>allCuisine = dao.getAllCuisineDetail();
				if(allCuisine.size()==0) {
					return new ResponseEntity<String>("No Cuisine", HttpStatus.NO_CONTENT);
				}
		return new ResponseEntity<List<Cuisine>>(allCuisine,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String>createNewCuisine(@RequestBody Cuisine c){
		System.out.println("in cuisine detail");
		try {
			return new ResponseEntity<String>(dao.createNewCuisine(c), HttpStatus.CREATED);
		}catch(RuntimeException e) {
			return new ResponseEntity<String>("Cuisine not created"+ e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
     @DeleteMapping("/{cuisineId}")
    public ResponseEntity<String> deleteCuisine(@PathVariable int cuisineId){
	 System.out.println("in del cuisine" +cuisineId);
	  return new ResponseEntity<String>(dao.deleteCuisine(cuisineId),HttpStatus.OK);
}
     @PutMapping("/{cuisineId}")
 	public ResponseEntity<String> updateCuisine(@PathVariable int cuisineId, @RequestBody Cuisine c) {
 		System.out.println("in update Customer " + cuisineId + " " + c);
 		
 		Cuisine existingCuisine = dao.getCuisineDetails(cuisineId);
 		if (existingCuisine != null) {
 			// assign cid to updated stock
 			c.setCuisineid(cuisineId);
 			try {
 				return new ResponseEntity<String>(dao.updateCuisine(c), HttpStatus.OK);
 			} catch (RuntimeException e) {
 				return new ResponseEntity<String>("Cuisine not updated : " + e.getMessage(),
 						HttpStatus.INTERNAL_SERVER_ERROR);
 			}
 		}
 		return new ResponseEntity<String>("Cuisine not Found", HttpStatus.NOT_FOUND);


 	}
	

}
