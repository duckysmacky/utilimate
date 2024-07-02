package io.github.duckysmacky.utilimate.strings;

import java.util.Collection;
import java.util.StringJoiner;

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
}
