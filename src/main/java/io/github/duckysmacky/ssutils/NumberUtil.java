package io.github.duckysmacky.ssutils;

// TODO - add class Javadoc
public final class NumberUtil {

    /**
     * Returns the biggest value from given numbers
     * @param numbers numbers to compare
     * @return biggest value
     */
    @SuppressWarnings({"unchecked", "WrapperTypeMayBePrimitive"})
    @SafeVarargs
    public static <T extends Number> T max(T... numbers) {
        Float biggest = Float.MIN_VALUE;
        for (T value : numbers) if (value.floatValue() > biggest) biggest = value.floatValue();
        return (T) biggest;
    }

    /**
     * Returns the smallest value from given numbers
     * @param numbers numbers to compare
     * @return smallest value
     */
    @SuppressWarnings({"unchecked", "WrapperTypeMayBePrimitive"})
    @SafeVarargs
    public static <T extends Number> T min(T... numbers) {
        Float smallest = Float.MAX_VALUE;
        for (T value : numbers) if (value.floatValue() < smallest) smallest = value.floatValue();
        return (T) smallest;
    }

    // TODO - Max() and Min() for string lengths
}
