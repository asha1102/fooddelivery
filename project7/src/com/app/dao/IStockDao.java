package com.app.dao;

import java.util.List;

import com.app.pojos.Stock;

public interface IStockDao {
	Stock getStockDetails(int id);
	List<Stock> getAllStocks();
	//create new stock
	String createNewStock(Stock s);//s --transient POJO
	//delete stock
	String deleteStock(int sid);
	//update stock
	String updateStock(Stock s);//s ---detached updated POJO
}
