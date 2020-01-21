package com.app.pojos;

import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="stocks")
public class Stock {
	private Integer id;
	private String code;
	@JsonProperty("desc")
	private String stockDesc;//the name of the property used in marshalling=desc
	private double price;
	@DateTimeFormat(pattern="yyyy-MM-dd")//parsing from string-->date
	@JsonFormat(pattern = "yyyy-MM-dd")//for supplying 
	//the pattern to convert date-->string , during marshalling
	private Date publishDate;
	public Stock() {
		System.out.println("in stock constr");
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length = 20,unique = true)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Column(length = 50,name="stock_desc")
	public String getStockDesc() {
		return stockDesc;
	}
	public void setStockDesc(String stockDesc) {
		this.stockDesc = stockDesc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "stock_dt")
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	@Override
	public String toString() {
		return "Stock [id=" + id + ", code=" + code + ", stockDesc=" + stockDesc + ", price=" + price + ", publishDate="
				+ publishDate + "]";
	}
	
	
	

}
