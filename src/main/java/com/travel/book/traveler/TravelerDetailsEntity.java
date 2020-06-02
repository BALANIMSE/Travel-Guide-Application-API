package com.travel.book.traveler;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is a Travel Details Entity Class
 * 
 * Please see the {@link com.travel.book.traveler.TravelerDetailsEntity}
 * 
 * @author Bala Nimse
 * 
 */

@Entity
@Table(name = "TBL_TRAVELER_DETAILS")
public class TravelerDetailsEntity {

	@Id
	@Column(name = "travelerid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long travelerId;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private short age;

	@Column(name = "nationality")
	private String nationality;

	@Column(name = "gender")
	private String gender;

	@Column(name = "bookingid")
	private Integer bookingId;

	public Long getTravelerId() {
		return travelerId;
	}

	public void setTravelerId(Long travelerId) {
		this.travelerId = travelerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

}
