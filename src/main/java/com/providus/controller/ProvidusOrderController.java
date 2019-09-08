package com.providus.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.providus.dto.ProvidusOrderDTO;
import com.providus.model.Currency;
import com.providus.model.Product;
import com.providus.model.ProvidusOrder;
import com.providus.service.CurrencyService;
import com.providus.service.ProductService;
import com.providus.service.ProvidusOrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author SUMIT VERMA
 *
 */
@RestController
@RequestMapping("/providus")
@Api(value="OrderManagementSystem", description="Operations pertaining to order management system")
public class ProvidusOrderController {
	
	@Autowired
	private ProvidusOrderService orderService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CurrencyService currencyService;
	
	

    @PostMapping("/order")
    @ApiOperation(value = "Place an order",response = String.class)
    public ResponseEntity<String> createOrder(@RequestBody ProvidusOrderDTO order) {
    	ProvidusOrder createOrder  = null;
    	if(null!= order) {
				createOrder = orderService.createOrder(order);
    	}
    	return new ResponseEntity<String>("Order is created with order id "+ createOrder.getOrderId(), HttpStatus.CREATED);
    }
    
    @PutMapping("/order/status/{id}")
    @ApiOperation(value = "Update an order status",response = String.class)
    public ResponseEntity<String> updateOrderSatus(@RequestParam(value="status") String status, @PathVariable(value="id") Integer orderId) {
    	ProvidusOrder updatedOrder  = new ProvidusOrder();
    	updatedOrder.setOrderId(orderId);
    	updatedOrder.setOrderStatus(status);
    	if(null!= updatedOrder) {
				updatedOrder = orderService.updateOrder(updatedOrder);
				
    	}
    	return new ResponseEntity<String>("Order is updated successfully with status --> "+ updatedOrder.getOrderStatus() , HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/order")
    @ApiOperation(value = "Provide list of all orders/due orders, if filter param value is true then fetches overdue orders",response = List.class)
    public ResponseEntity<List<ProvidusOrderDTO>> getOverDueOrders(@RequestParam(value="filter", required = false ) boolean filter) {
		
    	List<ProvidusOrderDTO> orders = null;
    	if(filter) {
    		orders = orderService.getDueOrders();
    	}
    	else {
    		 orders = orderService.retrieveAllOrders();
    	}
    	
    	return new ResponseEntity<List<ProvidusOrderDTO>>(orders , HttpStatus.OK);
    }
    
    @GetMapping("/product")
    @ApiOperation(value = "Provide list of all valid Products in the system",response = List.class)
    public ResponseEntity<List<Product>> getAllProducts() {
		
    	
    	List<Product> allProducts = productService.getAllProducts();
    	
    	return new ResponseEntity<List<Product>>(allProducts , HttpStatus.OK);
    }
    
    @GetMapping("/currency")
    @ApiOperation(value = "Provide list of all valid currencis accepted in the system",response = List.class)
    public ResponseEntity<List<Currency>> getAllCurrency() {
		
    	
    	List<Currency> allCurrency = currencyService.getAllCurrency();
    	
    	return new ResponseEntity<List<Currency>>(allCurrency , HttpStatus.OK);
    }
    
    
    
    
    
}
