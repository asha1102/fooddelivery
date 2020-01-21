package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Customer")
public class Customer {
	
	private Integer cid;
	private String cname;
	private String cemail;
	private String cpassword;
	private String caddress;
	private Integer cphoneno;
//	private Order selectedorder; 
	
	
	
	



	public Customer() {
		super();
		System.out.println("in customer constr");
	}



	public Customer(String cname, String cemail, String cpassword, String caddress, Integer cphoneno) {
		super();
		this.cname = cname;
		this.cemail = cemail;
		this.cpassword = cpassword;
		this.caddress = caddress;
		this.cphoneno = cphoneno;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCid() {
		return cid;
	}



	public void setCid(Integer cid) {
		this.cid = cid;
	}


	@Column(length= 20)
	public String getCname() {
		return cname;
	}



	public void setCname(String cname) {
		this.cname = cname;
	}


 @Column(length=20 ,unique=true)
	public String getCemail() {
		return cemail;
	}



	public void setCemail(String cemail) {
		this.cemail = cemail;
	}


@Column(length=20,nullable= false)
	public String getCpassword() {
		return cpassword;
	}



	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}



	public String getCaddress() {
		return caddress;
	}



	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}



	public Integer getCphoneno() {
		return cphoneno;
	}



	public void setCphoneno(Integer cphoneno) {
		this.cphoneno = cphoneno;
	}



	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", cemail=" + cemail + ", cpassword=" + cpassword
				+ ", caddress=" + caddress + ", cphoneno=" + cphoneno + "]";
	}





	/*
	 * @ManyToOne //mandatory
	 * 
	 * @JoinColumn(name = "selectedcustomer") public Order getSelectedorder() {
	 * return selectedorder; } public void setSelectedorder(Order selectedorder) {
	 * this.selectedorder = selectedorder; }
	 * 
	 */


	
	/*
	 * @Override public String toString() { return "Customer [cid=" + cid +
	 * ", cname=" + cname + ", cemail=" + cemail + ", cpassword=" + cpassword +
	 * ", caddress=" + caddress + ", cphoneno=" + cphoneno + ", selectedorder=" +
	 * selectedorder + "]"; }
	 * 
	 * 
	 * 
	 * 
	 */

	
	
	

}
