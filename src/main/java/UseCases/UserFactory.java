package main.java.UseCases;

import main.java.Entities.RecipeBook;
import main.java.Entities.User;

/**
 * A Facade Factory to act as a buffer between gateways and controllers
 */
public class UserFactory {
    public static User createUser(String fullName, String username, String email, RecipeBook recipeBook) {
        return new User(fullName, username, email, recipeBook);
    }
}
