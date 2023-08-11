package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IVehicleDao;
import com.example.demo.entity.Vehicle;
import com.example.demo.exception.DriverMissingException;
import com.example.demo.exception.VehicleNotFoundException;

@Service
public class VehicleServiceImpl implements IVehicleService{
	
	@Autowired
	private IVehicleDao dao;

	@Override
	@Transactional
	public List<Vehicle> getAllVehicles() {
		List<Vehicle> listOfVehicle = dao.findAll();
		return listOfVehicle;
	}

	@Override
	@Transactional
	public Vehicle insertVehicle(Vehicle v) throws DriverMissingException{
		if(v.getDriver()==null) {
			throw new DriverMissingException();
		}
		return dao.save(v);
	}

	@Override
	@Transactional
	public boolean deleteVehicleById(int id) {
		dao.deleteById(id);
		return true;
	}

	@Override
	@Transactional
	public String deleteAllVehicle() {
		dao.deleteAll();
		return "Vehicle deleted";
	}

	@Override
	@Transactional
	public Vehicle updateVehicle(Vehicle v1,int id) throws VehicleNotFoundException {
		Vehicle updatedVeh = null;
		if(dao.existsById(id)) {
			updatedVeh=dao.save(v1);
		}else {
			throw new VehicleNotFoundException();
		}
		return updatedVeh;
	}

	@Override
	public List<Vehicle> searchVehicleByBrand(String brand) {
		return dao.getVehicleByBrand(brand);
	}

	
}
