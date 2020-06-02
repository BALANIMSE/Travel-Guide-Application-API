package com.travel.book.app.common.interfaces;

import java.util.Collection;
import java.util.Date;

import com.travel.book.app.common.dto.Booking;
import com.travel.book.app.common.dto.BookingListResponse;
import com.travel.book.app.common.dto.BookingResponse;

/**
 * This is a Booking Service Interface
 * 
 * Please see the {@link com.travel.book.app.common.interfaces.IBookingService}
 * 
 * @author Bala Nimse
 * 
 */
public interface IBookingService {

	public BookingResponse create(Booking request);

	public BookingResponse cancel(Integer bookingId);

	public BookingListResponse read(Integer bookingId);

	public BookingListResponse list();

	public BookingListResponse list(Date bookingDate, Integer productId, Collection<String> status);

}
