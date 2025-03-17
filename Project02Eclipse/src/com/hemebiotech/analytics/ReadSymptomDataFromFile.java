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
	 * Utilize one try-with-ressources for open and close the file automatically 
	 * 
	 * @return return a list string de chaque ligne du fichier.txt no accent and no Uppercase
	 * et il n'ajoute pas de ligne vide à la liste
	 * @throws IllegalArgumentException Si le nom du fichier est null ou vide.
	 */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<>();
		
	    if (filepath == null || filepath.trim().isEmpty()) {
	        throw new IllegalArgumentException("Le chemin du fichier ne peut pas être null ou vide.");
	    }
	    
		
		try (BufferedReader reader = new BufferedReader (new FileReader(filepath))) {
			String line = reader.readLine();
			
			if (line == null) {
				System.err.println("Le fichier " + filepath + " est vide ");
	            return result;  
			}
			
			while (line != null) {
				line = line.trim(); 
				if (!line.isEmpty()) { 
					result.add(RemoveAccents.removeAccents(line.toLowerCase()));
				} 
				line = reader.readLine();
			}
			
		} catch (IOException e) {
			System.err.println("une erreur s'est produite : " + e.getMessage());
			e.printStackTrace();
		}
	
		
		return result;
	}

}
