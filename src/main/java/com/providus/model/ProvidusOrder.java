package com.providus.model;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;

@Entity
public class ProvidusOrder implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -6401466405574559925L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID")
    private int orderId;
    @Column(name = "ORDER_AMOUNT")
    private double orderAmount;
    @OneToOne
    @JoinColumn(name="CURRENCY")
    private Currency currency;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="DUE_DATE")
    private Date dueDate;
    @Column(name="ORDER_STATUS")
    private String orderStatus;
    @ManyToMany
    @JoinTable(
            name="PRODUCT_ORDER_MAPPING",
            joinColumns={
                    @JoinColumn(name="ORDER_ID", referencedColumnName="ORDER_ID"),
                    },
            inverseJoinColumns=@JoinColumn(table="PRODUCT",name="PRODUCT_ID", referencedColumnName="PRODUCT_ID")
            )
    private Set<Product> productSet;
	/**
	 * @return the productSet
	 */
	public Set<Product> getProductSet() {
		return productSet;
	}
	/**
	 * @param productSet the productSet to set
	 */
	public void setProductSet(Set<Product> productSet) {
		this.productSet = productSet;
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
	public Currency getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(Currency currency) {
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
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}
	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
    
}