package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		

		BasicConfigurator.configure();

		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		WriterSymptomDataToFile writer = new WriterSymptomDataToFile();
		
		List<String> symptomsToCheck = reader.getSymptoms();
		
		reader.checkSymtoms(symptomsToCheck);
		
		writer.writeSymptoms(reader.getMapSymptoms());
	
	}
}
