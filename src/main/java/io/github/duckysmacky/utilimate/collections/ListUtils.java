package io.github.duckysmacky.utilimate.collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p> Utility class providing static methods for common operations on lists.
 * Includes methods for filtering, mapping, reversing lists, and more.
 * <p> All methods within the class are static and can be used right out of the box.
 */
public final class ListUtils {
    private ListUtils() {}

    /**
     * Searches a list and finds number of occurrences for each value
     * @param list any list object
     * @return a hash map containing key-value pairs of each value and number of its occurrences
     */
    public static <T> Map<T, Integer> countOccurrences(List<T> list) {
        Map<T, Integer> occurrences = new HashMap<>();
        for (T item : list) {
            occurrences.put(
                item,
                occurrences.get(item) != null
                    ? occurrences.get(item) + 1
                    : 1
            );
        }
        return occurrences;
    }

    // TODO - add findMostCommon method
}
