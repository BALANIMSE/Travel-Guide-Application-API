package com.travel.book.app.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import com.travel.book.app.common.dto.Response;

/**
 * This is Root controller class
 * 
 * Please see the {@link com.travel.book.app.common.BaseController}
 * 
 * @author Bala Nimse
 * 
 */

public class BaseController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	protected Response buildSuccessResponse(Response response) {

		logger.info("buildSuccessResponse");

		response.setStatus(HttpStatus.OK);
		response.setMessage("Operation Successful");

		return response;
	}

}
