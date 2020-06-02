package com.travel.book.app.common.dto;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * This is Response DTO used for inheritance purpose and holds transactions
 * status and response message
 * 
 * Please see the {@link com.travel.book.app.common.dto.Response}
 * 
 * @author Bala Nimse
 * 
 */

@Component
public class Response {

	private HttpStatus status;

	private String message;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
