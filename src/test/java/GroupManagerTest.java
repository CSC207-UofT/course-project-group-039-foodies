package test.java;
import main.java.Entities.Group;
import main.java.Entities.User;
import main.java.UseCases.Utilities.GroupManager;
import org.junit.Test;
import static org.junit.Assert.*;


public class GroupManagerTest {

    @Test
    public void testCreateNewGroup() {
        Group group1 = new Group("Group 1");
        User user1 = new User("Emily Yi", "emilyyi", "emily@gamil.com");
        String groupName1 = group1.getGroupName();
        Group createdGroup1 = GroupManager.createNewGroup(groupName1, user1);
        assertTrue(createdGroup1.getGroupMembers().contains(user1.getUsername()));

        Group group2 = new Group("Group 2");
        User user2 = new User("Judy Kim", "judykim", "judy@gamil.com");
        String groupName2 = group2.getGroupName();
        Group createdGroup2 = GroupManager.createNewGroup(groupName2, user2);
        assertTrue(createdGroup2.getGroupMembers().contains(user2.getUsername()));

        assertNotEquals(createdGroup1.getGroupCode(), createdGroup2.getGroupCode());

    }

    @Test
    public void testAddGroup() {
        Group group1 = new Group("Group 1");
        User user1 = new User("Emily Yi", "emilyyi", "emily@gamil.com");
        String groupName1 = group1.getGroupName();
        Group createdGroup1 = GroupManager.createNewGroup(groupName1, user1);
        assertTrue(GroupManager.addGroup(createdGroup1));
        assertFalse(GroupManager.addGroup(createdGroup1));
        assertTrue(GroupManager.containsGroup(createdGroup1));
    }

    @Test
    public void testAddMember() {
        Group group1 = new Group("Group 1");
        User user1 = new User("Emily Yi", "emilyyi", "emily@gamil.com");
        String groupName1 = group1.getGroupName();
        Group createdGroup1 = GroupManager.createNewGroup(groupName1, user1);
        assertTrue(GroupManager.addGroup(createdGroup1));
        assertTrue(GroupManager.containsGroup(createdGroup1));

        User user3 = new User("Helena Jovic", "helenajovic", "helena@gamil.com");
        assertTrue(GroupManager.addMember(createdGroup1, user3));
    }

    @Test
    public void testRemoveMember() {
        Group group = new Group("Group 2");
        User userMichelle = new User("Michelle Lin", "michelle",
                "lin@gamil.com");
        String groupName = group.getGroupName();
        Group createdGroup = GroupManager.createNewGroup(groupName, userMichelle);
        assertTrue(GroupManager.addGroup(createdGroup));
        assertTrue(GroupManager.containsGroup(createdGroup));

        User userHelena = new User("Helena Jovic", "helenajovic",
                "helena@gamil.com");
        assertFalse(GroupManager.removeMember(createdGroup, userHelena));
        assertTrue(GroupManager.addMember(createdGroup, userHelena));
        assertTrue(GroupManager.removeMember(createdGroup, userHelena));
        assertFalse(createdGroup.getGroupMembers().contains(userHelena.getUsername()));

    }

}

