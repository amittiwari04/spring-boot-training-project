package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Driver;

public interface IDriverService {
	public List<Driver> getAllDrivers();
}
