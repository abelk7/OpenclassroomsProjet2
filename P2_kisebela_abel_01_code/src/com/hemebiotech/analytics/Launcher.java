package com.hemebiotech.analytics;

import org.apache.log4j.BasicConfigurator;

public class Launcher extends AnalyticsCounter{

	//Entry point
	public static void main(String[] args) {
		
		//configure the logger
		BasicConfigurator.configure();
		
		AnalyticsCounter analyse = new AnalyticsCounter();
		analyse.checkSymptoms();
		analyse.writeOutput();

	}
}
