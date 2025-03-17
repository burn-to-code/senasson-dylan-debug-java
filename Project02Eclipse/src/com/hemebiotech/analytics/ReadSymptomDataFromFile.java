package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * Constructeur
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * utilise un try-with-ressources  pour ouvrir et fermer le fichier automatiquement
	 * 
	 * @return retourne une list string de chaque ligne du fichier.txt
	 */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<>();
		
	    if (filepath == null || filepath.trim().isEmpty()) {
	        throw new IllegalArgumentException("Le chemin du fichier ne peut pas être null ou vide.");
	    }
	    
		
		try (BufferedReader reader = new BufferedReader (new FileReader(filepath))){
			String line = reader.readLine();
			
			if (line == null) {
				System.err.println("Le fichier " + filepath + " est vide ");
	            return result;  
			}
			
			while (line != null) {
				result.add(line);
				line = reader.readLine();
			}
			
		} catch (IOException e) {
			System.err.println("une erreur s'est produite : " + e.getMessage());
			e.printStackTrace();
		}
	
		
		return result;
	}

}
