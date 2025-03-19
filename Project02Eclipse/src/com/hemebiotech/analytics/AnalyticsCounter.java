package com.hemebiotech.analytics;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The AnalyticsCounter class acts as the conductor between the different elements,
 * with the goal of centralizing only the methods of this class in our main.
 */
public class AnalyticsCounter {
	private final SymptomReader reader;
	private final SymptomWriter writer;

	/**
	 * Constructor
	 *
	 * @param reader in instance of SymptomReader
	 * @param writer in instance of SymptomWriter
	 */

	public AnalyticsCounter(SymptomReader reader, SymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	
	/**
	 * @return Returns the list of symptoms with duplicates using the readSymptomDataFromFile object.
	 * and the getSymptoms method predefined at the beginning.
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}
	
	
	/**
	 * Takes a list of symptoms as input and returns a Map that associates each symptom with its occurrence.
	 * She's using compute method.
	 * 
	 * @param symptoms A list of strings representing the symptoms to count.
	 * @return A Map with symptoms and their occurrences, or an empty list if getSymptoms returns an empty list.
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomsCount = new HashMap<>();
		
		for (String symptom : symptoms) {
			symptomsCount.compute(symptom, (key, val) -> (val == null) ? 1 : val + 1);
		}
		
		return symptomsCount;
	}
	
	
	/**
	 * Sorts the symptoms in alphabetical order of the keys, and thus their associated values (the symptoms themselves).
	 * (Here, the symptoms are strictly strings).
	 * 
	 * @param symptoms The Map containing the symptoms and their number of occurrences.
	 * @return A new Map sorted in alphabetical order of the symptoms.
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
	}
	
	
	/**
	 * Calls the writeSymptoms method of SymptomWriter to save the symptoms to a file.
	 * 
	 * @param symptoms The Map containing the symptoms and their number of occurrences.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) { 
		writer.writeSymptoms(symptoms);
	}

}