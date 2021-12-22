package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;

import org.apache.log4j.Logger;

public class WriterSymptomDataToFile implements ISymptomWriter{
	
	private static final Logger LOGGER = Logger.getLogger(WriterSymptomDataToFile.class);
	
	public void writeSymptoms(Map<String, Integer> mapSymptoms) {
		try (FileWriter writer = new FileWriter ("result.out")){
			
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
