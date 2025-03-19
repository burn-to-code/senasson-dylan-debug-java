package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 */
public class ReadSymptomDataFromFile implements SymptomReader {

	private final String filepath;
	
	/**
	 * Constructor
	 *
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 * @throws IllegalArgumentException if the file name is null or empty.
	 */
	public ReadSymptomDataFromFile (String filepath) {
	    if (filepath == null || filepath.isBlank()) {
	        throw new IllegalArgumentException("Pour ReadSymptoms, Le chemin du fichier ne peut pas être null ou vide.");
	    }
		this.filepath = filepath;
	}
	
	/**
	 * Utilize one try-with-ressources for open and close the file automatically
	 * 
	 * @return Return a list of strings from each line of the file.txt, no accents and no uppercase.
	 */
	@Override
	public List<String> getSymptoms() {
		List<String> result = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader (new FileReader(filepath))) {
			String line = reader.readLine();
			
			if (line == null) {
				System.out.println("Le fichier " + filepath + " est vide, une liste vide sera retournée !");
			}
			
			while (line != null) {
				result.add(line);
				line = reader.readLine();
			}
			
		} catch (IOException e) {
			System.err.println("Impossible de lire le fichier " + filepath + " : " + e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

}
