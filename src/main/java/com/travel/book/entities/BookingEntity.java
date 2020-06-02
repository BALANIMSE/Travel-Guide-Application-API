package com.travel.book.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.travel.book.traveler.TravelerDetailsEntity;

/**
 * This is a Booking Entity class
 * 
 * Please see the {@link com.travel.book.entities.BookingEntity}
 * 
 * @author Bala Nimse
 * 
 */
@Entity
@Table(name = "TBL_BOOKING")
public class BookingEntity {

	@Id
	@Column(name = "bookingid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingId;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookingid", referencedColumnName = "bookingid")
	private Set<TravelerDetailsEntity> travelerDetails;

	@Column(name = "productid")
	private Integer productId;

	@Column(name = "totalbookingamount")
	private BigDecimal totalBookingAmount;

	@Column(name = "currency")
	private String currency;

	@Column(name = "bookingusername")
	private String bookingUserName;

	@Column(name = "bookinguserid")
	private String bookingUserId;

	@Column(name = "bookingdate")
	private Date bookingDate;

	@Column(name = "contactno")
	private String contactNo;

	@Column(name = "alternateno")
	private String alternateNo;

	@Column(name = "emailid")
	private String emailId;

	@Column(name = "status")
	private String status;

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Set<TravelerDetailsEntity> getTravelerDetails() {
		return travelerDetails;
	}

	public void setTravelerDetails(Set<TravelerDetailsEntity> travelerDetails) {
		this.travelerDetails = travelerDetails;
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

	public String getBookingUserId() {
		return bookingUserId;
	}

	public void setBookingUserId(String bookingUserId) {
		this.bookingUserId = bookingUserId;
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

	public String getAlternateNo() {
		return alternateNo;
	}

	public void setAlternateNo(String alternateNo) {
		this.alternateNo = alternateNo;
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
