/**
 * @Copyright 2013
 * All rights reserved
 */
package com.winnergenic.ausregistry.domain;

import java.math.BigDecimal;

/**
 * Domain.java
 * Started - Aug 14, 2013
 */
public class Domain {
	private String suffix;
	private BigDecimal price;
	
	public Domain() {
	}
	
	public Domain(String suffix, BigDecimal price) {
		this.suffix = suffix;
		this.price = price;
	}
	
	/**
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}
	/**
	 * @param suffix the suffix to set
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
