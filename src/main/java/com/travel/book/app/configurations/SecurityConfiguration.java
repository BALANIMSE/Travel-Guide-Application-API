package com.travel.book.app.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.travel.book.security.ApplicationUserRoles;

/**
 * This is a Security Configuration class. Takes care of authentication and
 * authorization based on roles and permissions.
 * 
 * Please see the
 * {@link com.travel.book.app.configurations.SecurityConfiguration}
 * 
 * @author Bala Nimse
 * 
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		logger.trace("configure(AuthenticationManagerBuilder auth)");

		auth.inMemoryAuthentication().withUser("USER1").password(passwordEncoder().encode("password"))
				.authorities(ApplicationUserRoles.CUSTOMER.getGrantedAuthorities()).and().withUser("USER2")
				.password(passwordEncoder().encode("password"))
				.authorities(ApplicationUserRoles.CUSTOMER.getGrantedAuthorities()).and().withUser("TRAVELGUIDE1")
				.password(passwordEncoder().encode("password"))
				.authorities(ApplicationUserRoles.GUIDE.getGrantedAuthorities());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		logger.trace("configure(HttpSecurity http)");
		http.csrf().disable().authorizeRequests()
				.antMatchers("/h2-console/**", "/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html",
						"/webjars/springfox-swagger-ui/**")
				.permitAll().antMatchers("/bookings/hiking/**").hasRole(ApplicationUserRoles.CUSTOMER.name())
				.antMatchers("/booking").hasRole(ApplicationUserRoles.GUIDE.name()).antMatchers("/h2-console/**")
				.hasRole(ApplicationUserRoles.GUIDE.name()).anyRequest().authenticated().and().httpBasic();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		logger.trace("passwordEncoder");
		return new BCryptPasswordEncoder(10);
	}
}
