package com.example.demo.controller;

import java.util.List;
import java.util.Optional;import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Driver;
import com.example.demo.entity.Vehicle;
import com.example.demo.exception.VehicleNotFoundException;
import com.example.demo.service.IDriverService;
import com.example.demo.service.IVehicleService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/vehicle")
public class VehicleController {
	
	@Autowired
	private IVehicleService service;

	@GetMapping(value="/get")
	public ResponseEntity<List<Vehicle>> getDriverList(){
		List<Vehicle> listOfDriver=service.getAllVehicles();
		return new ResponseEntity<List<Vehicle>>(listOfDriver,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle v1){
		Vehicle veh1=service.insertVehicle(v1);
		return new ResponseEntity<Vehicle>(veh1,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteVehicle/{id}")
	public ResponseEntity<String> deleteVehicle(@PathVariable int id){
		boolean flag=service.deleteVehicleById(id);
		ResponseEntity<String> msg=null;
		if(flag=true) {
			msg=new ResponseEntity<String>("Vehicle deleted successfully",HttpStatus.OK);
		}else {
			msg=new ResponseEntity<String>("Vehicle not found",HttpStatus.OK);
		}
		return msg;
	}
	
	@PutMapping("/edit/{vid}")
	public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle v1,@PathVariable int vid){
		Vehicle veh1=service.updateVehicle(v1, vid);
		return new ResponseEntity<Vehicle>(veh1,HttpStatus.OK);
	}
	
	@GetMapping("/search/{brand}")
	public ResponseEntity<List<Vehicle>> getVehicle(@PathVariable String brand){
		List<Vehicle> veh1=service.searchVehicleByBrand(brand);
		return new ResponseEntity<List<Vehicle>>(veh1,HttpStatus.OK);
	}
	
//	@ExceptionHandler(value=VehicleNotFoundException.class)
//	public ResponseEntity<String> handleInvalidVehicleId(VehicleNotFoundException ve) {
//		return new ResponseEntity<String>("Vehicle Id is Invalid",HttpStatus.CONFLICT);
//	}
}
