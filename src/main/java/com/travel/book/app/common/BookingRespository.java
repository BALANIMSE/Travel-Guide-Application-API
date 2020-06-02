package com.travel.book.app.common;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.book.entities.BookingEntity;

/**
 * This is Travel Booking DAO layer.
 * 
 * Please see the {@link com.travel.book.app.common.BookingRespository}
 * 
 * @author Bala Nimse
 * 
 */

@Repository
public interface BookingRespository extends JpaRepository<BookingEntity, Integer> {

	public List<BookingEntity> findByBookingDateAndProductIdAndStatusInOrderByProductIdDesc(Date bookingDate,
			Integer productId, Collection<String> status);

	public List<BookingEntity> findByBookingDateAndStatusInOrderByProductIdDesc(Date bookingDate,
			Collection<String> status);

	public Optional<BookingEntity> findByBookingUserIdAndBookingId(String userId, Integer bookingId);

	public List<BookingEntity> findByBookingUserIdOrderByBookingDateDesc(String userId);

}