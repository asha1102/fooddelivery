package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IStockDao;
import com.app.pojos.Stock;

@RestController
@CrossOrigin//(origins = "http://localhost:4200")  //mandatory for cross technology
@RequestMapping("/stocks")
public class StockController {
	@Autowired
	private IStockDao dao;

	public StockController() {
		System.out.println("in stock controller ctor");
	}

	// REST service method to ret a stock by id
	@GetMapping("/{stock_id}") // template URI variable
	public ResponseEntity<?> getStockDetails(@PathVariable int stock_id) {
		System.out.println("in get stock dtls " + stock_id);
		Stock s = dao.getStockDetails(stock_id);
		if (s != null)
			return new ResponseEntity<Stock>(s, HttpStatus.OK);
		// invalid id
		return new ResponseEntity<String>("Stock Not Found : Invalid ID", HttpStatus.NOT_FOUND);

	}

	// REST service method to return all stocks
	@GetMapping
	public ResponseEntity<?> getAllStocks() {
		List<Stock> allStocks = dao.getAllStocks();
		if (allStocks.size() == 0)
			return new ResponseEntity<String>("No stocks!!!!", HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Stock>>(allStocks, HttpStatus.OK);
	}

	// REST service method to create a new stock
	@PostMapping
	public ResponseEntity<String> createNewStock(@RequestBody Stock s) {
		System.out.println("in create new stock " + s);
		try {
			return new ResponseEntity<String>(dao.createNewStock(s), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return new ResponseEntity<String>("Stock not created : " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// REST service method to delete a resource
	@DeleteMapping("/{sid}")
	public ResponseEntity<String> deleteStock(@PathVariable int sid) {
		System.out.println("in del stock " + sid);
		return new ResponseEntity<String>(dao.deleteStock(sid), HttpStatus.OK);
	}

	// REST service method to update existing stock
	@PutMapping("/{sid}")
	public ResponseEntity<String> updateStock(@PathVariable int sid, @RequestBody Stock s) {
		System.out.println("in update stock " + sid + " " + s);
		// chk if stock exists
		Stock existingStock = dao.getStockDetails(sid);
		if (existingStock != null) {
			// assign sid to updated stock
			s.setId(sid);
			try {
				return new ResponseEntity<String>(dao.updateStock(s), HttpStatus.OK);
			} catch (RuntimeException e) {
				return new ResponseEntity<String>("Stock not updated : " + e.getMessage(),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<String>("Stock not Found", HttpStatus.NOT_FOUND);

	}
}
