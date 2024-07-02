package io.github.duckysmacky.utilimate.collections;

import io.github.duckysmacky.utilimate.enums.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/** <p> Utility class providing static methods for common operations on lists.
 * Includes methods for filtering, mapping, reversing lists, and more.
 * <p> All methods within the class are static and can be used right out of the box.
 */
public final class ListUtils {
    private ListUtils() {}

    /** Counts how many times each unique value appears in a given list
     * @param list list of values
     * @param <T> value
     * @return {@code Map} map containing key-value pairs of each value and number of its occurrences
     * @since 0.1.0
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

    /** Counts how many times each unique value appears in a given list and sorts them based on a given order
     * @param list list of values
     * @param <T> value
     * @param order order to sort the map by (ascending/descending)
     * @return {@code Map} sorted map containing key-value pairs of each value and number of its occurrences
     * @since 0.2.0
     */
    public static <T> Map<T, Integer> countOccurrences(List<T> list, Order order) {
        Map<T, Integer> occurrences = new HashMap<>();
        for (T item : list) {
            occurrences.put(
                item,
                occurrences.get(item) != null
                    ? occurrences.get(item) + 1
                    : 1
            );
        }
        return MapUtils.sortByValue(occurrences, order);
    }

    /** Finds the value which appears the most amount of times in a given list
     * @param list list of values
     * @param <T> value
     * @return {@code Entry} an entry containing most common value (key) and its occurrences (value)
     * @since 0.2.0
     */
    public static <T> Map.Entry<T, Integer> findMostCommon(List<T> list) {
        // Count occurrences
        Map<T, Integer> occurrences = new HashMap<>();
        for (T item : list) {
            occurrences.put(
                item,
                occurrences.get(item) != null
                    ? occurrences.get(item) + 1
                    : 1
            );
        }
        // Get most common
        Map.Entry<T, Integer> mostCommon = null;
        int biggestOccurrence = 0;
        for (Map.Entry<T, Integer> entry : occurrences.entrySet()) {
            if (entry.getValue() > biggestOccurrence) {
                mostCommon = entry;
                biggestOccurrence = entry.getValue();
            }
        }
        return mostCommon;
    }

    /** Finds the value which appears the least amount of times in a given list
     * @param list list of values
     * @param <T> value
     * @return {@code Entry} an entry containing least common (key) and its occurrences (value)
     * @since 0.2.0
     */
    public static <T> Map.Entry<T, Integer> findLeastCommon(List<T> list) {
        // Count occurrences
        Map<T, Integer> occurrences = new HashMap<>();
        for (T item : list) {
            occurrences.put(
                item,
                occurrences.get(item) != null
                    ? occurrences.get(item) + 1
                    : 1
            );
        }
        // Get least common
        Map.Entry<T, Integer> leastCommon = null;
        int smallestOccurrence = Integer.MAX_VALUE;
        for (Map.Entry<T, Integer> entry : occurrences.entrySet()) {
            if (entry.getValue() < smallestOccurrence) {
                leastCommon = entry;
                smallestOccurrence = entry.getValue();
            }
        }
        return leastCommon;
    }
}
