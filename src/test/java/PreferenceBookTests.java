package test.java;

import main.java.Entities.PreferenceBook;
import org.junit.Test;
import static org.junit.Assert.*;

public class PreferenceBookTests {
    PreferenceBook preferences = new PreferenceBook("TestUser");

    @Test
    public void addDietTest() {
        preferences.addDiet("Vegan");
        assertEquals(preferences.getDiet(), "Vegan");
    }

    @Test
    public void containsTest() {
        assertFalse(preferences.contains("omit", "eggs"));
    }
}
