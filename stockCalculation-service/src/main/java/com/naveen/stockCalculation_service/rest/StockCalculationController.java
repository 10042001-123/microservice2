package com.naveen.stockCalculation_service.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.stockCalculation_service.FeignInterface;

@RestController
@RequestMapping("stockCalculation")
public class StockCalculationController {
	private static final Logger log=LoggerFactory.getLogger(StockCalculationController.class);
	
	@Autowired
	FeignInterface feignInterface;
	
	@GetMapping("/getPriceOfStock/{companyName}/{numOfStocks}")
	public ResponseEntity<?> getPriceOfStock(@PathVariable String companyName,@PathVariable Integer numOfStocks ){
		log.info("in stock calculation");
		ResponseEntity<?> resEntity=null;
		Double totalPrice;
		try {	
			resEntity =feignInterface.fetchByCompanyName(companyName);
			int status =resEntity.getStatusCode().value();
			if(status == 200) {
				Double price =(Double)resEntity.getBody();
				totalPrice =price*numOfStocks;
				String response="the total price is :"+totalPrice;
				resEntity = new ResponseEntity(response,HttpStatus.OK);
			}
			
	
		}catch(Exception e){
			resEntity=new ResponseEntity("Company not found",HttpStatus.OK);
			
		}
		return resEntity;
	}
	

}
