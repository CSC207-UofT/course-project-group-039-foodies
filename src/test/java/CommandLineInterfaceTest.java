package test.java;

import main.java.CLI.CommandLineInterface;
import main.java.Entities.User;
import main.java.UseCases.Utilities.UserManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandLineInterfaceTest {
    @Test
    void testSignIn() {
        CommandLineInterface CLI = new CommandLineInterface();
        User user = UserManager.createNewUser("test", "test", "test");
        CLI.signIn(user);

        assertEquals(user, CLI.getUser());
    }
}