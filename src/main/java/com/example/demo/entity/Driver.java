package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Driver {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int driverId;
	
	@Column(name = "driverName")
	private String name;
	private long contactNo;
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public Driver(int driverId, String name, long contactNo) {
		super();
		this.driverId = driverId;
		this.name = name;
		this.contactNo = contactNo;
	}
	public Driver() {
		super();
	}
	
}
