package test.java;

import main.java.UserInterface.CLI.CommandLineInterface;
import main.java.Entities.User;
import main.java.Gateways.UserCSVReader;

import org.junit.Test;
import static org.junit.Assert.*;

public class CommandLineInterfaceTest {
    @Test
    public void testSignIn() {
        CommandLineInterface CLI = new CommandLineInterface();
        UserCSVReader.getInstance().addUser("test", "test", "test", "test");
        User user = UserCSVReader.getInstance().getUser("test");
        CLI.signIn(user);

        assertEquals(user, CLI.getUser());
    }
}