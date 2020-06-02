package com.travel.book.app.common.dto;

import org.springframework.stereotype.Component;

/**
 * This is Data Transfer Object carries individual booking
 * 
 * Please see the {@link com.travel.book.app.common.dto.BookingResponse}
 * 
 * @author Bala Nimse
 * 
 */

@Component
public class BookingResponse extends Response {

	private Integer bookingId;

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

}
