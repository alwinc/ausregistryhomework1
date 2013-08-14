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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((requestedDomain == null) ? 0 : requestedDomain.hashCode());
		result = prime * result + yearsRequested;
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
		if (!(obj instanceof DomainRequest))
			return false;
		DomainRequest other = (DomainRequest) obj;
		if (requestedDomain == null) {
			if (other.requestedDomain != null)
				return false;
		} else if (!requestedDomain.equals(other.requestedDomain))
			return false;
		if (yearsRequested != other.yearsRequested)
			return false;
		return true;
	}
	
	
}
