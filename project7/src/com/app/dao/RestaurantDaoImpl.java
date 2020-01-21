package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Restaurant;

@Repository
@Transactional

public class RestaurantDaoImpl implements IRestaurantDao {
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public Restaurant getRestaurantDetail(int rid) {
		return sf.getCurrentSession().get(Restaurant.class,rid);
		
		
	}
	
	@Override 
	public List <Restaurant>getAllRestaurantDetails(){
		return sf.getCurrentSession().createQuery("select r from Restaurant r", Restaurant.class).getResultList();
	}
	
	@Override 
	public String newCreateRestaurant(Restaurant r) {
		sf.getCurrentSession().persist(r);
		return "Restaurant created with id "+r.getRid();
		
		
	}
	
	@Override
	public String deleteRestaurant(int rid) {
		Session hs = sf.getCurrentSession();
		Restaurant r= hs.get(Restaurant.class , rid);
		if(r != null)
		{
			hs.delete(r);
			return "Restaurant deleted for ID "+rid;
		}
		return "Restaurant not found : Can't be deleted";
	}
	
	
	@Override
	public String updateRestaurant(Restaurant r) {
		
		sf.getCurrentSession().update(r);
		return "Restaurant update";
		
	}
	

}
