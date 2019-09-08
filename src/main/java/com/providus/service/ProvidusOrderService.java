package com.providus.service;

import java.util.List;

import com.providus.dto.ProvidusOrderDTO;
import com.providus.exception.ProvidusServiceException;
import com.providus.model.ProvidusOrder;

public interface ProvidusOrderService {
	
	ProvidusOrder createOrder(ProvidusOrderDTO order) throws ProvidusServiceException;
	
	ProvidusOrder updateOrder(ProvidusOrder order);
	
	List<ProvidusOrderDTO> getDueOrders();
	
	List<ProvidusOrderDTO> retrieveAllOrders();

}
