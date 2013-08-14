/**
 * @Copyright 2013
 * All rights reserved
 */
package com.winnergenic.ausregistry.domain;

import java.math.BigDecimal;

/**
 * PremiumDomain.java
 * Started - Aug 14, 2013
 */
public class PremiumDomain extends Domain {
	// fully qualified domain name including suffix
	private String name;

	public PremiumDomain(String name, BigDecimal price) {
		this.name = name;
		String domainSuffix = DomainUtil.getDomainSuffix(name);
		this.setSuffix(domainSuffix);
		this.setPrice(price);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof PremiumDomain))
			return false;
		PremiumDomain other = (PremiumDomain) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
