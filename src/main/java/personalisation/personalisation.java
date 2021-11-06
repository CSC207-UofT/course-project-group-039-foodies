package main.java.personalisation;

public interface personalisation {
    // take the filtered list of recipes (filtered according to breakfast, lunch, dinner, allergens etc and) and match
    // with user's own recipe book to produce a percentage match. Return the recipe with the highest percentage match
    // and move through this in order.


    // Filtered lists to be used by personalisation algorithm will be:
        // - specific to the user's removed allergens/ dietary restrictions
        // - specific to user's breakfast/ lunch/ dinner/ snack/drinks specification
        // -

    // Similarity based on (total - 100%):
        // - same word in name match? eg. pancakes in the name = +20 %
        // - percentage of ingredient match ? (this will make up 80%)

    // Return 3 levels:
        // - highly recommended for you ( >= 80% match)
        // - recommended for you ( >= 50% match)
        // - not recommended for you ( <= 50% match)
            // - Try something new recommendation?
            // - do not recommend to users at all?

    // if Highly Recommended,
        // - return the recipes one by one at random
    // if Recommended and Highly Recommended is out of recipes
        // - return the recipes one by one at random
    // if both of the above lists are out of recipes
        // - return no more recipes or return a recipe with "Try Something New"
}
