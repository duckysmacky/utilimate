package io.github.duckysmacky.iterables;

import java.util.ArrayList;
import java.util.List;

public class IterableManipulator {

    /* TODO:
     - Rename class to something better dummy
     - All() - Add Javadoc
     - Any() - Add Javadoc
     - Filter()
     - Map()
     - Max() and Min() for string lengths? could be fun
     */

    public IterableManipulator() {

    }

    /**
     * A method which returns the biggest number in an iterable of numbers <i>as a float value</i>
     * @param iterable iterable with number values
     * @return float biggest value
     */
    public <T extends Number> Number max(Iterable<T> iterable) {
        float biggest = Float.MIN_VALUE;

        for (T value : iterable) {
            if (value.floatValue() > biggest) {
                biggest = value.floatValue();
            }
        }

        return biggest;
    }

    /**
     * A method which returns the smallest number in an iterable of numbers <i>as a float value</i>
     * @param iterable iterable with number values
     * @return float smallest value
     */
    public <T extends Number> Number min(Iterable<T> iterable) {
        float smallest = Float.MAX_VALUE;

        for (T value : iterable) {
            if (value.floatValue() < smallest) {
                smallest = value.floatValue();
            }
        }

        return smallest;
    }

    /**
     *
     * @param iterable iterable with number values
     * @return float value (sum of all values in an iterable)
     */
    public <T extends Number> Number sum(Iterable<T> iterable) {
        float sum = 0f;

        for (T value : iterable) {
            sum += value.floatValue();
        }

        return sum;
    }

    /**
     * @param iterable iterable
     * @return {@code true} if all values are true
     */
    public <T> boolean all(Iterable<T> iterable) {
        for (T value : iterable) {
            if (value != null) {
                if (value instanceof Number) {
                    Number number = (Number) value;
                    if (number.intValue() == 0) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * @param iterable iterable
     * @return {@code true} if any of the values are true
     */
    public <T> boolean any(Iterable<T> iterable) {
        for (T value : iterable) {
            if (value != null) {
                if (value instanceof Number) {
                    Number number = (Number) value;
                    if (number.intValue() != 0) {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }

        return false;
    }
}
