
import io.github.duckysmacky.utilimate.enums.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.github.duckysmacky.utilimate.collections.MapUtils.*;
import static org.junit.jupiter.api.Assertions.*;

public class MapUtilsTest {
    private static Map<String, Integer> unsortedValueMap;
    private static Map<Integer, String> unsortedKeyMap;


    @BeforeAll
    public static void initialize() {
        unsortedValueMap = Map.of(
                "Bigger", 4,
                "Smallest", 1,
                "Biggest", 5,
                "Middle", 3,
                "Smaller", 2
        );
        unsortedKeyMap = Map.of(
            4, "Bigger",
            1, "Smallest",
            5, "Biggest",
            3, "Middle",
            2, "Smaller"
        );
    }

    @Test
    public void sortByValueTest() {
        Map<String, Integer> ascendingMap = Map.of(
                "Smallest", 1,
                "Smaller", 2,
                "Middle", 3,
                "Bigger", 4,
                "Biggest", 5
        );
        Map<String, Integer> descendingMap = Map.of(
                "Biggest", 5,
                "Bigger", 4,
                "Middle", 3,
                "Smaller", 2,
                "Smallest", 1
        );

        assertEquals(ascendingMap, sortByValue(unsortedValueMap, Order.ASCENDING));
        assertEquals(descendingMap, sortByValue(unsortedValueMap, Order.DESCENDING));
    }

    @Test
    public void sortByKeyTest() {
        Map<Integer, String> ascendingMap = Map.of(
            1, "Smallest",
            2, "Smaller",
            3, "Middle",
            4, "Bigger",
            5, "Biggest"
        );
        Map<Integer, String> descendingMap = Map.of(
            5, "Biggest",
            4, "Bigger",
            3, "Middle",
            2, "Smaller",
            1, "Smallest"
        );

        assertEquals(ascendingMap, sortByKey(unsortedKeyMap, Order.ASCENDING));
        assertEquals(descendingMap, sortByKey(unsortedKeyMap, Order.DESCENDING));
    }
}
