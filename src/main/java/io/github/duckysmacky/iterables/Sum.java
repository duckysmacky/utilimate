package io.github.duckysmacky.iterables;

public class Sum extends Number {
    private final Number number;

    public <T extends Number> Sum(Iterable<T> iterable) {
        float sum = 0f;

        for (T value : iterable) {
            sum += value.floatValue();
        }

        this.number = sum;
    }

    public <T extends Number> Sum(T... numbers) {
        float sum = 0f;

        for (T num : numbers) { sum += num.floatValue(); }

        this.number = sum;
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
