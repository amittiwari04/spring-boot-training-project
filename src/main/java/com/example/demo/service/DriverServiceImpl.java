package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDriverDao;
import com.example.demo.entity.Driver;

@Service
public class DriverServiceImpl implements IDriverService{

	@Autowired
	IDriverDao dao;
	
	@Override
	public List<Driver> getAllDrivers() {
		
		List<Driver> listOfDriver= dao.findAll();
		return listOfDriver;
	}

}
