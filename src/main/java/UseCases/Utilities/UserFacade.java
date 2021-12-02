package main.java.UseCases.Utilities;

import main.java.Entities.User;

public class UserFacade {
    /**
     * A getter for the user's username
     * @param user The User
     * @return The username of the user
     */
    public static String getUsername(User user) {
        return user.getUsername();
    }

    /**
     * A getter for the user's full name
     * @param user The User
     * @return The full name of the user
     */
    public static String getFullName(User user) {
        return user.getFullName();
    }

    /**
     * A getter for the user's email
     * @param user The User
     * @return The email of the user
     */
    public static String getEmail(User user) {
        return user.getEmail();
    }
}
