package com.codingdojo.engage3.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="categories")
public class Category {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    
    private String name;
    
    private Long parent_id;
    
    @OneToMany(mappedBy="category", fetch = FetchType.LAZY)
    private List<Product> products;
    
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getParent_id() {
		return parent_id;
	}
	
	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}
	
	public Long getId() {
		return id;
	}
    
    

}
