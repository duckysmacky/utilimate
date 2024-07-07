import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.github.duckysmacky.utilimate.strings.StringUtils.*;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("SpellCheckingInspection")
public class StringUtilsTest {
    private static List<String> listOfStrings;
    private static String characters;

    @BeforeAll
    public static void initialize() {
        listOfStrings = List.of("A", "bunch", "of", "strings");
        characters = "abbcccddddeeeee";
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

        // True
        assertTrue(valid(validString));

        // False
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

    @Test
    public void countTest() {
        Map<Character, Integer> characterOccurrences = Map.of(
            'a', 1,
            'b', 2,
            'c', 3,
            'd', 4,
            'e', 5
        );

        assertEquals(characterOccurrences, count(characters));
    }

    @Test
    public void findMostCommonTest() {
        Map.Entry<Character, Integer> mostCommonCharacter = Map.entry('e', 5);

        assertEquals(mostCommonCharacter, findMostCommon(characters));
    }

    @Test
    public void findLeastCommonTest() {
        Map.Entry<Character, Integer> leastCommonCharacter = Map.entry('a', 1);

        assertEquals(leastCommonCharacter, findLeastCommon(characters));
    }
}
