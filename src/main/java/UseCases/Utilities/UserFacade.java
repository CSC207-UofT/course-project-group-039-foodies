package main.java.UseCases.Utilities;

import main.java.Entities.User;

public class UserFacade {
    public static String getUsername(User user) {
        return user.getUsername();
    }

    public static String getFullName(User user) {
        return user.getFullName();
    }

    public static String getEmail(User user) {
        return user.getEmail();
    }
}
