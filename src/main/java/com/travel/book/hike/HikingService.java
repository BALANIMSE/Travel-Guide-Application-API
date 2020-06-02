package com.travel.book.hike;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.book.app.common.BookingAssembler;
import com.travel.book.app.common.BookingRespository;
import com.travel.book.app.common.BusinessPolicyFactory;
import com.travel.book.app.common.dto.Booking;
import com.travel.book.app.common.dto.BookingListResponse;
import com.travel.book.app.common.dto.BookingResponse;
import com.travel.book.app.common.dto.Request;
import com.travel.book.app.common.interfaces.ApplicationConstants;
import com.travel.book.app.common.interfaces.IBookingService;
import com.travel.book.app.common.interfaces.IBusinessPolicy;
import com.travel.book.app.exception.NotFoundException;
import com.travel.book.entities.BookingEntity;

/**
 * This is Business Service for processing Hiking requests
 * 
 * Please see the {@link com.travel.book.hike.HikingService}
 * 
 * @author Bala Nimse
 * 
 */

@Service(value = "hiking")
public class HikingService implements IBookingService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BookingAssembler assembler = null;

	@Autowired
	private BookingRespository bookingRepo = null;

	@Autowired
	private BusinessPolicyFactory businessPolicyFactory = null;

	@Override
	public BookingResponse create(Booking request) {

		BookingResponse response = new BookingResponse();
		BookingEntity entity = null;
		logger.trace("create");
		IBusinessPolicy policy = businessPolicyFactory.getBusinessPolicy(ApplicationConstants.BOOKING_CREATE_UPDATE);

		policy.validate(request);
		entity = assembler.toBookingEntity(request);
		bookingRepo.save(entity);
		response.setBookingId(entity.getBookingId());

		return response;
	}

	@Override
	public BookingResponse cancel(Integer bookingId) {

		BookingResponse response = new BookingResponse();
		String userId = Request.getLoggedInuser();
		logger.trace("cancel");
		Optional<BookingEntity> booking = bookingRepo.findByBookingUserIdAndBookingId(userId, bookingId);

		booking.orElseThrow(() -> new NotFoundException("Booking Not found"));
		booking.get().setStatus(ApplicationConstants.CANCELLED_STATUS);
		bookingRepo.save(booking.get());
		response.setBookingId(bookingId);

		return response;
	}

	@Override
	public BookingListResponse read(Integer bookingId) {

		BookingListResponse response = new BookingListResponse();
		String userId = Request.getLoggedInuser();
		logger.trace("read");
		Optional<BookingEntity> entity = bookingRepo.findByBookingUserIdAndBookingId(userId, bookingId);

		response.bookings.add(assembler.fromBookingEntity(entity));
		return response;
	}

	@Override
	public BookingListResponse list() {

		BookingListResponse response = new BookingListResponse();
		String userId = Request.getLoggedInuser();

		logger.trace("list()");

		List<BookingEntity> bookingEntity = bookingRepo.findByBookingUserIdOrderByBookingDateDesc(userId);

		bookingEntity.forEach(booking -> response.getBookings().add(assembler.fromBookingEntity(Optional.of(booking))));

		return response;

	}

	@Override
	public BookingListResponse list(Date bookingDate, Integer productId, Collection<String> status) {

		BookingListResponse response = new BookingListResponse();

		logger.trace("list(Date bookingDate, Integer productId, Collection<String> status)");
		List<BookingEntity> bookingEntity = null;

		if (productId == null) {
			bookingEntity = bookingRepo.findByBookingDateAndStatusInOrderByProductIdDesc(bookingDate, status);
		} else {
			bookingEntity = bookingRepo.findByBookingDateAndProductIdAndStatusInOrderByProductIdDesc(bookingDate,
					productId, status);
		}

		if (bookingEntity != null && bookingEntity.size() == 0)
			throw new NotFoundException("No Bookings Available");
		bookingEntity.forEach(booking -> response.getBookings().add(assembler.fromBookingEntity(Optional.of(booking))));

		return response;
	}

}
