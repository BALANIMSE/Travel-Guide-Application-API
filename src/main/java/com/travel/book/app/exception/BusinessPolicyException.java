package com.travel.book.app.exception;

/**
 * This is a Custom Business Policy Exception 
 * 
 * Please see the {@link com.travel.book.app.exception.BusinessPolicyException}
 * 
 * @author Bala Nimse
 * 
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class BusinessPolicyException extends RuntimeException {

	public BusinessPolicyException(String message) {
		super(message);
	}
}