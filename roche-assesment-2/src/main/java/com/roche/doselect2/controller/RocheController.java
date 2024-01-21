package com.roche.doselect2.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roche.doselect2.exception.TechnicalException;
import com.roche.doselect2.service.RocheService;
import com.roche.doselect2.service.StaticsService;

@RestController
@RequestMapping("/api")
public class RocheController {
	
	Logger logger = LoggerFactory.getLogger(RocheController.class);

	@Autowired
	private RocheService rocheService;
	
	@Autowired
	private StaticsService staticsService;
	
	@GetMapping("/fizzbuzz")
    public ResponseEntity<List<String>> getFizzBuzz(
            @RequestParam int int1,
            @RequestParam int int2,
            @RequestParam int limit,
            @RequestParam String str1,
            @RequestParam String str2) throws TechnicalException {
		try {
            List<String> result = rocheService.generateFizzBuzz(int1, int2, limit, str1, str2);
            staticsService.updateStatistics(int1, int2, limit, str1, str2);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
        	e.printStackTrace();
        	logger.error("Exception occurred ");
            throw new TechnicalException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception occurred.");
           
        }
    }
	
	@GetMapping("/statistics")
    public ResponseEntity<Map<String, Object>> getStatistics() throws TechnicalException {
        try {
            Map<String, Object> statistics = staticsService.getStatistics();
            return ResponseEntity.ok(statistics);
        } catch (Exception e) {            
        	e.printStackTrace();
        	logger.error("Exception occurred ");
            throw new TechnicalException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception occurred.");
        }
    }

}
