package com.capgemini.go.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="product")
public class ProductDTO {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotEmpty(message="Please provide a Product ID")
	@Column(name="product_id")
	private String product_id;
	
	@NotNull(message="Please provide a product price")
	@Column(name="product_price")
	private double price;
	
	@Column(name="product_colour")
	@NotEmpty(message="Please provide a colour")
	private String colour;
	
	@NotEmpty(message="Please provide a dimension")
	@Column(name="product_dimension")
	private String dimension;
	
	@NotEmpty(message="Please provide a specification")
	@Column(name="product_specifications")
	private String specifications;
	
	@NotEmpty(message="Please provide a manufacturer")
	@Column(name="product_manufacturer")
	private String manufacturer;
	
	@NotNull(message="Please provide a quantity")
	@Column(name="product_quantity")
	private int quantity;
	
	@NotEmpty(message="Please provide a category")
	@Column(name="product_category")
	private String productCategory;
	
	@NotEmpty(message="Please provide a product name")
	@Column(name="product_name")
	private String productName;
	
	public String getProduct_id() {
		return product_id;
	}
	
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getColour() {
		return colour;
	}
	
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public String getDimension() {
		return dimension;
	}
	
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	
	public String getSpecifications() {
		return specifications;
	}
	
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getProductCategory() {
		return productCategory;
	}
	
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	@Override
	public String toString() {
		return "ProductDTO [productID=" + product_id + ", price=" + price + ", colour=" + colour + ", dimension="
				+ dimension + ", specifications=" + specifications + ", manufacturer=" + manufacturer + ", quantity="
				+ quantity + ", productCategory=" + productCategory + ", productName=" + productName + "]";
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ProductDTO(String product_id, double price, String colour, String dimension, String specifications,
			String manufacturer, int quantity, String productCategory, String productName) {
		super();
		this.product_id = product_id;
		this.price = price;
		this.colour = colour;
		this.dimension = dimension;
		this.specifications = specifications;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.productCategory = productCategory;
		this.productName = productName;
	}
	public ProductDTO() {
		
	}
	
	
	
}
