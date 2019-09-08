/**
 * 
 */
package com.providus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.providus.exception.ProvidusServiceException;

/**
 * @author SUMIT VERMA
 *
 */
@ControllerAdvice(annotations = RestController.class)
public class ExceptionHandlerController {
	
	
	@ExceptionHandler(ProvidusServiceException.class)
	public ResponseEntity<String> hadleException(final ProvidusServiceException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		
	}

}
