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
	
	/**
	 * Super empty constructor
	 */
	public Domain() {
	}
	
	/**
	 * Normal way of creating a Domain
	 * @param suffix
	 * @param price
	 */
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((suffix == null) ? 0 : suffix.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Domain))
			return false;
		Domain other = (Domain) obj;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (suffix == null) {
			if (other.suffix != null)
				return false;
		} else if (!suffix.equals(other.suffix))
			return false;
		return true;
	}
	
	
}
