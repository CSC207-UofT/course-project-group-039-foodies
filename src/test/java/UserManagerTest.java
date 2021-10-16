package test.java;
import main.java.Entities.User;
import main.java.UseCases.Utilities.UserManager;
import org.junit.Test;
import static org.junit.Assert.*;


public class UserManagerTest {

    @Test
    public void testAddUser() {
        User emily1 = new User("Emily Yi", "emilyyi", "emily@gmail.com");
        User emily2 = new User("Emilie Yi", "emilyyi", "emilie@gmail.com");
        assertTrue(UserManager.addUser(emily1));
        assertFalse(UserManager.addUser(emily2));
    }

    @Test
    public void testContainsUser() {
        assertFalse(UserManager.containsUser("michellelin"));
        UserManager.addUser("Michelle Lin", "michellelin", "michelle@gmail.com");
        assertTrue(UserManager.containsUser("michellelin"));

        assertFalse(UserManager.containsUser("Helena Jovic"));
        User helena = new User("Helena Joivc", "helenajovic", "helena@gamil.com");
        UserManager.addUser(helena);
        assertTrue(UserManager.containsUser(helena));
    }

    @Test
    public void testGetUser() {
        User judy = new User("Judy Kim", "judykim", "judy@gamil.com");
        UserManager.addUser(judy);
        assertEquals(UserManager.getUser(judy.getUsername()), judy);
    }

    @Test
    public void testDeleteUser() {
        User mark = new User("Mark Bedaywi", "markbedaywi", "mark@gmail.com");
        UserManager.addUser(mark);
        assertTrue(UserManager.containsUser(mark));
        UserManager.deleteUser(mark);
        assertFalse(UserManager.containsUser(mark));
    }
}
