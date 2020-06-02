package com.travel.book.app.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travel.book.app.common.interfaces.ApplicationConstants;
import com.travel.book.app.common.interfaces.IBusinessPolicy;
import com.travel.book.hike.policy.HikingBusinessPolicy;

/**
 * This is a Business Policy factory, responsible for instantiating business
 * policies basis on properties
 * 
 * Please see the {@link com.travel.book.app.common.BusinessPolicyFactory}
 * 
 * @author Bala Nimse
 * 
 */
@Component
public class BusinessPolicyFactory {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private HikingBusinessPolicy hikingBusinessPolicy = null;

	public IBusinessPolicy getBusinessPolicy(String policyId) {
		IBusinessPolicy policy = null;

		logger.info("getBusinessPolicy");

		switch (policyId) {
		case ApplicationConstants.BOOKING_CREATE_UPDATE:
			policy = hikingBusinessPolicy;
			break;
		}

		return policy;
	}

}
