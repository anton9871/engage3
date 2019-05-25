package com.codingdojo.engage3.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.engage3.models.Category;
import com.codingdojo.engage3.models.Product;
import com.codingdojo.engage3.repositories.categoryRepo;
import com.codingdojo.engage3.repositories.productRepo;

@Service
public class MasterService {
	private final categoryRepo catRepo;
	private final productRepo prodRepo;
	
	public MasterService(categoryRepo catRepo, productRepo prodRepo) {
		this.catRepo = catRepo;
		this.prodRepo = prodRepo;
	}
	
	
//	Create a new category
	public Category createCategory(Category category) {
		return catRepo.save(category);
	}
	
//	Get all categories
	public List<Category> getAllCategories(){
		return catRepo.findAll();
	}

//	Get specific category
	public Category retrieveCategory(Long id) {
		Optional<Category> optCat = catRepo.findById(id);
		if(optCat.isPresent()) {
			return optCat.get();
		} else {
			return null;
		}
	}
	
//	Delete category
	public void deleteCategory(Long id) {
		catRepo.deleteById(id);
	}
	
//	Update category
	public Category updateCategory(Long id, Category category) {
		Category oldCat = retrieveCategory(id);
		oldCat.setName(category.getName());
		oldCat.setParent_id(category.getParent_id());
		catRepo.save(oldCat);
		return oldCat;
	}
	
//	Create a new product
	public Product createProduct(Product product) {
		return prodRepo.save(product);
	}
	
	
//	Get all products
	public List<Product>getProducts(){
		return prodRepo.findAll();
	}
	
	
//	Get specific product
	public Product retrieveProduct(Long id) {
		Optional<Product> optProd = prodRepo.findById(id);
		if(optProd.isPresent()) {
			return optProd.get();
		} else {
			return null;
		}
	}
	
//	Delete product
	public void deleteProduct(Long id) {
		prodRepo.deleteById(id);
	}
	
//	Update product
	public Product updateProduct(Long id, Product product) {
		Product oldProd = retrieveProduct(id);
		oldProd.setName(product.getName());
		oldProd.setCategory(product.getCategory());
		prodRepo.save(oldProd);
		return oldProd;
	}
}
