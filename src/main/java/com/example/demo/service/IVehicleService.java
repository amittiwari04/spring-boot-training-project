package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Vehicle;
import com.example.demo.exception.DriverMissingException;
import com.example.demo.exception.VehicleNotFoundException;

public interface IVehicleService {
	public List<Vehicle> getAllVehicles();
	public Vehicle insertVehicle(Vehicle v);
	public boolean deleteVehicleById(int id);
	public String deleteAllVehicle();
	public Vehicle updateVehicle(Vehicle v1,int id) throws VehicleNotFoundException;
	public List<Vehicle> searchVehicleByBrand(String brand);
}
