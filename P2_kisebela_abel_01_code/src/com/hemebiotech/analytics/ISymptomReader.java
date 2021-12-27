package com.hemebiotech.analytics;

import java.util.List;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	/**
	 *
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	List<String> getSymptoms ();
	/**
	 * Check the occurrences of symptom from the listSytom (in parameter), and write the result in mapSymptoms
	 * @param listSymptom
	 */
	void checkSymtoms(List<String> listSymptom);
}
