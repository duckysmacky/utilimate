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
     * Counts how many times each unique value appears in a given list
     * @param list list of values
     * @param <T> value
     * @return {@code Map} containing key-value pairs of each value and number of its occurrences
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

    // TODO - add findMostCommon function
}
