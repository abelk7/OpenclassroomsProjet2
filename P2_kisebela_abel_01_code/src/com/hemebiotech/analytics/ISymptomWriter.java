/**
 * 
 */
package com.hemebiotech.analytics;

import java.util.Map;

/**
 * @author abel
 *
 */
public interface ISymptomWriter {
	/**
	 *
	 * Write in a file name <b>"result.out"</b> the values of mapSymptoms
	 * @param mapSymptoms
	 */
	void writeSymptoms(Map<String, Integer> mapSymptoms);

}
