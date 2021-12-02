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
        member.add("TestMember1");
        member.add("TestMember2");
        member.add("TestMember3");

        assertTrue(database.saveGroup("TestGroupCode0", "TestGroupName", member));
        assertFalse(database.saveGroup("TestGroupCode0", "TestGroupName", member));

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
        members.add("TestMember2");

        database.saveGroup("TestGroupCodeB", "TestGroupNameB", members);

        assertTrue(database.isGroup("TestGroupCodeB"));
        assertTrue(database.containsMember("TestGroupCodeB", "TestMember1"));
        assertTrue(database.containsMember("TestGroupCodeB", "TestMember2"));
        assertFalse(database.containsMember("TestGroupCodeB", "TestMember3"));
        assertTrue(database.addMember("TestGroupCodeB", "TestMember3"));
        assertTrue(database.containsMember("TestGroupCodeB", "TestMember3"));
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
        assertFalse(database.removeMember("TestGroupCodeC", "TestMember3"));
        assertTrue(database.addMember("TestGroupCodeC", "TestMember3"));
        assertTrue(database.removeMember("TestGroupCodeC", "TestMember3"));
    }


    @Test
    public void getJoinedGroups() {
        ArrayList<String> members = new ArrayList<>();
        members.add("TestMember1");
        members.add("TestMember2");

        database.saveGroup("TestGroupCodeD", "TestGroupNameD", members);

        assertTrue(database.isGroup("TestGroupCodeD"));
        assertTrue(database.containsMember("TestGroupCodeD", "TestMember1"));
        assertTrue(database.containsMember("TestGroupCodeD", "TestMember2"));
        assertTrue(database.getJoinedGroups("TestMember1").contains("TestGroupCodeD"));

        assertTrue(database.removeMember("TestGroupCodeD", "TestMember1"));
        assertFalse(database.getJoinedGroups("TestMember1").contains("TestGroupCodeD"));

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

}
