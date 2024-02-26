package io.github.duckysmacky.iterables;

public class Min extends Number {
    private final Number number;

    public <T extends Number> Min(Iterable<T> iterable) {
        float smallest = Float.MAX_VALUE;

        for (T value : iterable) {
            if (value.floatValue() < smallest) {
                smallest = value.floatValue();
            }
        }

        this.number = smallest;
    }

    @Override
    public String toString() {
        return number.toString();
    }

    /**
     * Returns the value of the specified number as an {@code int}.
     *
     * @return the numeric value represented by this object after conversion
     * to type {@code int}.
     */
    @Override
    public int intValue() {
        return number.intValue();
    }

    /**
     * Returns the value of the specified number as a {@code long}.
     *
     * @return the numeric value represented by this object after conversion
     * to type {@code long}.
     */
    @Override
    public long longValue() {
        return number.longValue();
    }

    /**
     * Returns the value of the specified number as a {@code float}.
     *
     * @return the numeric value represented by this object after conversion
     * to type {@code float}.
     */
    @Override
    public float floatValue() {
        return number.floatValue();
    }

    /**
     * Returns the value of the specified number as a {@code double}.
     *
     * @return the numeric value represented by this object after conversion
     * to type {@code double}.
     */
    @Override
    public double doubleValue() {
        return number.doubleValue();
    }
}
