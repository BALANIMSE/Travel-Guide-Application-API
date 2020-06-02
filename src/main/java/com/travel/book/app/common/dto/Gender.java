package com.travel.book.app.common.dto;

/**
 * This is Gender Enum
 * 
 * Please see the {@link com.travel.book.app.common.dto.Gender}
 * 
 * @author Bala Nimse
 * 
 */

public enum Gender {

	MALE("Male"), FEMALE("Female"), OTHER("Other");
	private String value = null;

	private Gender(String value) {
		this.value = value;
	}

	public static Gender fromValue(String value) {
		for (Gender element : Gender.values()) {
			if (element.toString().equals(value)) {
				return element;
			}
		}
		return null;
	}

}
