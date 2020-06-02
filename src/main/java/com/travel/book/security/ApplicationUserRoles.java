package com.travel.book.security;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;

/**
 * This is a Application User Roles class
 * 
 * Please see the {@link com.travel.book.security.ApplicationUserRoles}
 * 
 * @author Bala Nimse
 * 
 */

public enum ApplicationUserRoles {

	CUSTOMER(Sets.newHashSet(ApplicationUserPersmissions.CUSTOMER_WRITE, ApplicationUserPersmissions.CUSTOMER_READ)),
	GUIDE(Sets.newHashSet(ApplicationUserPersmissions.GUIDE_READ));

	private Set<ApplicationUserPersmissions> permissions;

	ApplicationUserRoles(Set<ApplicationUserPersmissions> permissions) {
		this.permissions = permissions;

	}

	public Set<ApplicationUserPersmissions> getPermissions() {
		return permissions;
	}

	public List<SimpleGrantedAuthority> getGrantedAuthorities() {
		List<SimpleGrantedAuthority> permissions = getPermissions().stream()
				.map(permission -> new SimpleGrantedAuthority(permission.getPermissions()))
				.collect(Collectors.toList());
		permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
		return permissions;
	}

}
