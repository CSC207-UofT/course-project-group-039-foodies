package test.java;
import main.java.Entities.User;
import org.junit.Test;
import static org.junit.Assert.*;


public class UserTest {

    @Test
    public void testgetFullname() {
        User emily = new User("Emily Yi", "emilyyi", "emily@gmail.com");
        String y = emily.getFullname();
        assertEquals(y, "Emily Yi");
    }

    @Test
    public void testgetUsername() {
        User emily = new User("Emily Yi", "emilyyi", "emily@gmail.com");
        String y = emily.getUsername();
        assertEquals(y, "emilyyi");
    }

    @Test
    public void testgetEmail() {
        User emily = new User("Emily Yi", "emilyyi", "emily@gmail.com");
        String y = emily.getEmail();
        assertEquals(y, "emily@gmail.com");
    }
}