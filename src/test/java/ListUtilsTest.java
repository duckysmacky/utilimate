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
    private static List<Integer> numberList;

    @BeforeAll
    public static void initialize() {
        nameList = List.of("Bob", "John", "Alex", "Bob", "Alex", "bob", "Bob", "John", "Alex", "Bob");
        numberList = List.of(1, 2, 3, 4, 5);
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

    @Test
    public void filterTest() {
        List<String> filteredNames = List.of("Bob", "Bob", "bob", "Bob", "Bob");

        assertEquals(filteredNames, filter(nameList, name -> name.equalsIgnoreCase("bob")));
    }

    @Test
    public void mapTest() {
        List<String> mappedNames = List.of("BOB", "JOHN", "ALEX", "BOB", "ALEX", "BOB", "BOB", "JOHN", "ALEX", "BOB");

        assertEquals(mappedNames, map(nameList, String::toUpperCase));
    }

    @Test
    public void reduceTest() {
        int sumOfNumbers = 1 + 2 + 3 + 4 + 5;

        assertEquals(sumOfNumbers, reduce(numberList, Integer::sum));
    }

    @Test
    public void uniqueTest() {
        List<String> uniqueNames = List.of("Alex", "Bob", "bob", "John");

        assertEquals(uniqueNames, unique(nameList));
    }

    @Test
    public void flattenTest() {
        List<List<Integer>> listOfListOfNumbers = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9));
        List<Integer> flattenedList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        assertEquals(flattenedList, flatten(listOfListOfNumbers));
    }
}
