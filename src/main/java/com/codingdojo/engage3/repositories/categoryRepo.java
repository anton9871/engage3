package com.codingdojo.engage3.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.codingdojo.engage3.models.Category;

@Repository
public interface categoryRepo extends CrudRepository<Category, Long> {

	List<Category> findAll();
	
	void deleteById(long id);
	
	Optional<Category> findById(Long id);
}
