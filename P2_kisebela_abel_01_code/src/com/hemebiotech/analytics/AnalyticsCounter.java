package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import org.apache.log4j.BasicConfigurator;

//import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.PropertyConfigurator;

/**
 * @author abel
 * 
 *Class will be able to execute the program, 
 *
 */
public class AnalyticsCounter {
	
	private ISymptomReader reader  = new ReadSymptomDataFromFile("symptoms.txt");
	private ISymptomWriter writer = new WriterSymptomDataToFile("result.out");
	
	private List<String> getSymtomsList() {
		return reader.getSymptoms();
	}
	
	/**
	 * Check all symptoms who will be tracked
	 */
	protected void checkSymptoms() {
		reader.checkSymtoms(getSymtomsList()); // If no data is available, return an empty List
	}
	
	/**
	 * Write the result with symptoms and they occurrences 
	 */
	protected void writeOutput() {
		writer.writeSymptoms(reader.getMapSymptoms());
	}
	

}
