package test.java;

import main.java.Entities.Group;
import main.java.Entities.User;
import main.java.UseCases.Utilities.GroupManager;
import main.java.UseCases.Factories.GroupFactory;

import org.junit.Test;
import static org.junit.Assert.*;


public class GroupManagerTest {

    @Test
    public void testCreateNewGroup() {
        String groupNameA = "Group A";
        Group groupA = GroupFactory.createNewGroup(groupNameA);

        assertFalse(groupA.getGroupCode().isEmpty());

        String groupNameB = "Group B";
        Group groupB = GroupFactory.createNewGroup(groupNameB);

        assertNotEquals(groupA.getGroupCode(), groupB.getGroupCode());
    }

    @Test
    public void testAddGroup() {
        String groupName = "Group 1";
        Group group1 = GroupFactory.createNewGroup(groupName);
        assertTrue(GroupManager.addGroup(group1));
        assertTrue(GroupManager.containsGroup(group1.getGroupCode()));
        assertTrue(group1.getGroupMembers().isEmpty());
    }


    @Test
    public void testAddMember() {
        String groupName = "Group 1";
        Group group1 = GroupFactory.createNewGroup(groupName);
        GroupManager.addGroup(group1);
        User userHelena = new User("Helena Jovic", "helenajovic", "helena@gamil.com");

        assertTrue(GroupManager.addMember(group1.getGroupCode(), userHelena.getUsername()));
        assertTrue(group1.getGroupMembers().contains(userHelena.getUsername()));
        assertFalse(GroupManager.addMember(group1.getGroupCode(), userHelena.getUsername()));
    }
    

    
    @Test
    public void testRemoveMember() {
        User userMichelle = new User("Michelle Lin", "michelle",
                "lin@gamil.com");
        Group group2 = GroupFactory.createNewGroup("Group 2");
        GroupManager.addGroup(group2);

        assertTrue(GroupManager.containsGroup(group2.getGroupCode()));
        assertFalse(GroupManager.removeMember(group2.getGroupCode(), userMichelle.getUsername()));

        GroupManager.addMember(group2.getGroupCode(), userMichelle.getUsername());

        assertTrue(GroupManager.removeMember(group2.getGroupCode(), userMichelle.getUsername()));
    }
}

