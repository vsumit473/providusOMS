/**
 * 
 */
package com.providus.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.providus.model.Product;
import com.providus.repository.ProductRepository;
import com.providus.service.ProductService;

/**
 * @author SUMIT VERMA
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
		
	}

}
