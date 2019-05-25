

package com.codingdojo.engage3.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.engage3.models.Category;
import com.codingdojo.engage3.models.Product;
import com.codingdojo.engage3.services.MasterService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class controller {
	private final MasterService masterServ;
	
	public controller(MasterService masterServ) {
		this.masterServ = masterServ;
	}
	
//	get all categories
	@GetMapping("/category")
	public List<Category> getCategories(){
		return  masterServ.getAllCategories();
	}
	
//	get specific category
	@GetMapping("/category/{id}")
	public Category getCategory(@PathVariable(value="id")Long id){
		return  masterServ.retrieveCategory(id);
	}
	
//	create a category
	@PostMapping("/category")
	public @ResponseBody Category createCategory(@RequestBody Category category) {
		Category newCategory = masterServ.createCategory(category);
		return newCategory;
	}
	
//	update a category
	@PutMapping("/category/{id}")
	public @ResponseBody Category updateCategory(@RequestBody Category category, @PathVariable(value="id")Long id) {
		Category updatedCategory = masterServ.updateCategory(id, category);
		return updatedCategory;
	}
	
//	delete a category
	@DeleteMapping("/category/{id}")
	public void deleteCategory(@PathVariable(value="id")Long id){
		masterServ.deleteCategory(id);
	}

	
//	get all products
	@GetMapping("/products")
	public List<Product> getAllProducts (){
		
		return masterServ.getProducts();
	}
	
	
//	get specific product
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable(value="id")Long id) {
		return masterServ.retrieveProduct(id);
	}
	
//	create a product
	@PostMapping("/product")
	public Product createProduct(@RequestBody Product product) {
		Product newProduct = masterServ.createProduct(product);
		return newProduct;
	}
	
//	update a product
	@PutMapping("/product/{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable(value="id")Long id) {
		Product updatedProduct = masterServ.updateProduct(id, product);
		return updatedProduct;
	}
	
//	delete a product
	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable(value="id")Long id) {
		masterServ.deleteProduct(id);
	}
	
}
