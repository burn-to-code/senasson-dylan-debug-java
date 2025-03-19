package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * @author Dylan Senasson
 * @version 21.0.6
 *
 * Se préparer pour la soutenance.
 */

public class Main {
	
	
	/**
	 * @param args args no use here
	 */
	public static void main(String[] args) {
		final SymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		final SymptomWriter writer = new WriteSymptomDataToFile("result.out");
		
		final AnalyticsCounter counter = new AnalyticsCounter(reader, writer);
	
		List<String> symptoms = counter.getSymptoms();
		
		Map<String, Integer> symptomsCount = counter.countSymptoms(symptoms);
		
		Map<String, Integer> sortedSymptoms = counter.sortSymptoms(symptomsCount);
		
		counter.writeSymptoms(sortedSymptoms);
	}
}
