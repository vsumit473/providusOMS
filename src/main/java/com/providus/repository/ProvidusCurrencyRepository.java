/**
 * 
 */
package com.providus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.providus.model.Currency;

/**
 * @author SUMIT VERMA
 *
 */
@Repository
public interface ProvidusCurrencyRepository extends CrudRepository<Currency, Integer>{
	
	Currency findByDisplayName(String displayName);
	

}
