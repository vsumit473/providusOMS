/**
 * 
 */
package com.providus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author SUMIT VERMA
 *
 */
@Entity
public class Product implements Comparable<Product>,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8381456315471747057L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRODUCT_ID")
	private int productId;
	@Column(name="PRODUCT_NAME")
	private String productName;
	@Column(name="PRODUCT_DESC")
	private String productDescription;

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
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
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}
	/**
	 * @param productDescription the productDescription to set
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	@Override
	public int compareTo(Product o) {
		
		return this.productName.compareToIgnoreCase(o.getProductName());
	}
}
