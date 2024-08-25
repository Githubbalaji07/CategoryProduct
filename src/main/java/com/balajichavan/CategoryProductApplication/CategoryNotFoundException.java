package com.balajichavan.CategoryProductApplication;

import org.springframework.stereotype.Controller;


public class CategoryNotFoundException extends RuntimeException{
	
	public CategoryNotFoundException() {
		// TODO Auto-generated constructor stub
	}	
	
	public CategoryNotFoundException(Integer id) {
			super("Category with Id "+id+" Not Found ");
		}
}
