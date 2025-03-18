package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface représentant un écrivain de symptômes.
 * Cette interface définit une méthode pour écrire des symptômes et leur nombre dans un fichier à partir
 * d'une Map.
 * 
 * @FunctionnalInterface
 */
public interface SymptomWriter {

    /**
     * Écrit les symptômes et leur fréquence dans un fichier.
     * Cette méthode utilise une structure try with resources pour garantir que le fichier est correctement
     * ouvert et fermé, même en cas d'erreur. Le fichier est supposé être au format texte.
     * @param symptoms La Map contenant les symptômes en tant que clés et leur fréquence en tant que valeurs.
     * */
    void writeSymptoms(Map<String, Integer> symptoms);
}
