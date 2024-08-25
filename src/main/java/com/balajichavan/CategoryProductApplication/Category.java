package com.balajichavan.CategoryProductApplication;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;

    @OneToMany(mappedBy="category", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Product> products=new HashSet<>();
	
    
    //Constrctors
	public Category() {
		// TODO Auto-generated constructor stub
	}
	
   
    public Category(String name) {
		super();
		this.name = name;
	}



    //Getters & setters

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 
//    public Set<Product> getProducts() {
//        return products;
//    }
//    
//    public void setProducts(Set<Product> p) {
//    	this.products=p;
//    }
}