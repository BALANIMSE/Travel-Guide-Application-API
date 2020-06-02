package com.travel.book.app.common.dto;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * This is Request DTO used for inheritance purpose and to fetch the
 * loggedInUser Subject
 * 
 * Please see the {@link com.travel.book.app.common.dto.Request}
 * 
 * @author Bala Nimse
 * 
 */

@Component
public class Request {

	public static String getLoggedInuser() {
		String currentUserName = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			currentUserName = authentication.getName();

		}

		return currentUserName;
	}

}
