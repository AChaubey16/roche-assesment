package com.roche.doselect2;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.roche.doselect2.exception.TechnicalException;

@ControllerAdvice
public class RocheAdviceController {
	
	Logger logger = LoggerFactory.getLogger(RocheAdviceController.class);
	
	@ExceptionHandler(TechnicalException.class)
	public ResponseEntity<Object> handleInvalidOTPException(TechnicalException e) {
		logger.error(e.getMessage() + " : " + e.getCause());
		HashMap<String, Object> errors = new HashMap<String, Object>();
		errors.put(e.getErrorcode().toString(), e.getMessage());
		return new ResponseEntity<Object>(errors, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
