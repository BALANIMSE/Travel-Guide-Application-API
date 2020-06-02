package com.travel.book.traveler;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

import com.travel.book.app.common.dto.Gender;

/**
 * This is a Travel Details Data Transfer Object
 * 
 * Please see the {@link com.travel.book.traveler.TravelerDetails}
 * 
 * @author Bala Nimse
 * 
 */

@Component
public class TravelerDetails {

	private Long traverlId;

	@NotNull(message = "Name is Mandatory")
	@NotBlank(message = "Name is Mandatory")
	@Pattern(regexp = "[a-z-A-Z]*", message = "Name has invalid characters")
	@Min(value = 1, message = "Invalid Name")
	@Max(value = 50, message = "Invalid Name")
	private String name;

	@Min(value = 0, message = "Age must be greater than or equal to 0")
	@Max(value = 150, message = "Age must be less than or equal to 150")
	private short age;

	@NotNull(message = "Nationality is Mandatory")
	@NotBlank(message = "Nationality is Mandatory")
	private String nationality;

	@NotBlank(message = "Gender is Mandatory")
	@NotNull(message = "Gender is Mandatory")
	private Gender gender;

	public Long getTraverlId() {
		return traverlId;
	}

	public void setTraverlId(Long traverlId) {
		this.traverlId = traverlId;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}