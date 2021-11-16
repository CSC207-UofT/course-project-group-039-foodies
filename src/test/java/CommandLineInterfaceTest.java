package test.java;

import main.java.UserInterface.CLI.CommandLineInterface;
import main.java.Entities.User;
import main.java.Gateways.UserCSVReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandLineInterfaceTest {
    @Test
    void testSignIn() {
        CommandLineInterface CLI = new CommandLineInterface();
        UserCSVReader.getInstance().addUser("test", "test", "test", "test");
        User user = UserCSVReader.getInstance().getUser("test");
        CLI.signIn(user);

        assertEquals(user, CLI.getUser());
    }
}