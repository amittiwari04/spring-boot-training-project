package com.example.demo.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @Value(value = "${data.exception.message1}")
    private String message1;
    @Value(value = "${data.exception.message2}")
    private String message2;
//    @Value(value = "${data.exception.message3}")
//    private String message3;
    
    @ExceptionHandler(value=VehicleNotFoundException.class)
	public ResponseEntity<String> handleInvalidVehicleId(VehicleNotFoundException ve) {
		return new ResponseEntity<String>(message1,HttpStatus.CONFLICT);
	}
   @ExceptionHandler(value = DriverMissingException.class)
    public ResponseEntity databaseConnectionFailsException(DriverMissingException exception) {
        return new ResponseEntity(message2, HttpStatus.NOT_FOUND);
    }
}