package io.github.duckysmacky.ssutils;

import java.util.HashMap;
import java.util.Map;

// TODO - add class Javadoc
public final class ListUtil {

    /**
     * Returns the biggest value in an iterable
     * @param iterable iterable of numbers
     * @return biggest value
     */
    // TODO - Separate decimal and whole numbers
    @SuppressWarnings({"unchecked", "WrapperTypeMayBePrimitive"})
    public static <T extends Number> Number max(Iterable<T> iterable) {
        Float biggest = Float.MIN_VALUE;
        for (T number : iterable) if (number.floatValue() > biggest) biggest = number.floatValue();
        return biggest;
    }

    /**
     * Returns the biggest value in an iterable
     * @param iterable iterable of numbers
     * @return biggest value
     */
    // TODO - Separate decimal and whole numbers
    @SuppressWarnings({"unchecked", "WrapperTypeMayBePrimitive"})
    public static <T extends Number> Number min(Iterable<T> iterable) {
        Float smallest = Float.MAX_VALUE;
        for (T number : iterable) if (number.floatValue() < smallest) smallest = number.floatValue();
        return smallest;
    }

    /**
     * Returns the sum of all values in an iterable
     * @param iterable iterable of numbers
     * @return sum of numbers
     */
    @SuppressWarnings({"unchecked", "WrapperTypeMayBePrimitive"})
    public static <T extends Number> Number sum(Iterable<T> iterable) {
        Float sum = 0f;
        for (T value : iterable) sum += value.floatValue();
        return sum;
    }

    /**
     * Checks if all values in an iterable are valid (true or not null)
     * @param iterable iterable of values
     * @return {@code true} if all values are valid
     */
    public static <T> boolean all(Iterable<T> iterable) {
        for (T value : iterable) {
            if (
                    value == null ||
                    value.equals(false) ||
                    value instanceof Number number && number.intValue() == 0
            ) return false;
        }
        return true;
    }

    /**
     * Checks if any value in an iterable is valid (true or not null)
     * @param iterable iterable of values
     * @return {@code true} if any value is valid
     */
    public static <T> boolean any(Iterable<T> iterable) {
        for (T value : iterable) {
            if (
                    value.equals(true) ||
                    value instanceof Number number && number.intValue() == 1
            ) return true;
        }
        return false;
    }

    // TODO - add method Javadoc
    public static Map<Object, Integer> countOccurrences(Iterable<?> iterable) {
        Map<Object, Integer> occurrences = new HashMap<>();

        for (Object item : iterable) {
            occurrences.put(item, occurrences.get(item) != null
                    ? occurrences.get(item) + 1
                    : 1
            );
        }

        return occurrences;
    }

    // TODO - add findMostCommon method
}
