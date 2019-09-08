package com.providus.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.providus.model.ProvidusOrder;

import lombok.Data;

@Data
public class ProvidusOrderDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double orderAmount;
	private String currency;
	private String description;
	@JsonDeserialize
	private Date dueDate;
	private int orderId;
	private String status;
	
	private Set<ProductDTO> products;
	
	public ProvidusOrderDTO() {
		
	}
	
	public ProvidusOrderDTO(ProvidusOrder providusOrder) {
		this.orderId = providusOrder.getOrderId();
		this.currency = providusOrder.getCurrency().getDisplayName();
		this.status = providusOrder.getOrderStatus();
		this.dueDate = providusOrder.getDueDate();
		this.description = providusOrder.getDescription();
		this.orderAmount = providusOrder.getOrderAmount();
		this.products = providusOrder.getProductSet().stream().map(product->new ProductDTO(product)).collect(Collectors.toSet());
	}
	/**
	 * @return the orderAmount
	 */
	public double getOrderAmount() {
		return orderAmount;
	}
	/**
	 * @param orderAmount the orderAmount to set
	 */
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}
	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the products
	 */
	public Set<ProductDTO> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(Set<ProductDTO> products) {
		this.products = products;
	}
	

}
