package com.travel.book.app.common;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.travel.book.app.common.dto.Booking;
import com.travel.book.app.common.dto.Gender;
import com.travel.book.app.common.interfaces.ApplicationConstants;
import com.travel.book.app.exception.NotFoundException;
import com.travel.book.entities.BookingEntity;
import com.travel.book.traveler.TravelerDetails;
import com.travel.book.traveler.TravelerDetailsEntity;

/**
 * This is Booking Assembler responsible for transforming Entities to Data
 * Transfer Object (DTO) and vice a versa.
 * 
 * Please see the {@link com.travel.book.app.common.BookingAssembler}
 * 
 * @author Bala Nimse
 * 
 */
@Component
public class BookingAssembler {

	public BookingEntity toBookingEntity(Booking booking) {

		BookingEntity bookingEntity = new BookingEntity();

		bookingEntity.setBookingId(booking.getBookingId());
		bookingEntity.setProductId(booking.getProductId());
		bookingEntity.setStatus(ApplicationConstants.ACTIVE_STATUS);
		bookingEntity.setBookingDate(booking.getBookingDate());
		bookingEntity.setContactNo(booking.getContactNo());
		bookingEntity.setAlternateNo(booking.getAlternateContactNo());
		bookingEntity.setEmailId(booking.getEmailId());
		bookingEntity.setBookingUserName(booking.getBookingUserName());
		bookingEntity.setTotalBookingAmount(booking.getTotalBookingAmount());
		bookingEntity.setCurrency(booking.getCurrency());
		bookingEntity.setBookingUserId(booking.getLoggedInuser());
		bookingEntity.setTravelerDetails(toTravelerDetailsEntity(booking.getTravelerDetails()));
		return bookingEntity;
	}

	public Booking fromBookingEntity(Optional<BookingEntity> bookingEntity) {

		Booking booking = new Booking();

		bookingEntity.orElseThrow(() -> new NotFoundException("Booking Not found"));

		bookingEntity.ifPresent(entity -> {

			booking.setBookingId(entity.getBookingId());
			booking.setContactNo(entity.getContactNo());
			booking.setAlternateContactNo(entity.getAlternateNo());
			booking.setBookingDate(entity.getBookingDate());
			booking.setEmailId(entity.getEmailId());
			booking.setProductId(entity.getProductId());
			booking.setTotalBookingAmount(entity.getTotalBookingAmount());
			booking.setCurrency(entity.getCurrency());
			booking.setBookingUserName(entity.getBookingUserName());
			booking.setStatus(entity.getStatus());
			booking.setTravelerDetails(fromTravelerDetailsEntity(entity.getTravelerDetails()));

		});

		return booking;
	}

	public Set<TravelerDetailsEntity> toTravelerDetailsEntity(Set<TravelerDetails> travelerDetails) {
		Set<TravelerDetailsEntity> travelerDetailsEntity = new HashSet<TravelerDetailsEntity>();
		travelerDetails.forEach(traveler -> {
			TravelerDetailsEntity entity = new TravelerDetailsEntity();
			entity.setAge(traveler.getAge());
			entity.setName(traveler.getName());
			entity.setNationality(traveler.getNationality());
			entity.setGender(traveler.getGender().name());
			travelerDetailsEntity.add(entity);

		});
		return travelerDetailsEntity;
	}

	public Set<TravelerDetails> fromTravelerDetailsEntity(Set<TravelerDetailsEntity> travelerEntity) {
		Set<TravelerDetails> travelerDetails = new HashSet<TravelerDetails>();
		travelerEntity.forEach(entity -> {
			TravelerDetails traveler = new TravelerDetails();
			traveler.setTraverlId(entity.getTravelerId());
			traveler.setAge(entity.getAge());
			traveler.setName(entity.getName());
			traveler.setNationality(entity.getNationality());
			traveler.setGender(Gender.fromValue(entity.getGender()));
			travelerDetails.add(traveler);
		});
		return travelerDetails;
	}
}
