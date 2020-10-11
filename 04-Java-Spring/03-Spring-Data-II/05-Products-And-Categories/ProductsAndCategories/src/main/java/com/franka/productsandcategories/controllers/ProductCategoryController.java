package com.franka.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.franka.productsandcategories.models.Category;
import com.franka.productsandcategories.models.Product;
import com.franka.productsandcategories.services.ProductCategoryService;

@Controller
public class ProductCategoryController {
	@Autowired
	private ProductCategoryService ser;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("categories", ser.getCategories());
		model.addAttribute("products", ser.getProducts());
		return "index.jsp";
	}
	
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newcat.jsp";
	}
	
	@PostMapping("/categories")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors())
			return "newcat.jsp";
		this.ser.createCategory(category);
		return "redirect:/";
	}
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newproduct.jsp";
	}
	
	@PostMapping("/products")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors())
			return "newproduct.jsp";
		this.ser.createProduct(product);
		return "redirect:/";
	}
	
	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		model.addAttribute("category", ser.getCategory(id));
		model.addAttribute("products", ser.getNonBelongingProducts(ser.getCategory(id)));
		return "showcat.jsp";
	}
	
	@PostMapping("/categories/{id}/add")
	public String addProductToCategory(@PathVariable("id") Long id, @RequestParam("productId") Long pId) {
		Category c = ser.getCategory(id);
		Product p = ser.getProduct(pId);
		ser.addProduct(c, p);
		return "redirect:/categories/" +id +"";
	}
	
	@GetMapping("products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		model.addAttribute("product", ser.getProduct(id));
		model.addAttribute("categories", ser.getNonBelongingCategories(ser.getProduct(id)));
		return "showproduct.jsp";
	}
	
	@PostMapping("/products/{id}/add")
	public String addCategoryToProduct(@PathVariable("id") Long id, @RequestParam("categoryId") Long cId) {
		Product p = ser.getProduct(id);
		Category c = ser.getCategory(cId);
		ser.addCategory(p, c);
		return "redirect:/products/" +id +"";
	}
}
