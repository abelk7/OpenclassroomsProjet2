package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;

import org.apache.log4j.Logger;

public class WriterSymptomDataToFile implements ISymptomWriter{
	
	private static final Logger LOGGER = Logger.getLogger(WriterSymptomDataToFile.class);
	private String filepath = null;
	
	public WriterSymptomDataToFile (String filepath) {
		this.filepath = filepath;
	}
	
	
	/*
	 * Loop a map, for each key and is value  write it in the file
	 * given in the constructor 
	 *
	 */
	@Override
	public void writeSymptoms(Map<String, Integer> mapSymptoms) {
		try (FileWriter writer = new FileWriter (filepath)){
			
			LOGGER.info("------Résultat---------");
	        for (Map.Entry<String,Integer> mapentry : mapSymptoms.entrySet()) {
	        	LOGGER.info(mapentry.getKey() + " : " + mapentry.getValue());
	           writer.write(mapentry.getKey()+": "+ mapentry.getValue() + "\n");
	        }
		
		}catch(Exception e) {
			LOGGER.error("Une erreur est survenue lors de l'écriture des symptomes dans le fichier result.out."+ e.getMessage());
		}
		
	}

}
