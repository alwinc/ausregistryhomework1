/**
 * @Copyright 2013
 * All rights reserved
 */
package com.winnergenic.ausregistry.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;

import com.winnegenic.reagroup.robot.Board;
import com.winnegenic.reagroup.robot.CommandParserDelegate;
import com.winnegenic.reagroup.robot.Robot;
import com.winnegenic.reagroup.robot.command.Command;

/**
 * DomainRegistrar.java
 * Started - Aug 14, 2013
 */
public class DomainRegistrar {

	private Set<Domain> zoneList;
	private Set<PremiumDomain> premiumDomains;
	private List<DomainRequest> domainRequests;
	
	/**
	 * Main function for execution
	 */
	public static void main(String[] args){
		InputStreamReader isreader = null;
		BufferedReader reader = null;
		
		try {
			isreader = new InputStreamReader(System.in);
			reader = new BufferedReader(isreader);
		
			CommandLineParserDelegate parser = new CommandLineParserDelegate(reader);
			List<Command> commandSequence = parser.parseCommands();
			
			Robot standardRobot = new Robot();
			Board standardBoard = new Board(5, 5); // 5x5 board
			standardRobot.setBoard(standardBoard);
			standardRobot.setCommandSequence(commandSequence);
			standardRobot.executeCommands();
		} catch (IOException e) {
			
		} finally {
			IOUtils.closeQuietly(reader);
		}
	}
}
