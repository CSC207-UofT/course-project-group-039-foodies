package main.java.UseCases.Utilities;

import main.java.Entities.User;

public class UserFacade {
    public static String getUsername(User user) {
        return user.getUsername();
    }
}
