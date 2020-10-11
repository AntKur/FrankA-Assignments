package com.franka.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franka.productsandcategories.models.Category;
import com.franka.productsandcategories.models.Product;
import com.franka.productsandcategories.repositories.CategoryRepository;
import com.franka.productsandcategories.repositories.ProductRepository;


@Service
public class ProductCategoryService {
	@Autowired
	private ProductRepository pRepo;
	@Autowired
	private CategoryRepository cRepo;
	
	public List<Category> getCategories(){
		return this.cRepo.findAll();
	}
	
	public List<Product> getProducts(){
		return this.pRepo.findAll();
	}
	
	public Category createCategory(Category category) {
		return this.cRepo.save(category);
	}
	
	public Product createProduct(Product product) {
		return this.pRepo.save(product);
	}
	
	public Category getCategory(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	
	public Product getProduct(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	public List<Category> getNonBelongingCategories(Product product){
		return this.cRepo.findByProductsNotContaining(product);
	}
	
	public List<Product> getNonBelongingProducts(Category category){
		return this.pRepo.findByCategoriesNotContaining(category);
	}
	
	public Category addProduct(Category category, Product product) {
		List<Product> products = category.getProducts();
		products.add(product);
		return this.cRepo.save(category);
	}
	
	public Product addCategory(Product product, Category category) {
		List<Category> categories = product.getCategories();
		categories.add(category);
		return this.pRepo.save(product);
	}
}
