package test.java.GatewaysTests;

import main.java.Entities.Group;
import main.java.Gateways.GroupCSVReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


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
        database.saveGroup("TestGroupName", "TestGroupCode", new ArrayList<>());
        assertTrue(database.isGroup("TestGroupName"));
    }

//    @Test
//    public void getGroupTest() {
//        ArrayList<String> member = new ArrayList<String>();
//        member.add("TestGroupMember");
//        database.saveGroup("TestGroupName", "TestGroupCode", member);
//        Group group = database.getGroup("TestGroupName");
//        assertEquals("TestGroupName", group.getGroupName());
//        assertEquals("TestGroupCode", group.getGroupCode());
//        assertEquals(member, group.getGroupMembers());
//    }

    @Test
    public void removeGroup() {
        database.saveGroup("TestGroupName1", "TestGroupCode", new ArrayList<>());
        database.saveGroup("TestGroupName2", "TestGroupCode", new ArrayList<>());
        database.saveGroup("TestGroupName3", "TestGroupCode", new ArrayList<>());

        database.removeGroup("TestGroupName1");
        assertTrue(database.isGroup("TestGroupName2"));
        assertTrue(database.isGroup("TestGroupName3"));
        assertFalse(database.isGroup("TestGroupName1"));
    }
}
