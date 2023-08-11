package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "VehicleDetails")
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "seq")
	@SequenceGenerator(name="seq",sequenceName="seq", initialValue = 10001,allocationSize=1)
	private int vehicleId;
	
	@Column(name="model")
	private String modelNo;
	@Column(name="brand")
	private String company;
	private String description;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="driveNo",referencedColumnName = "driverId")
	private Driver driver;
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Vehicle(int vehicleId, String modelNo, String company, String description, Driver driver) {
		super();
		this.vehicleId = vehicleId;
		this.modelNo = modelNo;
		this.company = company;
		this.description = description;
		this.driver = driver;
	}
	public Vehicle() {
		super();
	}
	
}
