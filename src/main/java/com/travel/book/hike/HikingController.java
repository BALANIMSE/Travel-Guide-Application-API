package com.travel.book.hike;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.book.app.common.BaseController;
import com.travel.book.app.common.dto.Booking;
import com.travel.book.app.common.dto.BookingListResponse;
import com.travel.book.app.common.dto.BookingResponse;
import com.travel.book.app.common.interfaces.ApplicationConstants;
import com.travel.book.app.common.interfaces.IBookingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * This is Restful webservice controller
 * 
 * Please see the {@link com.travel.book.hike.HikingController}
 * 
 * @author Bala Nimse
 * 
 */

@RequestMapping("/bookings")
@RestController
@Api(tags = "Travel Guide Bookings", description = "Travel Guide Service Booking operations")
public class HikingController extends BaseController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	@Qualifier("hiking")
	private IBookingService hikingService = null;

	@PostMapping(value = "/hiking")
	@ApiOperation(value = "Create New Booking", response = Booking.class)
	@PreAuthorize("hasAuthority('hiking:write')")
	public BookingResponse create(@ApiParam(value = "Booking") @Valid @RequestBody Booking booking) {

		BookingResponse response = null;
		try {

			response = hikingService.create(booking);
			buildSuccessResponse(response);
		} catch (Exception ex) {

			logger.error("create :" + ex.getLocalizedMessage());
			throw ex;

		}

		return response;
	}

	@DeleteMapping(value = "/hiking/{hikeId}")
	@ApiOperation(value = "Cancel Existing Booking", response = Booking.class)
	@PreAuthorize("hasAuthority('hiking:write')")
	public BookingResponse cancel(
			@ApiParam(value = "Booking Id") @PathVariable(required = true, value = "hikeId") Integer hikeId) {

		BookingResponse response = null;
		try {
			response = hikingService.cancel(hikeId);
			buildSuccessResponse(response);
		} catch (Exception ex) {
			logger.error("cancel:" + ex.getLocalizedMessage());
			throw ex;
		}

		return response;
	}

	@GetMapping(value = "/hiking/{hikeId}")
	@ApiOperation(value = "Get Existing Booking basis on {bookingId}", response = BookingListResponse.class)
	@PreAuthorize("hasAuthority('hiking:read')")
	public BookingListResponse read(
			@ApiParam(value = "Booking Id") @PathVariable(required = true, value = "hikeId") Integer hikeId) {

		BookingListResponse response = null;

		try {
			response = hikingService.read(hikeId);
			buildSuccessResponse(response);

		} catch (Exception ex) {
			logger.error("read:" + ex.getLocalizedMessage());
			throw ex;
		}

		return response;
	}

	@GetMapping(value = "/hiking")
	@ApiOperation(value = "List Bookings of logged in user", response = BookingListResponse.class)
	@PreAuthorize("hasAuthority('hiking:read')")
	public BookingListResponse listBookings() {

		BookingListResponse response = null;
		try {
			response = hikingService.list();
			buildSuccessResponse(response);
		} catch (Exception ex) {
			logger.error("listBookings:" + ex.getLocalizedMessage());
			throw ex;
		}

		return response;

	}

	@GetMapping()
	@ApiOperation(value = "Get List of Bookings by Guide basis on Booking Date and Travel Service product", response = BookingListResponse.class)
	@PreAuthorize("hasAuthority('booking:read')")
	public BookingListResponse list(
			@ApiParam(value = "Booking Date") @RequestParam(required = true, value = "bookingDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date bookingDate,
			@ApiParam(value = "Product Id") @RequestParam(required = false, value = "productId") Integer productId) {

		BookingListResponse response = null;
		try {
			List<String> status = new ArrayList<String>();
			status.add(ApplicationConstants.ACTIVE_STATUS);

			response = hikingService.list(bookingDate, productId, status);
			buildSuccessResponse(response);

		} catch (Exception ex) {
			logger.error("list:" + ex.getLocalizedMessage());
			throw ex;
		}

		return response;

	}

}