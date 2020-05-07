package com.capgemini.go.service;

import java.util.List;

import com.capgemini.go.dto.ProductDTO;


public interface ProductService {
	boolean addProduct(ProductDTO product)  ;
	boolean deleteProduct(String productid) ;
	boolean editProduct(ProductDTO product) ;
	List<ProductDTO> viewAllProduct();
	public List<ProductDTO> getProductByID(ProductDTO product);
}
