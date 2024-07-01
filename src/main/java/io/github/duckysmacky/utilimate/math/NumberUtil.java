package io.github.duckysmacky.utilimate.math;

/**
 * <p> Utility class providing static methods for common numerical operations.
 * Includes methods for finding certain values, manipulating them and checking them.
 * <p> All methods within the class are static and can be used right out of the box.
 */
public final class NumberUtil {
    private NumberUtil() {}

    /**
     * Finds the smallest value within given number varargs
     * @param numbers numbers to compare
     * @param <T> value extends number
     * @return {@code Number} smallest value
     */
    @SafeVarargs
    public static <T extends Number> Number min(T... numbers) {
        float smallest = Float.MAX_VALUE;
        for (T value : numbers) if (value.floatValue() < smallest) smallest = value.floatValue();
        return smallest;
    }

    /**
     * Finds the biggest value within given number varargs
     * @param numbers numbers to compare
     * @param <T> value extends number
     * @return {@code Number} biggest value
     */
    @SafeVarargs
    public static <T extends Number> Number max(T... numbers) {
        float biggest = Float.MIN_VALUE;
        for (T value : numbers) if (value.floatValue() > biggest) biggest = value.floatValue();
        return biggest;
    }

    // TODO - max() and min() for string lengths
}
