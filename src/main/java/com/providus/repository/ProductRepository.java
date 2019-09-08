/**
 * 
 */
package com.providus.repository;

import org.springframework.data.repository.CrudRepository;

import com.providus.model.Product;

/**
 * @author SUMIT VERMA
 *
 */
public interface ProductRepository extends CrudRepository<Product, Integer>{
	
	Product findByProductName(String productName);

}
