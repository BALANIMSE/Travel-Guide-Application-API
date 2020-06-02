package com.travel.book.app.common.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.travel.book.traveler.TravelerDetails;

/**
 * This is a Booking Data Transfer Object
 * 
 * Please see the {@link com.travel.book.app.common.dto.Booking}
 * 
 * @author Bala Nimse
 * 
 */
@Component
public class Booking extends Request {

	private Set<TravelerDetails> travelerDetails;

	private Integer bookingId;

	private Integer productId;

	private BigDecimal totalBookingAmount;

	private String currency;

	@NotBlank(message = "Booking User Name is Mandatory")
	@NotNull(message = "Booking User Name is Mandatory")
	private String bookingUserName;

	@FutureOrPresent(message = "Booking date should be present date or future date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date bookingDate;

	@NotBlank(message = "Contact Number is Mandatory")
	@NotNull(message = "Contact Number is Mandatory")
	private String contactNo;

	private String alternateContactNo;

	@NotNull(message = "Email Address is Mandatory")
	@NotBlank(message = "Email Address is Mandatory")
	@Email(message = "Email Address is not a valid format")
	private String emailId;

	private String status;

	public Set<TravelerDetails> getTravelerDetails() {
		return travelerDetails;
	}

	public void setTravelerDetails(Set<TravelerDetails> travelerDetails) {
		this.travelerDetails = travelerDetails;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public BigDecimal getTotalBookingAmount() {
		return totalBookingAmount;
	}

	public void setTotalBookingAmount(BigDecimal totalBookingAmount) {
		this.totalBookingAmount = totalBookingAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getBookingUserName() {
		return bookingUserName;
	}

	public void setBookingUserName(String bookingUserName) {
		this.bookingUserName = bookingUserName;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAlternateContactNo() {
		return alternateContactNo;
	}

	public void setAlternateContactNo(String alternateContactNo) {
		this.alternateContactNo = alternateContactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}