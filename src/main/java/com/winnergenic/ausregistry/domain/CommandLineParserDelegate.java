/**
 * @Copyright 2013
 * All rights reserved
 */
package com.winnergenic.ausregistry.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * CommandLineParserDelegate.java
 * Started - Aug 14, 2013
 */
public class CommandLineParserDelegate {

	private BufferedReader reader;
	private static final Logger log = Logger.getLogger(CommandLineParserDelegate.class);
	
	/**
	 * Constructs a parser from a reader, thus abstracting the source
	 * whether it be from standard input stream or from file input stream
	 * @param reader source of commands
	 */
	public CommandLineParserDelegate(BufferedReader reader) {
		this.reader = reader;
	}
	
	/**
	 * This parses all the domains from the reader to generate the 
	 * Map of domains
	 * @return
	 * @throws IOException only if we use a sensitive parser and if a problem occurs on parsing the commands
	 */
	public Map<String, Domain> parseDomains() throws IOException {
		Map<String, Domain> domainMap = new HashMap<String, Domain>();
		
		String line = "";
		int lineNumber = 1;
		while((line=reader.readLine()) != null) {
			log.debug(lineNumber + " " + line); // showing parsed line
			
			if (StringUtils.isEmpty(line)) {
				break; // empty lines will be treated as EOL 
			}
			
			String lineTrimmedLower = line.trim().toLowerCase();
			
			StringTokenizer strTok = new StringTokenizer(lineTrimmedLower, ","); // tokenizing on comma
			String domain = strTok.nextToken().trim(); // domain token
			String numbInput = strTok.nextToken().trim(); // price
			
			Domain aDomain = new Domain(domain, new BigDecimal(numbInput));
			domainMap.put(domain, aDomain);

			lineNumber++;
		}
		
		return domainMap;
	}
	
	/**
	 * This parses all the domains from the reader to generate the 
	 * Premium Domains
	 * @return
	 * @throws IOException only if we use a sensitive parser and if a problem occurs on parsing the commands
	 */
	public Map<String, PremiumDomain> parsePremiumDomains() throws IOException {
		Map<String, PremiumDomain> domainMap = new HashMap<String, PremiumDomain>();
		
		String line = "";
		int lineNumber = 1;
		while((line=reader.readLine()) != null) {
			log.debug(lineNumber + " " + line); // showing parsed line
			
			if (StringUtils.isEmpty(line)) {
				break; // empty lines will be treated as EOL 
			}
			
			String lineTrimmedLower = line.trim().toLowerCase();
			
			StringTokenizer strTok = new StringTokenizer(lineTrimmedLower, ","); // tokenizing on comma
			String name = strTok.nextToken().trim(); // domain token
			String numbInput = strTok.nextToken().trim(); // price
			
			PremiumDomain aDomain = new PremiumDomain(name, new BigDecimal(numbInput));
			domainMap.put(name,  aDomain);

			lineNumber++;
		}
		
		return domainMap;
	}
	
	
	/**
	 * This parses all the domains from the reader to generate the 
	 * domain requests
	 * @return set of domain requests
	 * @throws IOException only if we use a sensitive parser and if a problem occurs on parsing the commands
	 */
	public Set<DomainRequest> parseRequests() throws IOException {
		Set<DomainRequest> domainSet = new HashSet<DomainRequest>();
		
		String line = "";
		int lineNumber = 1;
		while((line=reader.readLine()) != null) {
			log.debug(lineNumber + " " + line); // showing parsed line
			
			if (StringUtils.isEmpty(line)) {
				break; // empty lines will be treated as EOL 
			}
			
			String lineTrimmedLower = line.trim().toLowerCase();
			
			StringTokenizer strTok = new StringTokenizer(lineTrimmedLower, ","); // tokenizing on comma
			String name = strTok.nextToken().trim(); // domain token
			String numbInput = strTok.nextToken().trim(); // price
			
			DomainRequest requestedDomain = new DomainRequest();
			requestedDomain.setRequestedDomain(name);
			
			int yearsReq = Integer.valueOf(numbInput);
			requestedDomain.setYearsRequested(yearsReq);
			domainSet.add(requestedDomain);
			lineNumber++;
		}
		
		return domainSet;
	}
}
