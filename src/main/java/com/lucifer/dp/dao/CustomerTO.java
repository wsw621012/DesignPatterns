package com.lucifer.dp.dao;

public class CustomerTO {

	private final int id;
	
	private String name;
	
	private String address;
	
	private String telnum;
	
	boolean isChange;
	
	public CustomerTO(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		if (!this.name.equals(name)) {
			this.name = name;
			isChange = true;
		}
	}
	
	public void setAddress(String address) {
		if (!this.address.equals(address)) {
			this.address = address;
			isChange = true;
		}
	}
	
	public void setTelnum(String telnum) {
		if (!this.telnum.equals(telnum)) {
			this.telnum = telnum;
			isChange = true;
		}
	}
	
	public final String getName() { return name; }
	public final String getAddress() { return address; }
	public final String getTelnum() { return telnum; }
	public final int getId() { return id; }
}
