package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
	
	private String fichier;
	
	public WriteSymptomDataToFile(final String fichier) {
		this.fichier = fichier;
	}
	
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
		try (FileWriter writer = new FileWriter(fichier)) {
			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				writer.write(entry.getKey() + " : " + entry.getValue() + "\n");	
			}
		}
	}	
}
