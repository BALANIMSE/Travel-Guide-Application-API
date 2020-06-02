package com.travel.book.app.common.interfaces;

import org.springframework.stereotype.Component;

import com.travel.book.app.common.dto.Request;

/**
 * This is a Business Policy Interface
 * 
 * Please see the {@link com.travel.book.app.common.interfaces.IBusinessPolicy}
 * 
 * @author Bala Nimse
 * 
 */
@Component
public interface IBusinessPolicy {

	public boolean validate(Request request);

}
