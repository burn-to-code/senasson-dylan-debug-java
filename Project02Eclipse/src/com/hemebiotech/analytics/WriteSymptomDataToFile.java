package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Class for writing symptoms and their occurrences to a file.
 */
public class WriteSymptomDataToFile implements SymptomWriter {
	
	private final String filepath;
	
	/**
	 * Constructor taking the output file name as a parameter.
	 * 
	 * @param filepath File name to save the symptoms. Cannot be null or empty.
	 * @throws IllegalArgumentException if the file name is null or empty.
	 */
	public WriteSymptomDataToFile(final String filepath) {
	    if (filepath == null || filepath.isBlank()) {
	        throw new IllegalArgumentException("Pour WriteSymptomDataToFile, Le nom du fichier ne peut pas être vide ou null !");
	    }
		this.filepath = filepath;
	}
	
	/**
	 * Use a try-with-resources to open and close the file automatically.
	 * @param symptoms is a sorted or unsorted key/value element map.
	 */
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		if (symptoms == null) {
			throw new IllegalArgumentException("la liste des symptoms ne peut pas être null, le fichier ne sera pas crée.");
		}
		
	    if (symptoms.isEmpty()) {
	        System.out.println("Aucune donnée à enregistrer. Le fichier " + filepath + " sera vide.");
	    }

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				writer.write(entry.getKey() + " : " + entry.getValue());
				writer.newLine();
			}
		} catch (IOException e) {
	        System.err.println("Erreur lors de l'écriture du fichier "+ filepath + " : " + e.getMessage());
	        e.printStackTrace();
	    }
		
		System.out.println("OPERATION RÉUSSI : Le Fichier " + filepath +" a été crée et généré avec succès ! ");
	}
}