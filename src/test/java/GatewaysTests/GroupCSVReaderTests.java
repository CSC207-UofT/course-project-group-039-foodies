package test.java.GatewaysTests;
import main.java.Gateways.GroupCSVReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

public class GroupCSVReaderTests {
    GroupCSVReader database = GroupCSVReader.getTestInstance();
    File databaseFile = new File(
            System.getProperty("user.dir") + "\\src\\test\\java\\GatewaysTests\\groupsTest.csv"
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
    public void saveGroupTest() {
        ArrayList<String> member = new ArrayList<>();
        member.add("TestMember1");
        member.add("TestMember2");
        member.add("TestMember3");

        database.saveGroup("TestGroupCode0", "TestGroupName0", member);

        assertTrue(database.isGroup("TestGroupCode0"));
        assertTrue(database.containsMember("TestGroupCode0", "TestMember1"));
        assertTrue(database.containsMember("TestGroupCode0", "TestMember2"));
        assertTrue(database.containsMember("TestGroupCode0", "TestMember3"));
    }


    @Test
    public void removeGroup() {
        database.saveGroup("TestGroupCode1", "TestGroupName1", new ArrayList<>());
        database.saveGroup("TestGroupCode2", "TestGroupName", new ArrayList<>());
        database.saveGroup("TestGroupCode3", "TestGroupName3", new ArrayList<>());

        database.removeGroup("TestGroupCode1");

        assertTrue(database.isGroup("TestGroupCode2"));
        assertTrue(database.isGroup("TestGroupCode3"));
        assertFalse(database.isGroup("TestGroupCode1"));
    }


    @Test
    public void addMember() {
        ArrayList<String> members = new ArrayList<>();
        members.add("TestMember1");

        database.saveGroup("TestGroupCodeB", "TestGroupNameB", members);

        assertTrue(database.isGroup("TestGroupCodeB"));
        assertTrue(database.containsMember("TestGroupCodeB", "TestMember1"));
        
        database.addMember("TestGroupCodeB", "TestMember2");
        assertTrue(database.containsMember("TestGroupCodeB", "TestMember2"));

    }


    @Test
    public void removeMember() {
        ArrayList<String> members = new ArrayList<>();
        members.add("TestMember1");
        members.add("TestMember2");

        database.saveGroup("TestGroupCodeC", "TestGroupNameC", members);

        assertTrue(database.isGroup("TestGroupCodeC"));
        assertTrue(database.containsMember("TestGroupCodeC", "TestMember1"));
        assertTrue(database.containsMember("TestGroupCodeC", "TestMember2"));
        assertFalse(database.containsMember("TestGroupCodeC", "TestMember3"));

        database.removeMember("TestGroupCodeC", "TestMember3");
        database.addMember("TestGroupCodeC", "TestMember3");
        database.removeMember("TestGroupCodeC", "TestMember3");
    }


    @Test
    public void getJoinedGroups() {
        ArrayList<String> members = new ArrayList<>();
        members.add("TestMember1");
        members.add("TestMember2");

        database.saveGroup("TestGroupCodeY", "TestGroupNameY", members);

        assertTrue(database.isGroup("TestGroupCodeY"));
        assertTrue(database.containsMember("TestGroupCodeY", "TestMember1"));
        assertTrue(database.containsMember("TestGroupCodeY", "TestMember2"));
        assertFalse(database.containsMember("TestGroupCodeY", "TestMember3"));
        assertTrue(database.getJoinedGroups("TestMember1").contains("TestGroupCodeY"));
    }
}
