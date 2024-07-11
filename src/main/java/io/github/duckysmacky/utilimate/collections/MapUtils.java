package io.github.duckysmacky.utilimate.collections;

import io.github.duckysmacky.utilimate.enums.Order;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** <p> Utility class providing static methods for common operations on maps.
 * Includes methods for filtering, sorting by key or value, merging maps, and more.
 * <p> All methods within the class are static and can be used right out of the box.
 */
public final class MapUtils {
    private MapUtils() {}

    /** Sorts a given map by its values based on a given order
     * @param inputMap map to be sorted
     * @param order order to sort the map by (ascending/descending)
     * @param <K> any key
     * @param <V> comparable value
     * @return {@code HashMap} sorted map
     */
    public static <K, V extends Comparable<? super V>> HashMap<K, V> sortValue(Map<K, V> inputMap, Order order) {
        List<Entry<K, V>> entryList = new ArrayList<>(inputMap.entrySet());
        HashMap<K, V> sortedMap = new HashMap<>();
        switch (order) {
            case ASCENDING -> entryList.sort(Entry.comparingByValue());
            case DESCENDING -> entryList.sort(Collections.reverseOrder(Entry.comparingByValue()));
        }
        for (Entry<K, V> entry : entryList) sortedMap.put(entry.getKey(), entry.getValue());
        return sortedMap;
    }

    /** Sorts a given map by its keys based on a given order
     * @param inputMap map to be sorted
     * @param order order to sort the map by (ascending/descending)
     * @param <K> comparable key
     * @param <V> any value
     * @return {@code HashMap} sorted map
     */
    public static <K extends Comparable<? super K>, V> HashMap<K, V> sortKey(Map<K, V> inputMap, Order order) {
        List<Entry<K, V>> entryList = new ArrayList<>(inputMap.entrySet());
        HashMap<K, V> sortedMap = new HashMap<>();
        switch (order) {
            case ASCENDING -> entryList.sort(Entry.comparingByKey());
            case DESCENDING -> entryList.sort(Collections.reverseOrder(Entry.comparingByKey()));
        }
        for (Entry<K, V> entry : entryList) sortedMap.put(entry.getKey(), entry.getValue());
        return sortedMap;
    }

    /** Inverts keys and values of a map (assuming values are unique, else overrides old value)
     * @param map map to invert
     * @param <K> key type
     * @param <V> value type
     * @return {@code Map} inverted map (value-key pairs of original key-value pairs)
     * @since 0.2.0
     */
    public static <K, V> Map<V, K> invert(Map<K, V> map) {
        List<Entry<K, V>> entryList = new ArrayList<>(map.entrySet());
        Map<V, K> invertedMap = new HashMap<>();
        for (Entry<K, V> entry : entryList) invertedMap.put(entry.getValue(), entry.getKey());
        return invertedMap;
    }

    /** Merges multiple maps together by adding all the entries into a single one (assuming all the keys are unique,
     * else overrides old key)
     * @param maps maps to merge
     * @param <K> key type
     * @param <V> value type
     * @return {@code Map} merged map
     * @since 0.2.0
     */
    @SafeVarargs
    public static <K, V> Map<K, V> merge(Map<K, V>... maps) {
        Map<K, V> mergedMap = new HashMap<>();
        for (Map<K, V> map : maps) mergedMap.putAll(map);
        return mergedMap;
    }

    /** Filters a given map by its keys based on a predicate
     * @param map map to filter
     * @param predicate condition for keys to filter based on
     * @param <K> key type
     * @param <V> value type
     * @return {@code Map} filtered map by keys
     */
    public static <K, V> Map<K, V> filterKey(Map<K, V> map, Predicate<K> predicate) {
        Map<K, V> filteredMap = new HashMap<>();
        Set<K> filteredKeys = map.keySet().stream()
            .filter(predicate)
            .collect(Collectors.toSet());
        for (K key : filteredKeys) filteredMap.put(key, map.get(key));
        return filteredMap;
    }

    /** Filters a given map by its values based on a predicate
     * @param map map to filter
     * @param predicate condition for values to filter based on
     * @param <K> key type
     * @param <V> value type
     * @return {@code Map} filtered map by values
     */
    public static <K, V> Map<K, V> filterValue(Map<K, V> map, Predicate<V> predicate) {
        Map<K, V> filteredMap = new HashMap<>();
        List<V> filteredValues = map.values().stream()
            .filter(predicate)
            .toList();
        for (Entry<K, V> entry : map.entrySet())
            if (filteredValues.contains(entry.getValue()))
                filteredMap.put(entry.getKey(), entry.getValue());
        return filteredMap;
    }
}
