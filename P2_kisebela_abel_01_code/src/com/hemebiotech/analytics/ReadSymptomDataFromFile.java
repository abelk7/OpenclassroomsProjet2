package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	private Map<String, Integer> mapSymptoms = new TreeMap<>();
	private static final Logger LOGGER = Logger.getLogger(ReadSymptomDataFromFile.class);

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	/*
	 * 
	 * Try to Read the file sent in the constructor, 
	 * and add all symptoms in a list who will be returned
	 */
	@Override
	public List<String> getSymptoms() {
		List<String> result = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader (new FileReader(filepath))){

			String line = reader.readLine();

			while (line  != null) {
				result.add(line);
				line = reader.readLine();
			}
		} catch (IOException e) {
			LOGGER.error("Erreur lors de la lecture du fichier..." + e.getMessage());

		}

		return result;
	}


	/*
	 * check the list of symptoms sent in parameter, 
	 * in a loop, for each symptoms , check  the occurrences in the list 
	 * and add it in a map (name symptoms + number of occurrence)
	 */
	@Override
	public void checkSymtoms(List<String> listSymptom) {
		try {
			for (String symptom : listSymptom) {

				if(mapSymptoms.containsKey(symptom)) {
					mapSymptoms.replace(symptom, mapSymptoms.get(symptom) +1);
				}else {
					mapSymptoms.put(symptom, 1);
				}
			}

		} catch (Exception e) {
			LOGGER.error("Une erreur est survenue lors du check des symptomes."+ e.getMessage());
		}

	}

	//return the map of symptoms with they occurrences
	public Map<String, Integer> getMapSymptoms() {
		return mapSymptoms;
	}
}
