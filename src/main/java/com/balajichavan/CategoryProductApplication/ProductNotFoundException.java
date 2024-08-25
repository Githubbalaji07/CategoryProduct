package com.balajichavan.CategoryProductApplication;

public class ProductNotFoundException extends RuntimeException {
	
	 public ProductNotFoundException(Integer id) {
			super("Product with Id "+id+" Not Found ");
		}
	 
	 
}
