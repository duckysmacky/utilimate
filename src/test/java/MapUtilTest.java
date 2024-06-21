
import io.github.duckysmacky.ssutils.enums.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.github.duckysmacky.ssutils.MapUtil.*;
import static org.junit.jupiter.api.Assertions.*;

public class MapUtilTest {
    private static Map<String, Integer> unsortedMap;

    @BeforeAll
    public static void initialize() {
        unsortedMap = Map.of(
                "Bigger", 4,
                "Smallest", 1,
                "Biggest", 5,
                "Middle", 3,
                "Smaller", 2
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

        assertEquals(sortByValue(unsortedMap, Order.ASCENDING), ascendingMap);
        assertEquals(sortByValue(unsortedMap, Order.DESCENDING), descendingMap);
    }
}
