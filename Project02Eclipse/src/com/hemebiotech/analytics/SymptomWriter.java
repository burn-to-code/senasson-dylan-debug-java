package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface representing a symptom writer.
 * This interface defines a method to write symptoms and their count to any file from a map.
 * If the map passed as a parameter is null, the file is not created and an IllegalArgumentException is thrown.
 * @FunctionnalInterface
 */
public interface SymptomWriter {

    /**
     * Write the symptoms and their frequency to a file.
     * This method uses a try-with-resources structure to ensure that the file is properly closed.
     * @param symptoms La Map contenant les symptômes en tant que clés et leur fréquence en tant que valeurs.
     * */
    void writeSymptoms(Map<String, Integer> symptoms);
}
