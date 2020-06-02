package com.travel.book.app.exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.travel.book.app.common.interfaces.ApplicationConstants;;

/**
 * This is a Application Exception Handler Controller advice class
 * 
 * Please see the {@link com.travel.book.app.exception.AppExceptionHandler}
 * 
 * @author Bala Nimse
 * 
 */
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(AccessDeniedException.class)
	public final ResponseEntity<Error> handleAllExceptions(AccessDeniedException ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap();

		body.put(ApplicationConstants.TIMESTAMP, new Date());
		body.put(ApplicationConstants.STATUS, HttpStatus.FORBIDDEN);
		body.put(ApplicationConstants.MESSAGE, ex.getLocalizedMessage());

		return new ResponseEntity(body, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(BusinessPolicyException.class)
	public final ResponseEntity<Error> handleAllExceptions(BusinessPolicyException ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap();

		body.put(ApplicationConstants.TIMESTAMP, new Date());
		body.put(ApplicationConstants.STATUS, HttpStatus.NOT_ACCEPTABLE);
		body.put(ApplicationConstants.MESSAGE, ex.getLocalizedMessage());

		return new ResponseEntity(body, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<Error> handleAllExceptions(NotFoundException ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap();

		body.put(ApplicationConstants.TIMESTAMP, new Date());
		body.put(ApplicationConstants.STATUS, HttpStatus.NOT_FOUND);
		body.put(ApplicationConstants.MESSAGE, ex.getLocalizedMessage());

		return new ResponseEntity(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Error> handleAllExceptions(Exception ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap();

		body.put(ApplicationConstants.TIMESTAMP, new Date());
		body.put(ApplicationConstants.STATUS, HttpStatus.INTERNAL_SERVER_ERROR);
		body.put(ApplicationConstants.MESSAGE,
				"System cannot process your request currently. Please contact administrator.");

		return new ResponseEntity(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap();

		body.put(ApplicationConstants.TIMESTAMP, new Date());
		body.put(ApplicationConstants.STATUS, status.value());
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());
		body.put(ApplicationConstants.MESSAGE, errors);

		return new ResponseEntity(body, headers, status);
	}

}
