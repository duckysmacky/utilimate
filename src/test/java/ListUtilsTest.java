import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.github.duckysmacky.utilimate.collections.ListUtils.*;
import static org.junit.jupiter.api.Assertions.*;

public class ListUtilsTest {
    private static List<String> nameList;

    @BeforeAll
    public static void initialize() {
        nameList = Arrays.asList("Bob", "John", "Alex", "Bob", "Alex", "bob", "Bob", "John", "Alex", "Bob");
    }

    @Test
    public void countOccurrencesTest() {
        Map<String, Integer> mostCommonNames = Map.of(
                "Bob", 4,
                "Alex", 3,
                "John", 2,
                "bob", 1
        );

        assertEquals(mostCommonNames, countOccurrences(nameList));
    }
}
