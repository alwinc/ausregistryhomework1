/**
 * @Copyright 2013
 * All rights reserved
 */
package com.winnergenic.ausregistry.domain;

/**
 * DomainUtil.java
 * Started - Aug 14, 2013
 */
public class DomainUtil {

	/**
	 * Function to find the domain suffix zone
	 * @return the suffix zone
	 */
	public static final String getDomainSuffix(String domainName) {
		int dotPos = domainName.indexOf(".");
		String suffix = "";
		
		if (dotPos > -1) {
			suffix = domainName.substring(dotPos);
		}
		
		return suffix;
	}
}
