package test.java;

import main.java.CLI.CommandLineInterface;
import main.java.Entities.User;
import main.java.Utilities.UserManager;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandLineInterfaceTest {
    CommandLineInterface CLI;
    @Before
    public void setup() {
        CLI = new CommandLineInterface();
    }

    @Test
    void testSignIn() {
        User user = UserManager.createNewUser("test", "test", "test");
        CLI.signIn(user);

        assertEquals(user, CLI.getUser());
    }
}