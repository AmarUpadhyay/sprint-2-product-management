package com.capgemini.go.service;

import java.util.List;

import com.capgemini.go.dto.ProductDTO;


public interface ProductService {
	public ProductDTO addProduct(ProductDTO product)  ;
	public void deleteProduct(String productID) ;
	public ProductDTO editProduct(ProductDTO product) ;
	public List<ProductDTO> viewAllProduct();
	public ProductDTO getProductByID(String productID);
	public boolean isPresent(String productID);
}
