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
	public boolean addProduct(ProductDTO product) {
		
		return productDao.addProduct(product);
	}

	@Override
	public boolean deleteProduct(String productid) {
		
			return productDao.deleteProduct(productid);
	}

	@Override
	public boolean editProduct(ProductDTO product) {
		
		
		
			return productDao.editProduct(product);
	}

	@Override
	public List<ProductDTO> viewAllProduct()  {
		
		return productDao.viewAllProduct();
	}

	@Override
	public List<ProductDTO> getProductByID(ProductDTO product) {
		
		return productDao.grtProductByID(product);
	}

}
