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
     * Finds the smallest value in a given collection
     * @param collection collection of numbers
     * @param <T> value extends number
     * @return biggest number value
     */
    // TODO - Separate decimal and whole numbers
    public static <T extends Number> Number min(Collection<T> collection) {
        float smallest = Float.MAX_VALUE;
        for (T number : collection) if (number.floatValue() < smallest) smallest = number.floatValue();
        return smallest;
    }

    /**
     * Finds the biggest value in a given collection
     * @param collection collection of numbers
     * @param <T> value extends number
     * @return biggest number value
     */
    // TODO - Separate decimal and whole numbers
    public static <T extends Number> Number max(Collection<T> collection) {
        float biggest = Float.MIN_VALUE;
        for (T number : collection) if (number.floatValue() > biggest) biggest = number.floatValue();
        return biggest;
    }

    /**
     * Finds the sum of all values in a given collection
     * @param collection collection of numbers
     * @param <T> value extends number
     * @return sum of all values
     */
    public static <T extends Number> Number sum(Collection<T> collection) {
        float sum = 0f;
        for (Number value : collection) sum += value.floatValue();
        return sum;
    }

    /**
     * Checks values in a collection for being valid (true or not null)
     * @param collection collection of values
     * @param <T> value
     * @return {@code boolean} whether all values are valid
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
     * Checks for at least one value in a collection being valid (true or not null)
     * @param collection collection of values
     * @param <T> value
     * @return {@code boolean} whether any value is valid
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
