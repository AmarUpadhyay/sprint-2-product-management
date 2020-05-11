package com.capgemini.go.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.go.dao.ProductDao;
import com.capgemini.go.dto.ProductDTO;


@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public ProductDTO addProduct(ProductDTO product) {
		
		return productDao.save(product);
	}

	@Override
	public void deleteProduct(String productID) {
		
			 productDao.deleteById(productID);
	}

	@Override
	public ProductDTO editProduct(ProductDTO product) {
		return productDao.save(product);
	}

	@Override
	public List<ProductDTO> viewAllProduct()  {
		
		return productDao.findAll();
	}

	@Override
	public ProductDTO getProductByID(String productID) {
		
		return productDao.findById(productID).get();
	}
	
	public boolean isPresent(String productID) {
		
		return productDao.existsById(productID);
	}

}
