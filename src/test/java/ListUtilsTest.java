import io.github.duckysmacky.utilimate.collections.MapUtils;
import io.github.duckysmacky.utilimate.enums.Order;
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
        Map<String, Integer> nameOccurrences = Map.of(
                "Bob", 4,
                "Alex", 3,
                "John", 2,
                "bob", 1
        );
        Map<String, Integer> ascendingNameOccurrences = MapUtils.sortByKey(nameOccurrences, Order.ASCENDING);
        Map<String, Integer> descendingNameOccurrences = MapUtils.sortByKey(nameOccurrences, Order.DESCENDING);

        assertEquals(nameOccurrences, countOccurrences(nameList));
        assertEquals(ascendingNameOccurrences, countOccurrences(nameList, Order.ASCENDING));
        assertEquals(descendingNameOccurrences, countOccurrences(nameList, Order.DESCENDING));
    }

    @Test
    public void findMostCommonTest() {
        Map.Entry<String, Integer> mostCommonName = Map.entry("Bob", 4);

        assertEquals(mostCommonName, findMostCommon(nameList));
    }

    @Test
    public void findLeastCommonTest() {
        Map.Entry<String, Integer> leastCommonName = Map.entry("bob", 1);

        assertEquals(leastCommonName, findLeastCommon(nameList));
    }
}
