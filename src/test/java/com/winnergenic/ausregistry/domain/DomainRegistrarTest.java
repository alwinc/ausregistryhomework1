/**
 * @Copyright 2013
 * All rights reserved
 */
package com.winnergenic.ausregistry.domain;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/**
 * DomainRegistrarTest.java
 * @created 14/08/2013
 *
 */
public class DomainRegistrarTest {

	private DomainRegistrar dr;
	private Map<String, Domain> zoneDomains;
	private Map<String, PremiumDomain> premiumDomains;
	private Set<DomainRequest> domainRequests;
	
	/**
	 * Initial setup with standard zones and premiums
	 */
	@Before
	public void setup() {
		dr = new DomainRegistrar();

		zoneDomains = new HashMap<String, Domain>();
		zoneDomains.put(".com", new Domain(".com",BigDecimal.valueOf(10)));
		zoneDomains.put(".net", new Domain(".net",BigDecimal.valueOf(9)));
		zoneDomains.put(".com.au", new Domain(".com.au",BigDecimal.valueOf(20)));
		
		premiumDomains = new HashMap<String, PremiumDomain>();
		premiumDomains.put("apple.com.au", new PremiumDomain("apple.com.au", BigDecimal.valueOf(1000)));
		premiumDomains.put("dict.com", new PremiumDomain("dict.com", BigDecimal.valueOf(800)));
		premiumDomains.put("education.net", new PremiumDomain("education.net", BigDecimal.valueOf(300)));
	}
	
	/**
	 * Basic test as per example given
	 */
	@Test
	public void basicTest() {
		dr.setPremiumDomains(premiumDomains);
		dr.setZoneList(zoneDomains);
		
		domainRequests = new HashSet<DomainRequest>();
		
		DomainRequest request1 = new DomainRequest();
		request1.setRequestedDomain("a-domain.com");
		request1.setYearsRequested(1);
		domainRequests.add(request1);
		
		DomainRequest request2 = new DomainRequest();
		request2.setRequestedDomain("another-domain.net");
		request2.setYearsRequested(2);
		domainRequests.add(request2);
		
		DomainRequest request3 = new DomainRequest();
		request3.setRequestedDomain("dict.com");
		request3.setYearsRequested(5);
		domainRequests.add(request3);
		
		dr.setDomainRequests(domainRequests);
		BigDecimal costs = dr.calculateCosts();
		
		assertEquals(BigDecimal.valueOf(4028), costs);
	}
	
	/**
	 * Big calculation to assert BigDecimal values
	 */
	@Test
	public void bigCalculationTest() {
		dr.setPremiumDomains(premiumDomains);
		dr.setZoneList(zoneDomains);
		
		domainRequests = new HashSet<DomainRequest>();
		
		DomainRequest request1 = new DomainRequest();
		request1.setRequestedDomain("a-domain.com");
		request1.setYearsRequested(20);
		domainRequests.add(request1);
		
		DomainRequest request2 = new DomainRequest();
		request2.setRequestedDomain("another-domain.net");
		request2.setYearsRequested(2);
		domainRequests.add(request2);
		
		DomainRequest request3 = new DomainRequest();
		request3.setRequestedDomain("dict.com");
		request3.setYearsRequested(50);
		domainRequests.add(request3);
		
		DomainRequest request4 = new DomainRequest();
		request4.setRequestedDomain("apple.com.au");
		request4.setYearsRequested(9999);
		domainRequests.add(request4);
		
		dr.setDomainRequests(domainRequests);
		BigDecimal costs = dr.calculateCosts();
		
		assertEquals(BigDecimal.valueOf(10039218), costs);
	}
	
	
	/**
	 * This test is to ensure we skip domains not existing in database
	 */
	@Test
	public void skipNonFacilitatedDomainsTest() {
		dr.setPremiumDomains(premiumDomains);
		dr.setZoneList(zoneDomains);
		
		domainRequests = new HashSet<DomainRequest>();
		
		DomainRequest request1 = new DomainRequest();
		request1.setRequestedDomain("a-domain.it");
		request1.setYearsRequested(99999999);
		domainRequests.add(request1);
		dr.setDomainRequests(domainRequests);
		BigDecimal costs = dr.calculateCosts();
		
		assertEquals(BigDecimal.ZERO, costs);
	}
}
