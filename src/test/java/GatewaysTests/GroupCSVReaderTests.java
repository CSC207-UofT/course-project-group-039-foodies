package test.java.GatewaysTests;

//import main.java.Entities.Group;
import main.java.Gateways.GroupCSVReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

//import static org.junit.Assert.assertEquals;
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
        ArrayList<String> member = new ArrayList<>();
        member.add("TestGroupMember");
        member.add("TestGroupMember1");
        member.add("TestGroupMember2");
        database.saveGroup("TestGroupName", "TestGroupCode", member);
        assertTrue(database.isGroup("TestGroupName"));
        assertTrue(database.containsMember("TestGroupCode", "TestGroupMember"));
        assertTrue(database.containsMember("TestGroupCode", "TestGroupMember1"));
        assertTrue(database.containsMember("TestGroupCode", "TestGroupMember2"));
    }

//    @Test
//    public void getGroupTest() {
//        ArrayList<String> member = new ArrayList<String>();
//        member.add("TestGroupMember");
//        database.saveGroup("TestGroupName0", "TestGroupCode", member);
//        Group group = database.getGroup("TestGroupName0");
//        assertEquals("TestGroupName0", group.getGroupName());
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
