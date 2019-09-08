/**
 * 
 */
package com.providus.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.providus.model.Currency;
import com.providus.repository.ProvidusCurrencyRepository;
import com.providus.service.CurrencyService;

/**
 * @author SUMIT VERMA
 *
 */
@Service
public class CurrencyServiceImpl implements CurrencyService {
	
	@Autowired
	private ProvidusCurrencyRepository currencyRepository;

	@Override
	public List<Currency> getAllCurrency() {
		
		return (List<Currency>) currencyRepository.findAll();
	}

}
