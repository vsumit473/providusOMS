/**
 * 
 */
package com.providus.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.providus.dto.ProductDTO;
import com.providus.dto.ProvidusOrderDTO;
import com.providus.exception.ProvidusDataException;
import com.providus.exception.ProvidusServiceException;
import com.providus.model.Currency;
import com.providus.model.Product;
import com.providus.model.ProvidusOrder;
import com.providus.repository.ProductRepository;
import com.providus.repository.ProvidusCurrencyRepository;
import com.providus.repository.ProvidusOrderRepository;
import com.providus.service.ProvidusOrderService;

/**
 * @author SUMIT VERMA
 *
 */
@Service
public class ProvidusServiceImpl implements ProvidusOrderService {
	
	@Autowired
	private ProvidusOrderRepository orderRepository;
	
	@Autowired
	private ProvidusCurrencyRepository currencyRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	Set<Product> products = null;

	@Override
	public ProvidusOrder createOrder(ProvidusOrderDTO providusOrder) throws ProvidusServiceException {
		ProvidusOrder save = null;
		try {
		ProvidusOrder order = new ProvidusOrder();
		order.setDescription(providusOrder.getDescription());
		order.setDueDate(providusOrder.getDueDate());
		order.setOrderStatus("Draft");
		order.setOrderAmount(providusOrder.getOrderAmount());
		Currency validateCurrency = validateCurrency(providusOrder);
		
		if(null == validateCurrency) {
			throw new ProvidusServiceException("Invalid Currency, Please try with valid one");
		}
		
		else {
			
			if(validateProducts(providusOrder)) {
				order.setProductSet(products);
			}
			else {
				throw new ProvidusServiceException("Invalid Products Selected, Please try with valid products, ");
			}
			order.setCurrency(validateCurrency);
			save = orderRepository.save(order);
		
		}
		}catch (Exception e) {
			if(e instanceof ProvidusServiceException) {
				throw (ProvidusServiceException)e;
			}
			throw new ProvidusServiceException("Error occured!! " + e.getMessage() , e);
		}
		return save;
	}


	private boolean validateProducts(ProvidusOrderDTO providusOrder) {
		boolean isProductValid = true;
		 products = new TreeSet<Product>();
		for(ProductDTO product : providusOrder.getProducts()) {
			Product productFromDB = productRepository.findByProductName(product.getProductName());
			if(null != productFromDB) {
				products.add(productFromDB);
			}
			else {
				break;
			}
		}
		
		if(providusOrder.getProducts().size() != products.size()) {
			isProductValid = false;
		}
		
		return isProductValid;
		
	}


	private Currency validateCurrency(ProvidusOrderDTO providusOrder) throws ProvidusDataException {
		Currency findByDisplayName = null;
		if(providusOrder.getCurrency() == null) {
			return null;
		}
		else {
			 try {
				findByDisplayName = currencyRepository.findByDisplayName(providusOrder.getCurrency());
			} catch (Exception e) {
				
				throw new ProvidusDataException("Something went wrong while validating currency "+ e.getMessage(), e);
			}
			
		}
		return findByDisplayName;
	}


	@Override
	public ProvidusOrder updateOrder(ProvidusOrder order) {
		
		try {
			
		Optional<ProvidusOrder> findById = orderRepository.findById(order.getOrderId());
		if(findById.isPresent()) {
			findById.get().setOrderStatus(order.getOrderStatus());
			orderRepository.save(findById.get());
			
		}
		return findById.get();
		}catch (Exception e) {
			throw new ProvidusServiceException("Error occured while updating order status ", e);
		}
		
	}


	@Override
	public List<ProvidusOrderDTO> getDueOrders() {
		
		List<ProvidusOrder> list = orderRepository.getDueOrders();
		return list.stream().map(o->new ProvidusOrderDTO(o)).collect(Collectors.toList());
		
	}


	@Override
	public List<ProvidusOrderDTO> retrieveAllOrders() {
		 List<ProvidusOrder> findAll = (List<ProvidusOrder>) orderRepository.findAll();
		 return findAll.stream().map(o->new ProvidusOrderDTO(o)).collect(Collectors.toList());
	}

}
