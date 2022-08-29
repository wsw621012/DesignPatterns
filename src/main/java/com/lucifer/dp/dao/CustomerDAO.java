package com.lucifer.dp.dao;

public class CustomerDAO {

	private final DataSource ds;
	
	
	private CustomerTO cto;
	
	public CustomerDAO(DataSource ds) {
		this.ds = ds;
	}
	
	public CustomerTO getCustomer(int id) {
		cto = ds.getCustomerById(id);
		return cto;
	}
}
