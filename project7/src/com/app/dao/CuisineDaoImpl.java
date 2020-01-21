package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Cuisine;

@Repository
@Transactional

public class CuisineDaoImpl  implements ICuisineDao{
	
	
	
	@Autowired
	private SessionFactory sf;
	@Override
	public Cuisine getCuisineDetails(String cuisinename) {
		return sf.getCurrentSession().get(Cuisine.class, cuisinename);
		
	}
	@Override 
	public Cuisine getCuisineDetails(int cuisineid) {
		return sf.getCurrentSession().get(Cuisine.class, cuisineid);
	}
	@Override
	public List<Cuisine> getAllCuisineDetail(){
		return sf.getCurrentSession().createQuery("select c from Cuisine c",Cuisine.class).getResultList();
	}
	
	@Override
	 public String createNewCuisine(Cuisine c) {
		sf.getCurrentSession().persist(c);
		return "Cuisine created with ID "+c.getCuisineid();
	}
	
	@Override
	public String deleteCuisine(int CuisineId) {
      Session hs = sf.getCurrentSession();
      Cuisine c = hs.get(Cuisine.class, CuisineId);
      if(c!= null) {
    	  hs.delete(c);
    	  return "Cuisine deleted for ID" +CuisineId;
      }
      return "Cuisine cant be found";
	}
	@Override 
	public String updateCuisine(Cuisine c) {
		sf.getCurrentSession().update(c);
		return "Cuisine update";
	}

}
