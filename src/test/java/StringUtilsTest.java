import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.github.duckysmacky.utilimate.strings.StringUtils.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {
    private static List<String> listOfStrings;

    @BeforeAll
    public static void initialize() {
        listOfStrings = List.of("A", "bunch", "of", "strings");
    }

    @Test
    public void joinTest() {
        assertEquals("A bunch of strings", join(listOfStrings, " "));
        assertEquals("A-bunch-of-strings", join(listOfStrings, "-"));
        assertEquals("Abunchofstrings", join(listOfStrings, ""));
    }

    @Test
    public void reverseTest() {
        assertEquals("gnirts", reverse("string"));
    }

    @Test
    public void validTest() {
        String validString = "A valid string";
        String emptyString = "";

        assertTrue(valid(validString));
        assertFalse(valid(emptyString));
    }

    @Test
    public void minTest() {
        assertEquals("A", min(listOfStrings));
        assertEquals("A", min("A", "bunch", "of", "strings"));
    }

    @Test
    public void maxTest() {
        assertEquals("strings", max(listOfStrings));
        assertEquals("strings", max("A", "bunch", "of", "strings"));
    }
}
