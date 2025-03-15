package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * La classe main qui vas utiliser les méthodes pour lire un fichier, compter les symptomps, trier les 
 * symtomps dans l'ordre alphabétique puis les compiler dans un nouveau fichier de sortie.
 */

public class AnalyticsCounter {
	private ISymptomWriter writer;
	private ISymptomReader reader;
	
    /**
     * CONSTRUCTEUR avec reader et after
     * 
     * @param reader une instance de ISymptomReader
     * @param writer une instance de ISymptomWriter
     */

	public AnalyticsCounter(ISymptomWriter writer, ISymptomReader reader) {
		this.writer = writer;
		this.reader = reader;
	}
	
	
	// DECLARATION DE METHODES (GETSYMTOMS, COUNTSYMPTOMS, SORTSYMPTOMS, WRITESYMPTOMS)
	
	/**
	 * 
	 * @return retourne la liste des symptomes avec les doublons en utilisant l'objet readsymptomDataFromFIle
	 * et la méthode getSymtoms prédéfini au début du cours
	 */
	public List<String> getSymptoms() throws IOException {
		return reader.getSymptoms();
	}
	
	
	/**
	 * Cette méthode prend en entrée une liste de symptômes et retourne une Map qui associe à chaque symptôme 
	 * le nombre de fois où il apparaît dans la liste. Si un symptôme apparaît plusieurs fois, la valeur correspondante 
	 * dans la **Map** sera incrémentée à chaque apparition du symptôme dans la liste.
	 * 
	 * Elle utilise la méthode getOrDefault() pour vérifier si un symptôme a déjà été rencontré. Si ce n'est pas le 
	 * cas, elle initialise son compteur à 0 avant de l'incrémenter. sinon elle prend la valeur acutel et lui rajoute 1
	 * 
	 * @param symptoms Une liste de chaînes de caractères représentant les symptômes à compter.
	 * @return Une Map où chaque clé est un symptôme (chaîne de caractères) et chaque valeur est le nombre 
	 *         d'occurrences de ce symptôme dans la liste (entier). ou une liste vide si get symptoms return une list vide.
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomsCount = new HashMap<>();
		
		for (String symptom : symptoms) {
			symptomsCount.put(symptom, symptomsCount.getOrDefault(symptom, 0) +1);
		}
		
		return symptomsCount;
	}
	
	
	/**
	 * Trie les symptômes par ordre alphabétique des clés (les symptômes eux-mêmes).
	 * 
	 * Cette méthode crée un TreeMap à partir de la Map des symptômes fournie, 
	 * ce qui permet de trier automatiquement les entrées par ordre alphabétique des clés 
	 * (ici, les symptômes sont des chaînes de caractères). 
	 * 
	 * @param symptoms La Map contenant les symptômes et leur nombre d'occurrences.
	 * @param mapTriee utilisé comme variable de sortie et interne a la fonction.
	 * @return Une nouvelle Map triée par ordre alphabétique des symptômes.
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> mapTriee = new TreeMap<>(symptoms);
		return mapTriee;
	}
	
	
	/**
	 * Appelle la méthode writeSymptoms de l'objet ISymptomWriter(writesymtomsdatatofile pour nous) pour enregistrer 
	 * les symptômes dans un fichier.
	 * 
	 * Cette méthode prend la Map des symptômes et utilise l'instance de ISymptomWriter 
	 * (fournie lors de la création de l'objet) pour écrire les symptômes dans un fichier.
	 * 
	 * @param symptoms La Map contenant les symptômes et leur nombre d'occurrences.
	 * @throws IOException Si un problème survient lors de l'écriture dans le fichier.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) { 
		writer.writeSymptoms(symptoms);
	}
	
	
	// DECLARATION DU MAIN 
	
	public static void main(String args[]) throws Exception {
		// ce qu'il reste à coder
	}
}
