package com.hemebiotech.analytics;

import java.util.List;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * The implementation does not need to order the list
 * @FunctionnalInterface
 */
public interface SymptomReader {
    /**
     * @return A raw list of symptoms from a data source. Duplicates are allowed.
     */
    List<String> getSymptoms();
}
