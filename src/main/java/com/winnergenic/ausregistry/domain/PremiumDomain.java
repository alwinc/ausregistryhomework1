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
	
}
