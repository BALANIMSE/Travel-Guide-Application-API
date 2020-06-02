package com.travel.book.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This is a Record Not found Custom Excetion
 * 
 * Please see the {@link com.travel.book.app.exception.NotFoundException}
 * 
 * @author Bala Nimse
 * 
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	public NotFoundException(String message) {
		super(message);
	}

}
