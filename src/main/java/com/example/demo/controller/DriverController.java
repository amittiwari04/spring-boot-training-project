package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Driver;
import com.example.demo.service.IDriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	private IDriverService service;
	
//	@RequestMapping(value="/get",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(value="/get",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Driver>> getDriverList(){
		List<Driver> list1=service.getAllDrivers();
		return new ResponseEntity<List<Driver>>(list1,HttpStatus.OK); 
	}
}

//@GetMapping(value="/greet")
//public String greet() {
//	return "Good Morning";
//}
//@GetMapping(value="/greetme/{name}")
//public String greetMe(@PathVariable("name") String myName){
//	return "good morning "+myName;
//}
