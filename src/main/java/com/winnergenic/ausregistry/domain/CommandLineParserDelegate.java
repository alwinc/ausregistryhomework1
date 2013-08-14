/**
 * @Copyright 2013
 * All rights reserved
 */
package com.winnergenic.ausregistry.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
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
	 * command list to be returned
	 * @return
	 * @throws IOException only if we use a sensitive parser and if a problem occurs on parsing the commands
	 */
	public Set<Domain> parseDomains() throws IOException {
		Set<Domain> domainSet = new HashSet<Domain>();
		
		String line = "";
		int lineNumber = 1;
		while((line=reader.readLine()) != null) {
			log.debug(lineNumber + " " + line); // showing parsed line
			
			if (StringUtils.isEmpty(line)) {
				break; // empty lines will be treated as EOL 
			}
			
			String lineTrimmedLower = line.trim().toLowerCase();
			
			StringTokenizer strTok = new StringTokenizer(lineTrimmedLower, ","); // tokenizing on comma
			String domain = strTok.nextToken(); // domain token
			String numbInput = strTok.nextToken(); // price
			
			Domain aDomain = new Domain(domain, new BigDecimal(numbInput));
			domainSet.add(aDomain);

			lineNumber++;
		}
		
		return domainSet;
	}
	
	/**
	 * This parses all the domains from the reader to generate the 
	 * command list to be returned
	 * @return
	 * @throws IOException only if we use a sensitive parser and if a problem occurs on parsing the commands
	 */
	public Set<PremiumDomain> parsePremiumDomains() throws IOException {
		Set<PremiumDomain> domainSet = new HashSet<PremiumDomain>();
		
		String line = "";
		int lineNumber = 1;
		while((line=reader.readLine()) != null) {
			log.debug(line); // showing parsed line
			
			if (StringUtils.isEmpty(line)) {
				break; // empty lines will be treated as EOL 
			}
			
			String lineTrimmedLower = line.trim().toLowerCase();
			
			StringTokenizer strTok = new StringTokenizer(lineTrimmedLower, ","); // tokenizing on comma
			String name = strTok.nextToken(); // domain token
			String numbInput = strTok.nextToken(); // price
			
			PremiumDomain aDomain = new PremiumDomain(name, new BigDecimal(numbInput));
			domainSet.add(aDomain);

			lineNumber++;
		}
		
		return domainSet;
	}
	
	
	/**
	 * This parses all the domains from the reader to generate the 
	 * command list to be returned
	 * @return
	 * @throws IOException only if we use a sensitive parser and if a problem occurs on parsing the commands
	 */
	public List<DomainRequest> parseRequests() throws IOException {
		Set<PremiumDomain> domainSet = new HashSet<PremiumDomain>();
		
		String line = "";
		int lineNumber = 1;
		while((line=reader.readLine()) != null) {
			log.debug(line); // showing parsed line
			
			if (StringUtils.isEmpty(line)) {
				break; // empty lines will be treated as EOL 
			}
			
			String lineTrimmedLower = line.trim().toLowerCase();
			
			StringTokenizer strTok = new StringTokenizer(lineTrimmedLower, ","); // tokenizing on comma
			String name = strTok.nextToken(); // domain token
			String numbInput = strTok.nextToken(); // price
			
			PremiumDomain aDomain = new PremiumDomain(name, new BigDecimal(numbInput));
			domainSet.add(aDomain);

			lineNumber++;
		}
		
		return domainSet;
	}
}
