package com.naveen.stockCalculation_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("STOCK-SERVICE")
public interface FeignInterface {
	@GetMapping("/stock/fetchByCompanyName/{companyName}")
	public ResponseEntity<Double> fetchByCompanyName(@PathVariable String companyName);

}
