package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.FoodCategory;

@Repository
@Transactional
public class FoodCategoryDaoImpl  implements IFoodCategoryDao{
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public FoodCategory getCategorydetails(String categoryname) {
		return sf.getCurrentSession().get(FoodCategory.class, categoryname);
		
	}
	@Override 
	 public FoodCategory getCategorydetails(int categoryid ) {
		return sf.getCurrentSession().get(FoodCategory.class, categoryid);
	}
	
	@Override
	 public List<FoodCategory>getAllCategorydetails(){
		return sf.getCurrentSession().createQuery("select l from FoodCategory l ", FoodCategory.class).getResultList();
	}
	
	@Override 
	 public String createNewCategory(FoodCategory c) {
		sf.getCurrentSession().persist(c);
		return "FoodCategory created with id "+c.getCategoryid();
		
	}
	
	@Override 
	 public String deleteFoodcategory(int categoryid) {
		Session hs = sf.getCurrentSession();
		FoodCategory c = hs.get(FoodCategory.class, categoryid);
				if(c!= null) {
			    	  hs.delete(c);
			    	  return "FoodCategory deleted for ID" +categoryid;
			      }
			      return "Foodcategory cant be found";
		
	}
	@Override 
	public String updateFoodCategory(FoodCategory c) {
		sf.getCurrentSession().update(c);
		return "Foodcategory update";
		
	}

}
