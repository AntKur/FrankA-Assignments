package com.franka.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.franka.productsandcategories.models.Category;
import com.franka.productsandcategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	List<Product> findByCategoriesNotContaining(Category cateogry);
}
//@Query("select u from Product u where u.id not in ?1")
//List<Product> findByProductNotIn(List<Product> products);
