package test.java;

import main.java.Entities.Group;
import main.java.Entities.User;
import main.java.UseCases.Utilities.GroupManager;
import main.java.UseCases.GroupFactory;

import org.junit.Test;
import static org.junit.Assert.*;


public class GroupManagerTest {

    @Test
    public void testCreateNewGroup() {
        User userEmily = new User("Emily Y", "emily", "emily@gamil.com");
        Group group1 = GroupFactory.createNewGroup("Group 1", userEmily);
        GroupManager.addGroup(group1);
        assertTrue(group1.getGroupMembers().contains(userEmily.getUsername()));

        User userJudy = new User("Judy K", "judy", "judy@gamil.com");
        Group group2 = GroupFactory.createNewGroup("Group 2", userJudy);
        assertTrue(group2.getGroupMembers().contains(userJudy.getUsername()));

        assertNotEquals(group1.getGroupCode(), group2.getGroupCode());


    }


    @Test
    public void testAddMember() {
        User userEmily = new User("Emily Yi", "emilyyi", "emily@gamil.com");
        Group group1 = GroupFactory.createNewGroup("Group 1", userEmily);
        assertTrue(GroupManager.containsGroup(group1));

        User userHelena = new User("Helena Jovic", "helenajovic", "helena@gamil.com");
        assertTrue(GroupManager.addMember(group1, userHelena));
    }
    

    @Test
    public void testRemoveMember() {
        User userMichelle = new User("Michelle Lin", "michelle",
                "lin@gamil.com");
        Group group2 = GroupFactory.createNewGroup("Group 2", userMichelle);
        assertTrue(GroupManager.containsGroup(group2));

        User userHelena = new User("Helena Jovic", "helenajovic",
                "helena@gamil.com");
        assertFalse(GroupManager.removeMember(group2, userHelena));
        assertTrue(GroupManager.addMember(group2, userHelena));
        assertTrue(GroupManager.removeMember(group2, userHelena));
        assertFalse(group2.getGroupMembers().contains(userHelena.getUsername()));
    }

}
