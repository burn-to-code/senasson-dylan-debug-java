package com.hemebiotech.analytics;

import java.text.Normalizer;

/**
 * Class Utilitaire
 *
 */
public class RemoveAccents {
	
	/**
	 * Vérifie que le param donnée n'est pas vide 
	 * 
	 * @param String mot est une chaine de caractère
	 * @return une chaine de caractère sans accents
	 */
	
	public static String removeAccents (String mot) {
		
	    if (mot == null || mot.trim().isEmpty()) { 
	        return mot;
	    }
		String normalizedString = Normalizer.normalize(mot, Normalizer.Form.NFD);
		
		return normalizedString.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}
}
