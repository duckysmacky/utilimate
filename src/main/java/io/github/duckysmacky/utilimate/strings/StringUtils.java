package io.github.duckysmacky.utilimate.strings;

import io.github.duckysmacky.utilimate.collections.MapUtils;
import io.github.duckysmacky.utilimate.enums.Order;

import java.util.*;

/** <p>Utility class providing static methods for common string manipulation operations.
 * Includes methods for changing, validating and getting info about strings.
 * <p> All methods within the class are static and can be used right out of the box.
 */
public final class StringUtils {
    private StringUtils() {}

    /** Joins a collection of strings into a single string with a specified delimiter
     * @param collection collection of strings
     * @param delimiter string to join with
     * @return {@code String} joined string
     * @since 0.2.0
     */
    public static String join(Collection<String> collection, String delimiter) {
        StringJoiner joiner = new StringJoiner(delimiter);
        for (String item : collection) joiner.add(item);
        return joiner.toString();
    }


    /** Reverses a given string
     * @param string string to reverse
     * @return {@code String} reversed string
     * @since 0.2.0
     */
    public static String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }


    /** Checks if a string is valid (not null or not empty)
     * @param string string to check
     * @return {@code boolean} is the string valid
     * @since 0.2.0
     */
    public static boolean valid(String string) {
        return !(string == null || string.isEmpty());
    }

    /** Finds the smallest string by length within given strings
     * @param strings strings to compare
     * @return {@code Number} shortest string
     * @since 0.2.0
     */
    public static String min(String... strings) {
        long maxLength = Long.MAX_VALUE;
        String smallest = "";
        for (String string : strings) {
            if (string.length() < smallest.length() || string.length() < maxLength) {
                smallest = string;
                maxLength = string.length();
            }
        }
        return smallest;
    }

    /** Finds the biggest string by length within given strings
     * @param strings strings to compare
     * @return {@code Number} longest string
     * @since 0.2.0
     */
    public static String max(String... strings) {
        long minLength = Long.MIN_VALUE;
        String biggest = "";
        for (String string : strings) {
            if (string.length() > biggest.length() || string.length() > minLength) {
                biggest = string;
                minLength = string.length();
            }
        }
        return biggest;
    }

    /** Finds the smallest string by length in a given collection
     * @param collection collection of strings
     * @return shortest string
     * @since 0.2.0
     */
    public static String min(Collection<String> collection) {
        long maxLength = Long.MAX_VALUE;
        String smallest = "";
        for (String string : collection) {
            if (string.length() < smallest.length() || string.length() < maxLength) {
                smallest = string;
                maxLength = string.length();
            }
        }
        return smallest;
    }

    /** Finds the biggest string by length in a given collection
     * @param collection collection of strings
     * @return longest string
     * @since 0.2.0
     */
    public static String max(Collection<String> collection) {
        long minLength = Long.MIN_VALUE;
        String biggest = "";
        for (String string : collection) {
            if (string.length() > biggest.length() || string.length() > minLength) {
                biggest = string;
                minLength = string.length();
            }
        }
        return biggest;
    }

    /** Finds the character which appears the most amount of times in a given string
     * @param string list of values
     * @return {@code Entry} an entry containing most common character (key) and its occurrences (value)
     * @since 0.2.0
     */
    public static Map.Entry<Character, Integer> findMostCommon(String string) {
        Map<Character, Integer> occurrences = count(string);
        Map.Entry<Character, Integer> mostCommon = null;
        int biggestOccurrence = 0;
        for (Map.Entry<Character, Integer> entry : occurrences.entrySet()) {
            if (entry.getValue() > biggestOccurrence) {
                mostCommon = entry;
                biggestOccurrence = entry.getValue();
            }
        }
        return mostCommon;
    }

    /** Finds the character which appears the least amount of times in a given string
     * @param string list of values
     * @return {@code Entry} an entry containing the least common character (key) and its occurrences (value)
     * @since 0.2.0
     */
    public static Map.Entry<Character, Integer> findLeastCommon(String string) {
        Map<Character, Integer> occurrences = count(string);
        Map.Entry<Character, Integer> leastCommon = null;
        int smallestOccurrence = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : occurrences.entrySet()) {
            if (entry.getValue() < smallestOccurrence) {
                leastCommon = entry;
                smallestOccurrence = entry.getValue();
            }
        }
        return leastCommon;
    }

    /** Counts how many times each character appears in a given string
     * @param string string
     * @return {@code Map} map containing key-value pairs of each character and number of its occurrences
     * @since 0.2.0
     */
    public static Map<Character, Integer> count(String string) {
        Map<Character, Integer> occurrences = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            occurrences.put(c, occurrences.get(c) != null ? occurrences.get(c) + 1 : 1);
        }
        return occurrences;
    }

    /** Counts how many times each character appears in a given string and sorts them based on a given order
     * @param string string
     * @param order order to sort the map by (ascending/descending)
     * @return {@code Map} map containing key-value pairs of each character and number of its occurrences
     * @since 0.2.0
     */
    public static Map<Character, Integer> count(String string, Order order) {
        Map<Character, Integer> occurrences = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            occurrences.put(c, occurrences.get(c) != null ? occurrences.get(c) + 1 : 1);
        }
        return MapUtils.sortByValue(occurrences, order);
    }
}
