package main.java.UseCases;

import main.java.Entities.PreferenceBook;
import java.util.Random;

public class RecipeRecommender {
    PreferenceBook preference;

    public RecipeRecommender(PreferenceBook preference) {
        this.preference = preference;
    }

    /**
     * Return how similar the preference is to the current preference book
     * @param compareTo The second preference book
     * @return A double between 0 and 1 representing how similar they are
     */
    public double similarityScore(PreferenceBook compareTo) {
        Random rand = new Random();
        return rand.nextDouble();
    }

    /**
     * Return the option that most closely matches the preferences in preference.
     * If options is empty, null is returned.
     * @param options The possible options
     * @return The most similar PreferenceBook
     */
    public PreferenceBook mostSimilar(PreferenceBook[] options) {
        double maxSimilarity = -1;
        PreferenceBook mostSimilarPreference = null;

        for (PreferenceBook option : options) {
            double similarity = similarityScore(option);
            if (similarity > maxSimilarity) {
                maxSimilarity = similarity;
                mostSimilarPreference = option;
            }
        }

        return mostSimilarPreference;
    }
}