package com.balajichavan.CategoryProductApplication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> hadleException(ProductNotFoundException except){
		return new ResponseEntity<>(except.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<String> hadleException(CategoryNotFoundException except){
		return new ResponseEntity<>(except.getMessage(),HttpStatus.NOT_FOUND);
	}
}
