package test.java.GatewaysTests;
import main.java.Entities.User;
import main.java.Gateways.UserCSVReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class UserCSVReaderTests {
    UserCSVReader database = UserCSVReader.getTestInstance();
    File databaseFile = new File(
            System.getProperty("user.dir") + "\\src\\test\\java\\GatewaysTests\\usersTest.csv"
    );

    @Before
    @After
    public void resetFile() {
        databaseFile.delete();
        try {
            databaseFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addUserTest() {
        database.addUser("TestUserName", "TestPassword", "TestFullName", "TestEmail");
        assertTrue(database.isUser("TestUserName"));
    }

    @Test
    public void isCorrectPasswordTest() {
        database.addUser("TestUserName", "TestPassword", "TestFullName", "TestEmail");
        assertTrue(database.isCorrectPassword("TestUserName", "TestPassword"));
    }

    @Test
    public void getUserTest() {
        database.addUser("TestUserName", "TestPassword", "TestFullName", "TestEmail");
        User user = database.getUser("TestUserName");
        assertEquals("TestUserName", user.getUsername());
        assertEquals("TestFullName", user.getFullName());
        assertEquals("TestEmail", user.getEmail());
    }

    @Test
    public void removeUser() {
        database.addUser("TestUserName0", "TestPassword", "TestFullName", "TestEmail");
        database.addUser("TestUserName1", "TestPassword", "TestFullName", "TestEmail");
        database.addUser("TestUserName2", "TestPassword", "TestFullName", "TestEmail");

        database.removeUser("TestUserName1");
        assertTrue(database.isUser("TestUserName0"));
        assertTrue(database.isUser("TestUserName2"));
        assertFalse(database.isUser("TestUserName1"));
    }
}
