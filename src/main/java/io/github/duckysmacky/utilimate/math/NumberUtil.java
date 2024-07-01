package io.github.duckysmacky.utilimate.math;

/**
 * <p> Static container class which has methods for easier workflow with multiple numbers
 * as well as useful number manipulations.
 * <p> All methods within the class are static and can be used right out of the box.
 */
@SuppressWarnings("WrapperTypeMayBePrimitive")
public final class NumberUtil {

    /**
     * Returns the biggest value from given numbers
     * @param numbers numbers to compare
     * @return biggest value
     */
    @SafeVarargs
    public static <T extends Number> Number max(T... numbers) {
        Float biggest = Float.MIN_VALUE;
        for (T value : numbers) if (value.floatValue() > biggest) biggest = value.floatValue();
        return biggest;
    }

    /**
     * Returns the smallest value from given numbers
     * @param numbers numbers to compare
     * @return smallest value
     */
    @SafeVarargs
    public static <T extends Number> Number min(T... numbers) {
        Float smallest = Float.MAX_VALUE;
        for (T value : numbers) if (value.floatValue() < smallest) smallest = value.floatValue();
        return smallest;
    }

    // TODO - Max() and Min() for string lengths
}
