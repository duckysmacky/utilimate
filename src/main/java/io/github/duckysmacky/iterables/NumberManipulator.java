package io.github.duckysmacky.iterables;

/**
 * A container class for variety of useful functions (which are mostly just shortcuts to existing functionality) to
 * manipulate numbers and number iterables
 */
public class NumberManipulator {

    /* TODO:
     - Rename class to something better dummy (AGAIN)
     - All() - Add Javadoc
     - Any() - Add Javadoc
     - Max() and Min() for string lengths? could be fun
     */

    /**
     * A simple method which returns the biggest number in an iterable of numbers
     * @param iterable any iterable of numbers
     * @return float biggest value
     */
    public static <T extends Number> Number max(Iterable<T> iterable) {
        float biggest = Float.MIN_VALUE;

        for (T value : iterable) {
            if (value.floatValue() > biggest) {
                biggest = value.floatValue();
            }
        }

        return biggest;
    }

    /**
     * A simple method which returns the biggest number from given numbers
     * @param numbers numbers to compare
     * @return float biggest value
     */
    public static <T extends Number> Number max(T... numbers) {
        float biggest = Float.MIN_VALUE;

        for (T value : numbers) {
            if (value.floatValue() > biggest) {
                biggest = value.floatValue();
            }
        }

        return biggest;
    }

    /**
     * A simple method which returns the smallest number in an iterable of numbers
     * @param iterable any iterable of numbers
     * @return float smallest value
     */
    public static <T extends Number> Number min(Iterable<T> iterable) {
        float smallest = Float.MAX_VALUE;

        for (T value : iterable) {
            if (value.floatValue() < smallest) {
                smallest = value.floatValue();
            }
        }

        return smallest;
    }

    /**
     * A simple method which returns the smallest number from given numbers
     * @param numbers numbers to compare
     * @return float smallest value
     */
    public static <T extends Number> Number min(T... numbers) {
        float smallest = Float.MAX_VALUE;

        for (T value : numbers) {
            if (value.floatValue() < smallest) {
                smallest = value.floatValue();
            }
        }

        return smallest;
    }

    /**
     * A simple method which returns the sum of all numbers in an iterable
     * @param iterable any iterable of numbers
     * @return float sum of numbers
     */
    public static <T extends Number> Number sum(Iterable<T> iterable) {
        float sum = 0f;

        for (T value : iterable) {
            sum += value.floatValue();
        }

        return sum;
    }

    /**
     * A simple method which returns the sum of all given numbers
     * @param numbers numbers to sum
     * @return float sum of numbers
     */
    public static <T extends Number> Number sum(T... numbers) {
        float sum = 0f;

        for (T num : numbers) { sum += num.floatValue(); }

        return sum;
    }

    /**
     * A simple method which checks if <b>all</b> values in an iterable are true or not null
     * @param iterable iterable of any values
     * @return {@code true} if all values are valid (true or not null)
     */
    public static <T> boolean all(Iterable<T> iterable) {
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
     * A simple method which checks if <b>any</b> value in an iterable is true or not null
     * @param iterable iterable of any values
     * @return {@code true} if all values are valid (true or not null)
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
