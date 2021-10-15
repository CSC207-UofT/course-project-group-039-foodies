package main.java.Utilities;

import main.java.Entities.PreferenceBook;

import java.util.Random;

public class RecipeRecommender {
    /**
     * Return how similar two preferenceBooks are.
     * @param preferences0 The first preference book
     * @param preferences1 The second preference book
     * @return A double between 0 and 1 representing how similar they are
     */
    public static double similarityScore(PreferenceBook preferences0, PreferenceBook preferences1) {
        Random rand = new Random();
        return rand.nextDouble();
    }

    /**
     * Return the option that most closely matches the preferences in preference.
     * If options is empty, null is returned.
     * @param preference The preference we are trying to find the most similar option for
     * @param options The possible options
     * @return The most similar PreferenceBook
     */
    public static PreferenceBook mostSimilar(PreferenceBook preference, PreferenceBook[] options) {
        double maxSimilarity = -1;
        PreferenceBook mostSimilarPreference = null;

        for (PreferenceBook option : options) {
            double similarity = similarityScore(preference, option);
            if (similarity > maxSimilarity) {
                maxSimilarity = similarity;
                mostSimilarPreference = option;
            }
        }

        return mostSimilarPreference;
    }
}