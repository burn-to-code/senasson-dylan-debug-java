package com.hemebiotech.analytics;

import java.util.List;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * @FunctionnalInterface
 */
public interface ISymptomReader {
    /**
     * Récupere une liste brute de symptôms à partir d'une source de données.
     * Cette liste peut contenir des douccblons, qui devront être gérés plus tard dans le processus.
     * 
     * Si aucune donnée n'est disponible, la méthode renverra une liste vide.
	 * @return une liste brute de symptôms à partir d'une source de données. Les doublons sont possibles
	 */
	List<String> getSymptoms();
}
