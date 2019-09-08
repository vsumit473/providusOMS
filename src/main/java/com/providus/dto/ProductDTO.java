/**
 * 
 */
package com.providus.dto;

import com.providus.model.Product;

/**
 * @author SUMIT VERMA
 *
 */
public class ProductDTO {
	
	private String productName;
	private int id;
	
	public ProductDTO() {
		
	}
	
	public ProductDTO(Product product) {
		this.id=product.getProductId();
		this.productName=product.getProductName();
	}
	
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
