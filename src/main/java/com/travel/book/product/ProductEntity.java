package com.travel.book.product;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is a Travel Guide Products Entity
 * 
 * Please see the {@link com.travel.book.product.ProductEntity}
 * 
 * @author Bala Nimse
 * 
 */
@Entity
@Table(name = "TBL_PRODUCTS_MST")
public class ProductEntity {

	@Id
	@Column(name = "productid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;

	@Column(name = "productname")
	private String productName;

	@Column(name = "fromtime")
	private String fromTime;

	@Column(name = "totime")
	private String toTime;

	@Column(name = "fromage")
	private Integer fromAge;

	@Column(name = "toage")
	private Integer toAge;

	@Column(name = "rateperperson")
	private BigDecimal ratePerPerson;

	@Column(name = "currency")
	private String currency;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	public Integer getFromAge() {
		return fromAge;
	}

	public void setFromAge(Integer fromAge) {
		this.fromAge = fromAge;
	}

	public Integer getToAge() {
		return toAge;
	}

	public void setToAge(Integer toAge) {
		this.toAge = toAge;
	}

	public BigDecimal getRatePerPerson() {
		return ratePerPerson;
	}

	public void setRatePerPerson(BigDecimal ratePerPerson) {
		this.ratePerPerson = ratePerPerson;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
