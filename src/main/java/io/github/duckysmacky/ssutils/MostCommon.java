package io.github.duckysmacky.ssutils;

import java.util.*;

/**
 * A class which holds a {@link Map} of keys (items in a passed iterable) and values (occurrences of those items)
 * <p>E.g.: An {@link ArrayList} containing a list of names <i>["Alex", "James", "Alex"]</i> will return
 * <i>{"Alex"=2, "James"=1}</i></p>
 */
public class MostCommon implements Map<Object, Integer> {
    final Map<Object, Integer> commons;

    public MostCommon(Iterable<?> iterable) {
        commons = mostCommon(iterable);
    }

    // TODO: Add method overloading for options like order and other

    private Map<Object, Integer> mostCommon(Iterable<?> iterable) {
        Map<Object, Integer> occurrences = new HashMap<>();

        for (Object item : iterable) {
            occurrences.put(item, occurrences.get(item) != null ? occurrences.get(item) + 1 : 1);
        }

        return occurrences;
    }

    @Override
    public String toString() {
        return commons.toString();
    }

    @Override
    public int size() {
        return commons.size();
    }

    @Override
    public boolean isEmpty() {
        return commons.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return commons.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return commons.containsValue(value);
    }

    @Override
    public Integer get(Object key) {
        return commons.get(key);
    }

    @Override
    public Integer put(Object key, Integer value) {
        return null;
    }

    @Override
    public Integer remove(Object key) {
        return commons.remove(key);
    }

    @Override
    public void putAll(Map<?, ? extends Integer> m) {
    }

    @Override
    public void clear() {

    }

    @Override
    public Set<Object> keySet() {
        return commons.keySet();
    }

    @Override
    public Collection<Integer> values() {
        return commons.values();
    }

    @Override
    public Set<Entry<Object, Integer>> entrySet() {
        return commons.entrySet();
    }
}
