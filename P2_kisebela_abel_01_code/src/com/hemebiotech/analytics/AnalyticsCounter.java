package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

public class AnalyticsCounter {
	
	private ReadSymptomDataFromFile reader  = new ReadSymptomDataFromFile("symptoms.txt");
	private WriterSymptomDataToFile writer = new WriterSymptomDataToFile("result.out");
	
	protected List<String> getSymtomsList() {
		return reader.getSymptoms();
	}
	
	protected void checkSymptoms() {
		reader.checkSymtoms(getSymtomsList()); // If no data is available, return an empty List
	}
	
	protected void writeOutput() {
		writer.writeSymptoms(reader.getMapSymptoms());
	}
	
	//Entry point
	public static void main(String args[]) throws Exception {
		
		BasicConfigurator.configure();
		
		AnalyticsCounter analyse = new AnalyticsCounter();
		analyse.checkSymptoms();
		analyse.writeOutput();

	}
}
