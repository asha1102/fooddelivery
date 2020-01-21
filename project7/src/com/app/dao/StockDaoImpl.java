package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Stock;

import java.util.List;

import org.hibernate.*;

@Repository
@Transactional
public class StockDaoImpl implements IStockDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public Stock getStockDetails(int id) {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(Stock.class, id);
	}

	@Override
	public List<Stock> getAllStocks() {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("select s from Stock s", Stock.class).getResultList();

	}

	@Override
	public String createNewStock(Stock s) {
		
		sf.getCurrentSession().persist(s);
		return "Stock created with ID "+s.getId();
	}

	@Override
	public String deleteStock(int stockId) {
		Session hs=sf.getCurrentSession();
		Stock s=hs.get(Stock.class, stockId);
		if(s != null)
		{
			hs.delete(s);
			return "Stock deleted for ID "+stockId;
		}
		return "Stock not found : Can't be deleted";
	}

	@Override
	public String updateStock(Stock s) {
		//s -- detached POJO containing updates.
		sf.getCurrentSession().update(s);//add detached POJO ref 
		//onto L1 cache. Hibernate will auto perform dirty chking @ commit 
		//fires update query
		return "Stock updated....";
	}
	
	

}
