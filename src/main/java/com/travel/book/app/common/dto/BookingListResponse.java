package com.travel.book.app.common.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * This is Data Transfer Object carries List of Bookings
 * 
 * Please see the {@link com.travel.book.app.common.dto.BookingListResponse}
 * 
 * @author Bala Nimse
 * 
 */

public class BookingListResponse extends Response {

	public List<Booking> bookings;

	public BookingListResponse() {

		this.bookings = new ArrayList<Booking>();
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

}
