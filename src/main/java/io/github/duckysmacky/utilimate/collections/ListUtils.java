package io.github.duckysmacky.utilimate.collections;

import io.github.duckysmacky.utilimate.enums.Order;

import java.util.*;
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
     * @param <T> list value type
     * @return {@code Map} map containing key-value pairs of each value and number of its occurrences
     * @since 0.1.0
     */
    public static <T> Map<T, Integer> count(List<T> list) {
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
     * @param <T> list value type
     * @param order order to sort the map by (ascending/descending)
     * @return {@code Map} sorted map containing key-value pairs of each value and number of its occurrences
     * @since 0.2.0
     */
    public static <T> Map<T, Integer> count(List<T> list, Order order) {
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
     * @param <T> list value type
     * @return {@code Entry} an entry containing most common value (key) and its occurrences (value)
     * @since 0.2.0
     */
    public static <T> Map.Entry<T, Integer> findMostCommon(List<T> list) {
        Map<T, Integer> occurrences = count(list);
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
     * @param <T> list value type
     * @return {@code Entry} an entry containing least common (key) and its occurrences (value)
     * @since 0.2.0
     */
    public static <T> Map.Entry<T, Integer> findLeastCommon(List<T> list) {
        Map<T, Integer> occurrences = count(list);
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

    /** Filters a given list based on a predicate
     * @param list list to filter
     * @param predicate condition to sort based on
     * @param <T> list value type
     * @return {@code List} sorted list
     * @since 0.2.0
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        return list.stream()
            .filter(predicate)
            .collect(Collectors.toList());
    }

    /** Applies a mapper function to each element in the given list
     * @param list list to map
     * @param mapper function to apply to each element
     * @param <T> list value type
     * @param <R> return value
     * @return {@code List} mapped list
     * @since 0.2.0
     */
    public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        return list.stream()
            .map(mapper)
            .collect(Collectors.toList());
    }

    /** Produces a single result from the given list using an accumulator function
     * @param list list to reduce
     * @param accumulator function that takes a partial result of the operation and the next element of the list
     * @param <T> list value type
     * @return {@code T} result value
     * @since 0.2.0
     */
    public static <T> T reduce(List<T> list, BinaryOperator<T> accumulator) {
        return list.stream()
            .reduce(accumulator)
            .orElse(null);
    }

    /** Removes duplicate values from a list
     * @param list list to remove duplicates from
     * @param <T> list value type
     * @return {@code List} list with only unique values
     * @since 0.2.0
     */
    public static <T> List<T> unique(List<T> list) {
        Set<T> set = new HashSet<>(list);
        List<T> uniqueList = new ArrayList<>(set);
        return uniqueList;
    }

    /** Flattens a list of lists into a single list
     * @param listOfLists list of lists to be flattened
     * @param <T> list value type
     * @return {@code List} flattened list
     * @since 0.2.0
     */
    public static <T> List<T> flatten(List<List<T>> listOfLists) {
        List<T> flattenedList = new ArrayList<>();
        for (List<T> list : listOfLists) flattenedList.addAll(list);
        return flattenedList;
    }

    /** Checks if all the values in a given list are the same
     * @param list list to check
     * @param <T> list value type
     * @return {@code boolean} whether all of the values in the list are equal
     * @since 0.2.0
     */
    public static <T> boolean same(List<T> list) {
        T originalValue = list.getFirst();
        for (T value : list) if (!value.equals(originalValue)) return false;
        return true;
    }


    /** Merges multiple lists together by adding all the values into a single one
     * @param lists lists to merge
     * @param <T> list value type
     * @return {@code List} merged list
     * @since 0.2.0
     */
    @SafeVarargs
    public static <T> List<T> merge(List<T>... lists) {
        List<T> mergedList = new ArrayList<>();
        for (List<T> list : lists) mergedList.addAll(list);
        return mergedList;
    }
}
