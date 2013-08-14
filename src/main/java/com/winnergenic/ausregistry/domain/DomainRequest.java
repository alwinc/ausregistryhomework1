/**
 * @Copyright 2013
 * All rights reserved
 */
package com.winnergenic.ausregistry.domain;


/**
 * Class to hold a single domain request
 * This contains the fully qualified domain being requested
 * and the number of years requested for
 * DomainRequest.java
 * Started - Aug 14, 2013
 */
public class DomainRequest {

	private String requestedDomain;
	private int yearsRequested;
	/**
	 * @return the requestedDomain
	 */
	public String getRequestedDomain() {
		return requestedDomain;
	}
	/**
	 * @param requestedDomain the requestedDomain to set
	 */
	public void setRequestedDomain(String requestedDomain) {
		this.requestedDomain = requestedDomain;
	}
	/**
	 * @return the yearsRequested
	 */
	public int getYearsRequested() {
		return yearsRequested;
	}
	/**
	 * @param yearsRequested the yearsRequested to set
	 */
	public void setYearsRequested(int yearsRequested) {
		this.yearsRequested = yearsRequested;
	}
}
