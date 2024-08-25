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
public class ProductController {
	
	@Autowired
	private ProductRepo productRepo;
	
	@GetMapping("/api/products")
	public List<Product> getAllProduct(){
		return productRepo.findAll();
	}
	
	@PostMapping("/api/products")
	public Product saveProduct(@RequestBody Product product){
		return productRepo.save(product);
	}
	
	@GetMapping("/api/products/{id}")
	public Product getByIdProduct (@PathVariable Integer id){
		return productRepo.findById(id).orElseThrow(()->new ProductNotFoundException(id));
	}
		
	
	@DeleteMapping("/api/products/{id}")
	public String deleteProduct(@PathVariable Integer id){

		if(!productRepo.existsById(id)) 
			throw new ProductNotFoundException(id);
		
		 productRepo.deleteById(id);
		 return "Deleted Sucessfully";
	}
	
	@PutMapping("/api/products/{id}")
	public String updateProduct (@PathVariable Integer id,@RequestBody Product newProduct){
		Optional<Product> product= productRepo.findById(id);
		
		if(!productRepo.existsById(id)) 
			throw new ProductNotFoundException(id);
		else {
		
				if(product.isPresent()) {
				Product existingProduct=product.get();
				existingProduct.setName(newProduct.getName());
				existingProduct.setPrice(newProduct.getPrice());
				existingProduct.setQuantity(newProduct.getQuantity());
				existingProduct.setCategory(newProduct.getCategory());
				 productRepo.save(existingProduct);
		}
			} 
		 return "Updated Secessfully";
		
		
	}
	
}
