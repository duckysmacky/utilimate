
import io.github.duckysmacky.utilimate.enums.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.github.duckysmacky.utilimate.collections.MapUtils.*;
import static org.junit.jupiter.api.Assertions.*;

// TODO - improve tests
public class MapUtilsTest {
    @Test
    public void sortKeyTest() {
        Map<Integer, String> unsortedKeyMap = Map.of(
            4, "Bigger",
            1, "Smallest",
            5, "Biggest",
            3, "Middle",
            2, "Smaller"
        );
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

        assertEquals(ascendingMap, sortKey(unsortedKeyMap, Order.ASCENDING));
        assertEquals(descendingMap, sortKey(unsortedKeyMap, Order.DESCENDING));
    }

    @Test
    public void sortValueTest() {
        Map<String, Integer> unsortedValueMap = Map.of(
            "Bigger", 4,
            "Smallest", 1,
            "Biggest", 5,
            "Middle", 3,
            "Smaller", 2
        );
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

        assertEquals(ascendingMap, sortValue(unsortedValueMap, Order.ASCENDING));
        assertEquals(descendingMap, sortValue(unsortedValueMap, Order.DESCENDING));
    }

    @Test
    public void invertTest() {
        Map<String, Integer> normalMap = Map.of(
            "one", 1,
            "two", 2,
            "three", 3
        );
        Map<String, Integer> repeatedMap = Map.of(
            "a", 1,
            "b", 2,
            "c", 3,
            "d", 2,
            "e", 5
        );
        Map<Integer, String> invertedNormalMap = Map.of(
            1, "one",
            2, "two",
            3, "three"
        );
        Map<Integer, String> invertedRepeatedMap = Map.of(
            1, "a",
            2, "b",
            3, "c",
            5, "e"
        );

        assertEquals(invertedNormalMap, invert(normalMap));
        assertEquals(invertedRepeatedMap, invert(repeatedMap));
    }

    @Test
    public void mergeTest() {
        Map<String, Integer> mergedMap = Map.of(
            "a", 1, "b", 2,
            "c", 3, "d", 4,
            "e", 5, "f", 6
        );
        Map<String, Integer> repeatedMergedMap = Map.of(
            "a", 1, "b", 2,
            "c", 3,
            "e", 5, "d", 6
        );

        assertEquals(mergedMap, merge(
            Map.of("a", 1, "b", 2),
            Map.of("c", 3, "d", 4),
            Map.of("e", 5, "f", 6)
        ));
        assertEquals(repeatedMergedMap, merge(
            Map.of("a", 1, "b", 2),
            Map.of("c", 3, "d", 4),
            Map.of("e", 5, "d", 6)
        ));
    }

    @Test
    public void filterKeyTest() {
        // TODO
    }

    @Test
    public void filterValueTest() {
        // TODO
    }
}
