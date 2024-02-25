package io.github.duckysmacky.iterables;

public class IterableManipulator {

    /* TODO:
     - Rename class to something better dummy
     - Sum()
     - All()
     - Any()
     - Filter()
     - Map()
     - Max() and Min() for string lengths? could be fun
     */

    public IterableManipulator() {

    }

    /**
     * A method which returns the biggest number in an iterable of numbers <i>as a float value</i>
     */
    @SuppressWarnings("WrapperTypeMayBePrimitive")
    public <T extends Number> Number max(Iterable<T> iterable) {
        Float biggest = Float.MIN_VALUE;

        for (T value : iterable) {
            if (value.floatValue() > biggest) {
                biggest = value.floatValue();
            }
        }

        return biggest;
    }

    /**
     * A method which returns the smallest number in an iterable of numbers <i>as a float value</i>
     */
    @SuppressWarnings("WrapperTypeMayBePrimitive")
    public <T extends Number> Number min(Iterable<T> iterable) {
        Float smallest = Float.MAX_VALUE;

        for (T value : iterable) {
            if (value.floatValue() < smallest) {
                smallest = value.floatValue();
            }
        }

        return smallest;
    }
}
