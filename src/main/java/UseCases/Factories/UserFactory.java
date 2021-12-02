package main.java.UseCases.Factories;

import main.java.Entities.RecipeBook;
import main.java.Entities.User;

/**
 * A Facade Factory to act as a buffer between gateways and controllers
 */
public class UserFactory {
    /**
     * Create a User object corresponding to some specified user.
     * @param fullName The name of the user
     * @param username The username of the user
     * @param email The email of the user
     * @param recipeBook The recipe book of the user
     * @return The User object
     */
    public static User createUser(String fullName, String username, String email, RecipeBook recipeBook) {
        return new User(fullName, username, email, recipeBook);
    }
}
