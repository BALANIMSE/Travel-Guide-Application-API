package com.travel.book.hike.policy;

import java.math.BigDecimal;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travel.book.app.common.dto.Booking;
import com.travel.book.app.common.dto.Request;
import com.travel.book.app.common.interfaces.IBusinessPolicy;
import com.travel.book.app.exception.BusinessPolicyException;
import com.travel.book.app.exception.NotFoundException;
import com.travel.book.product.ProductEntity;
import com.travel.book.product.ProductRepository;

/**
 * This is a Hiking Service Business Policy
 * 
 * Please see the {@link com.travel.book.hike.policy.HikingBusinessPolicy}
 * 
 * @author Bala Nimse
 * 
 */
@Component
public class HikingBusinessPolicy implements IBusinessPolicy {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductRepository productRepo = null;

	private Booking booking = null;

	@Override
	public boolean validate(Request request) {

		logger.trace("validate");

		if (request instanceof Booking) {

			booking = (Booking) request;
			validateBooking(booking);

		}

		return true;
	}

	private void validateBooking(Booking booking) {

		final Optional<ProductEntity> product;

		logger.trace("validateBooking");

		if (booking.getTravelerDetails() == null || booking.getTravelerDetails().size() == 0) {
			throw new BusinessPolicyException("Atleast one traveler is required for this booking");
		}

		product = productRepo.findById(booking.getProductId());

		if (product.isPresent()) {

			booking.getTravelerDetails().forEach(traveler -> {
				if (traveler.getAge() < product.get().getFromAge() || traveler.getAge() > product.get().getToAge()) {
					throw new BusinessPolicyException(
							"Traveler " + traveler.getName() + " age not valid for this booking.");
				}
			});

			// To reduce the number calls to DB, setting the product currency and
			// calculating the total booking cost
			booking.setCurrency(product.get().getCurrency());
			booking.setTotalBookingAmount(
					product.get().getRatePerPerson().multiply(new BigDecimal(booking.getTravelerDetails().size())));

		} else {
			throw new NotFoundException("Product not found");
		}

	}

}
