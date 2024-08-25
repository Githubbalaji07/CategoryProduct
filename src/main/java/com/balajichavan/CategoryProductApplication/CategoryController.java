package com.balajichavan.CategoryProductApplication;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryRepo repo;
	
	@GetMapping("/api/categories")
	public List<Category> getAll(){
		return repo.findAll();
	}
	
	@PostMapping("/api/categories")
	public Category store(@RequestBody Category category) {
		return repo.save(category);
		
	}
	
	@GetMapping("/api/categories/{id}")
	public Category getByIdCategory(@PathVariable Integer id) {
		return repo.findById(id).orElseThrow(()->new CategoryNotFoundException(id));
	}
	
	@DeleteMapping("/api/categories/{id}")
	public String deleteByIdCategory(@PathVariable Integer id) {
		 
		 if(!repo.existsById(id)) 
				throw new CategoryNotFoundException(id);
			
		 repo.deleteById(id);
		 return "Deleted Sucessfully";
	}
	
	
	@PutMapping("/api/categories/{id}")
	public String update(@PathVariable Integer id,@RequestBody Category category) {
		Optional<Category> obj= repo.findById(id);
		
		if(!repo.existsById(id)) 
			throw new CategoryNotFoundException(id);
		else {
			if(obj.isPresent()) {
				Category existing=obj.get();
				existing.setName(category.getName());
			  repo.save(existing);	
			}
		}
		return "Updated Sucessfully";
	}
	
	
}
