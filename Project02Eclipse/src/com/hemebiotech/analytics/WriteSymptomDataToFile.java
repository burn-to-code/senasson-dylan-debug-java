package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Classe permettant d'écrire les symptômes et leurs occurrences dans un fichier.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
	
	/** Nom du fichier de sortie */
	private String fichier;
	
	
	/**
	 * Constructeur prenant en paramètre le nom du fichier de sortie.
	 * 
	 * @param fileName Nom du fichier où enregistrer les symptômes. Ne peut être null ou vide.
     * @throws IllegalArgumentException Si le nom du fichier est null ou vide.
	 */
	public WriteSymptomDataToFile(final String fichier) {
	    if (fichier == null || fichier.trim().isEmpty()) {
	        throw new IllegalArgumentException("Le nom du fichier ne peut pas être vide ou null !");
	    }
		this.fichier = fichier;
	}
	
	/**
	 * utilise un try-with-ressources  pour ouvrir et fermer le fichier automatiquement
	 * 
	 *
	 * 
	 * @return retourne un nouveau fichier de la variable fichier avec les différentes clés et valeur d'une
	 * 			Map en paramètre
	 */
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		
	    if (symptoms == null || symptoms.isEmpty()) {
	        System.err.println("Aucune donnée à enregistrer. Le fichier " + fichier + " ne sera pas créé.");
	        return; // On ne crée pas le fichier si la liste est vide
	    }
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichier))) {
			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				writer.write(entry.getKey() + " : " + entry.getValue());	
				writer.newLine();
			} 
		} catch (IOException e) {
	        System.err.println("Erreur lors de l'écriture du fichier "+ fichier + " : " + e.getMessage());
	        e.printStackTrace();
	    }
		
		System.out.println("OPERATION REUSSI : Le Fichier " + fichier +" a été crée génèré avec succès ! ");
	}	
}
