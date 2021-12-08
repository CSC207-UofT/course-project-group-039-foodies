package test.java.GatewaysTests;

import main.java.Gateways.PreferenceBookCSVReader;
import main.java.UserInterface.Commands.GroupCommands.AddGroupMemberCommand;
import main.java.UserInterface.UserInterface;
import org.junit.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

public class PreferenceBookCSVReaderTests {
    PreferenceBookCSVReader database = PreferenceBookCSVReader.getTestInstance();
    File databaseFile = new File(
            System.getProperty("user.dir") + "\\src\\test\\java\\GatewaysTests\\preferencesTest.csv"
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
    public void newPrefBookTest(){
        //default preference book
        database.addPreferenceBook("TestUser");

        assertEquals(database.getDiet("TestUser"), "No Diet");
    }
    @Test
    public void savePrefTest() {
        database.updateDiet("TestUser", "Vegan", "No Diet");
        database.updateOmit("TestUser", "add", "eggs");
        database.updateInclude("TestUser", "add", "broccoli");

        assertEquals(database.getPreferenceBook("TestUser").getDiet(), "Vegan");
        assertEquals(database.getPreferenceBook("TestUser").getOmit().get(1), "eggs");
        assertEquals(database.getPreferenceBook("TestUser").getInclude().get(1), "broccoli");
    }
    @Test
    public void removePrefTest() {
        database.updateOmit("TestUser", "add", "eggs");
        database.updateInclude("TestUser", "add", "broccoli");

        database.updateOmit("TestUser", "remove", "eggs");
        database.updateInclude("TestUser", "remove", "broccoli");

        assert !database.getPreferenceBook("TestUser").contains("omit", "eggs");
        assert !database.getPreferenceBook("TestUser").contains("include", "broccoli");

        database.removePreferenceBook("TestUser");
    }

}
