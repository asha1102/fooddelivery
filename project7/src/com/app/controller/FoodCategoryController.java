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

import com.app.dao.IFoodCategoryDao;

import com.app.pojos.FoodCategory;

@RestController
@RequestMapping("/FoodCategory")

public class FoodCategoryController {
	@Autowired
	private IFoodCategoryDao  dao;
	public FoodCategoryController() {
		System.out.println("in foodcategory controller");
		
	}
	@GetMapping("/{FoodCategory_name}")
	public ResponseEntity<?>getCategorydetails(@PathVariable String FoodCategory_name){
		System.out.println("in foodcategory_dtls"+FoodCategory_name);
		FoodCategory c = dao .getCategorydetails(FoodCategory_name);
		if(c!= null) {
			return new ResponseEntity<FoodCategory>(c,HttpStatus.OK);
			
		}
		return new ResponseEntity<String>("foodcategory not found ", HttpStatus.NOT_FOUND);
	}
	
	 @GetMapping
	 public ResponseEntity<?>getAllCategorydetails(){
		 List<FoodCategory>allFoodCategory= dao.getAllCategorydetails();
		 if(allFoodCategory.size()==0) {
			 return new ResponseEntity<String>("No Foodcategory",HttpStatus.NO_CONTENT);
		 }
		 return new ResponseEntity<List<FoodCategory>>(allFoodCategory,HttpStatus.OK);
	 }
	@PostMapping
	public ResponseEntity<String>createNewCategory(@RequestBody FoodCategory c){
		System.out.println("in foodcategory detail");
		try {
			return new ResponseEntity<String>(dao.createNewCategory(c),HttpStatus.OK);
			
		}catch(RuntimeException e) {
			return new ResponseEntity<String>("foodcategory not created"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		

	     
	@DeleteMapping("/{categoryid}")
    public ResponseEntity<String> deleteCuisine(@PathVariable int categoryid){
	System.out.println("in foodcategory"+categoryid);
	 return new ResponseEntity<String>(dao.deleteFoodcategory(categoryid),HttpStatus.OK);
     }

	@PutMapping("/{categoryid}")
	public ResponseEntity<String> updateFoodCategory(@PathVariable int categoryid, @RequestBody FoodCategory c){
		System.out.println("in food category "+categoryid + " "+ c);
		FoodCategory existingfoodcategory = dao.getCategorydetails(categoryid);
		if(existingfoodcategory!= null) {
			c.setCategoryid(categoryid);
	
 			try {
 				return new ResponseEntity<String>(dao.updateFoodCategory(c), HttpStatus.OK);
 			} catch (RuntimeException e) {
 				return new ResponseEntity<String>("Foodcategory not updated : " + e.getMessage(),
 						HttpStatus.INTERNAL_SERVER_ERROR);
 			}
 		}
 		return new ResponseEntity<String>("Foodcategory not Found", HttpStatus.NOT_FOUND);


		}
		
		
		
	}
	
	     
	
		
		
	


