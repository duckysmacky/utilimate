package io.github.duckysmacky.utilimate.collections;

import java.util.Collection;

/**
 * <p> Utility class providing static methods for common operations on collections.
 * Includes methods for filtering, mapping, and checking conditions across any type of collection.
 * <p> All methods within the class are static and can be used right out of the box.
 */
public final class CollectionUtils {
    private CollectionUtils() {}

    /**
     * Returns the biggest value in a collection
     * @param collection collection of numbers
     * @return biggest value
     */
    // TODO - Separate decimal and whole numbers
    public static <T extends Number> Number max(Collection<T> collection) {
        float biggest = Float.MIN_VALUE;
        for (T number : collection) if (number.floatValue() > biggest) biggest = number.floatValue();
        return biggest;
    }

    /**
     * Returns the biggest value in a collection
     * @param collection collection of numbers
     * @return biggest value
     */
    // TODO - Separate decimal and whole numbers
    public static <T extends Number> Number min(Collection<T> collection) {
        float smallest = Float.MAX_VALUE;
        for (T number : collection) if (number.floatValue() < smallest) smallest = number.floatValue();
        return smallest;
    }

    /**
     * Returns the sum of all values in a collection
     * @param collection collection containing numbers
     * @return sum of numbers
     */
    public static <T extends Number> Number sum(Collection<T> collection) {
        float sum = 0f;
        for (Number value : collection) sum += value.floatValue();
        return sum;
    }

    /**
     * Checks if all values in a collection are valid (true or not null)
     * @param collection collection of values
     * @return {@code true} if all values are valid
     */
    public static <T> boolean all(Collection<T> collection) {
        for (T value : collection) {
            if (value == null
                || value.equals(false)
                || value instanceof Number number
                && number.intValue() == 0
            ) return false;
        }
        return true;
    }

    /**
     * Checks if any value in a collection is valid (true or not null)
     * @param collection collection of values
     * @return {@code true} if any value is valid
     */
    public static <T> boolean any(Collection<T> collection) {
        for (T value : collection) {
            if (value.equals(true)
                || value instanceof Number number
                && number.intValue() == 1
            ) return true;
        }
        return false;
    }
}
