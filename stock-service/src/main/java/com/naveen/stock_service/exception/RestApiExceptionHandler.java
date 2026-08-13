package com.naveen.stock_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestApiExceptionHandler {
	
	@ExceptionHandler(value=StockNotFoundExcetion.class)
	public ResponseEntity<String> handleCompanyNotFoundException(StockNotFoundExcetion st){
		return new ResponseEntity<String>(st.getMessage(),HttpStatus.BAD_REQUEST);
	}
	

}
