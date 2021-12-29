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
	 * Write in a <b>file</b> the values of mapSymptoms
	 * @param mapSymptoms
	 */
	void writeSymptoms(Map<String, Integer> mapSymptoms);

}
