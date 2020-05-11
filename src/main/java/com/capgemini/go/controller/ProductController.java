package com.capgemini.go.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.go.dto.ProductDTO;
import com.capgemini.go.exception.ProductNotFoundException;
import com.capgemini.go.service.ProductService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api/v1")
public class ProductController {
	
	private static final Logger log=LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private ProductService productService;
	
	@GetMapping("/product-list")
	public ResponseEntity<List<ProductDTO>> getAllProduct()  {
		  log.info("Fetching the product list...");
		 List<ProductDTO> productList=productService.viewAllProduct();
		 return new ResponseEntity<List<ProductDTO>>(productList,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@PostMapping("/add-product")
	public ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody ProductDTO product)  {
		log.info("Adding the product...");
		ProductDTO addedProduct=productService.addProduct(product);
		return new ResponseEntity<ProductDTO>(addedProduct,new HttpHeaders(),HttpStatus.OK);
		
	}
	
	@PostMapping("/edit-product/{product_id}")
	public ResponseEntity<ProductDTO> editProduct(@Valid @RequestBody ProductDTO product,@PathVariable("product_id") String productID) throws ProductNotFoundException
	{
		log.info("Updating the product deatils...");
		 ProductDTO productForUpdate = productService.getProductByID(productID);
		 if(productForUpdate==null)	
		 {
			 throw new ProductNotFoundException("Product not found for this id :: " + productID);
		 }
		 productForUpdate.setColour(product.getColour());
		 productForUpdate.setDimension(product.getDimension());
		 productForUpdate.setManufacturer(product.getManufacturer());
		 productForUpdate.setPrice(product.getPrice());
		 productForUpdate.setProductCategory(product.getProductCategory());
		 productForUpdate.setProductName(product.getProductName());
		 productForUpdate.setQuantity(product.getQuantity());
		 productForUpdate.setSpecifications(product.getSpecifications());
		final ProductDTO updatedProduct= productService.editProduct(product);
		return new  ResponseEntity<ProductDTO>(updatedProduct,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-product/{product_id}")
	public HttpStatus deleteProduct(@PathVariable("product_id") String productID) throws ProductNotFoundException{
		log.info("Removing the product...");
		if(!productService.isPresent(productID))
		{
			throw new ProductNotFoundException("Product not found for this id :: " + productID);
		}
		 productService.deleteProduct(productID);
		 
	        return HttpStatus.FORBIDDEN;
	}
	
	@GetMapping("/product/{product_id}")
	public ResponseEntity<ProductDTO> getProductByID(@PathVariable("product_id") String productID) throws ProductNotFoundException
	{
		log.info("Fetching the product details...");
		ProductDTO product= productService.getProductByID(productID);
				if(product==null)
				{
				throw new ProductNotFoundException("Product not found for this id :: " + productID);
				}
		return new ResponseEntity<ProductDTO>(product,new HttpHeaders(),HttpStatus.OK);
	}
	
}
