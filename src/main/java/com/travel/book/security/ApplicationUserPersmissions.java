package com.travel.book.security;

/**
 * This is a Application User Permission/Authorities class
 * 
 * Please see the {@link com.travel.book.security.ApplicationUserPersmissions}
 * 
 * @author Bala Nimse
 * 
 */
public enum ApplicationUserPersmissions {

	CUSTOMER_WRITE("hiking:write"), CUSTOMER_READ("hiking:read"), GUIDE_READ("booking:read");

	private String permission;

	ApplicationUserPersmissions(String permission) {
		this.permission = permission;

	}

	public String getPermissions() {
		return permission;
	}

}
