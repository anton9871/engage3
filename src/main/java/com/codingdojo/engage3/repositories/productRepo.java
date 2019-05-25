package com.codingdojo.engage3.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.engage3.models.Product;

@Repository
public interface productRepo extends CrudRepository<Product, Long>{

	List<Product> findAll();
	
	void deleteById(long id);
	
	Optional<Product> findById(Long id);
	
}
