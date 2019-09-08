/**
 * 
 */
package com.providus.exception;

/**
 * @author SUMIT VERMA
 *
 */
public class ProvidusServiceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8620946240570919717L;

	public ProvidusServiceException(String msg) {
		super(msg);
	}

	public ProvidusServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProvidusServiceException(Throwable cause) {
		super(cause);
	}
	
	

}
