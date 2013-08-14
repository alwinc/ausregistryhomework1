/**
 * @Copyright 2013
 * All rights reserved
 */
package com.winnergenic.ausregistry.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

/**
 * DomainRegistrar.java
 * Started - Aug 14, 2013
 */
public class DomainRegistrar {

	private Map<String, Domain> zoneList; // suffix to zone map
	private Map<String, PremiumDomain> premiumDomains; // fully qualified domain map
	private Set<DomainRequest> domainRequests;
	
	private static final Logger log = Logger.getLogger(DomainRegistrar.class);
	
	/**
	 * Main function for execution
	 */
	public static void main(String[] args){
		InputStreamReader isreader = null;
		BufferedReader reader = null;
		
		try {
			System.out.println("=======================================================");
			System.out.println("=\tAUSREGISTRY ASSIGNMENT 1");
			System.out.println("=======================================================");
			System.out.println("\n");
			System.out.println("Step 1. Zone Domains");
			System.out.println("Please enter all zone domains with their prices per year. If duplicates are found, the LAST entry will be considered");
			System.out.println("When complete just press ENTER");
			System.out.println("eg - .com,10");
			
			isreader = new InputStreamReader(System.in);
			reader = new BufferedReader(isreader);
		
			CommandLineParserDelegate parser = new CommandLineParserDelegate(reader);
			Map<String, Domain> zoneList = parser.parseDomains();
			
			System.out.println("Step 2. Premium Domains");
			System.out.println("Please enter all PREMIUM domains with their prices per year. If duplicates are found, the LAST entry will be considered");
			System.out.println("When complete just press ENTER");
			System.out.println("eg - apple.com.au,10");
			
			Map<String, PremiumDomain> premiumDomains = parser.parsePremiumDomains();
			
			System.out.println("Step 3. Domain Requests");
			System.out.println("Please enter all domain requests with the years you would like to have them for. If duplicates are found, the LAST entry will be considered");
			System.out.println("When complete just press ENTER");
			System.out.println("eg - dict.com,1");
			
			Set<DomainRequest> domainRequests = parser.parseRequests();
			
			DomainRegistrar registrar = new DomainRegistrar();
			registrar.setZoneList(zoneList);
			registrar.setPremiumDomains(premiumDomains);
			registrar.setDomainRequests(domainRequests);
			
			BigDecimal costs = registrar.calculateCosts();
			
			DecimalFormat moneyFormat = new DecimalFormat("$0.00");
			System.out.println(moneyFormat.format(costs));
		} catch (IOException e) {
			
		} finally {
			IOUtils.closeQuietly(reader);
		}
	}

	/**
	 * Calculates the total costs of the domains requested
	 */
	private BigDecimal calculateCosts() {
		BigDecimal total = BigDecimal.ZERO;
		for(DomainRequest dr : domainRequests) {
			// first check the premium list
			if(premiumDomains.containsKey(dr.getRequestedDomain())) {
				PremiumDomain pDomain = premiumDomains.get(dr.getRequestedDomain());
				total = addDomainRequestToTotal(total, dr, pDomain);
				continue;
			}
			
			// should be in the zone list
			String domainSuffix = DomainUtil.getDomainSuffix(dr.getRequestedDomain());
			if (zoneList.containsKey(domainSuffix)) {
				Domain aDomain = zoneList.get(domainSuffix);
				total = addDomainRequestToTotal(total, dr, aDomain);
				continue;
			} else { // zone not found - redirect to a competitor???
				log.info("This registrar cannot faciliate this domain - " + dr.getRequestedDomain());
			}
		}
		
		return total;
	}

	/**
	 * @param total running total
	 * @param dr requested domain
	 * @param aDomain domain that is found
	 * @return the running total
	 */
	private BigDecimal addDomainRequestToTotal(BigDecimal total,
			DomainRequest dr, Domain aDomain) {
		BigDecimal pricePerYear = aDomain.getPrice();
		BigDecimal domainSubtotal = pricePerYear.multiply(new BigDecimal(dr.getYearsRequested()));
		total = total.add(domainSubtotal);
		return total;
	}

	

	/**
	 * @return the zoneList
	 */
	public Map<String, Domain> getZoneList() {
		return zoneList;
	}

	/**
	 * @param zoneList the zoneList to set
	 */
	public void setZoneList(Map<String, Domain> zoneList) {
		this.zoneList = zoneList;
	}

	/**
	 * @return the premiumDomains
	 */
	public Map<String, PremiumDomain> getPremiumDomains() {
		return premiumDomains;
	}

	/**
	 * @param premiumDomains the premiumDomains to set
	 */
	public void setPremiumDomains(Map<String, PremiumDomain> premiumDomains) {
		this.premiumDomains = premiumDomains;
	}

	/**
	 * @return the domainRequests
	 */
	public Set<DomainRequest> getDomainRequests() {
		return domainRequests;
	}

	/**
	 * @param domainRequests the domainRequests to set
	 */
	public void setDomainRequests(Set<DomainRequest> domainRequests) {
		this.domainRequests = domainRequests;
	}
	
	
}
