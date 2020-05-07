package com.capgemini.go.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.dto.ProductDTO;
import com.capgemini.go.service.ProductService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/product-management")
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/product-list")
	public List<ProductDTO> getAllProduct()  {
		
			return productService.viewAllProduct();
	}
	@PostMapping("/add-product")
	public boolean addProduct(@Valid @RequestBody ProductDTO product)  {
		
		return productService.addProduct(product);
		
	}
	
	@PostMapping("/edit-product/{product_id}")
	public boolean editProduct(@Valid @RequestBody ProductDTO product,@PathVariable("product_id") String productID) 
	{
		product.setProduct_id(productID);
		return productService.editProduct(product);
	}
	
	@DeleteMapping("/delete-product/{product_id}")
	public boolean deleteProduct(@PathVariable("product_id") String productID){
		
		return productService.deleteProduct(productID);
	}
	
	@GetMapping("/product/{product_id}")
	public List<ProductDTO> getProductByID( ProductDTO product,@PathVariable("product_id") String productID) 
	{
		product.setProduct_id(productID);
		return productService.getProductByID(product);
	}
	
}
