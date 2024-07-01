package io.github.duckysmacky.utilimate.collections;

import io.github.duckysmacky.utilimate.enums.Order;

import java.util.*;

/**
 * <p> Utility class providing static methods for common operations on maps.
 * Includes methods for filtering, sorting by key or value, merging maps, and more.
 * <p> All methods within the class are static and can be used right out of the box.
 */
public final class MapUtils {

    /**
     * Sorts a map by its values based on a given order
     * @param inputMap map to be sorted
     * @param order order to sort the map by (ascending or descending)
     * @return sorted map
     * @param <K> key
     * @param <V> comparable value
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> inputMap, Order order) {
        List<Map.Entry<K, V>> entryList = new ArrayList<>(inputMap.entrySet());
        Map<K, V> sortedMap = new HashMap<>();
        switch (order) {
            case ASCENDING -> entryList.sort(Map.Entry.comparingByValue());
            case DESCENDING -> entryList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        }
        for (Map.Entry<K, V> entry : entryList) sortedMap.put(entry.getKey(), entry.getValue());
        return sortedMap;
    }

    /**
     * Sorts a map by its keys based on a given order
     * @param inputMap map to be sorted
     * @param order order to sort the map by (ascending or descending)
     * @return sorted map
     * @param <K> comparable key
     * @param <V> value
     */
    public static <K extends Comparable<? super K>, V> Map<K, V> sortByKey(Map<K, V> inputMap, Order order) {
        List<Map.Entry<K, V>> entryList = new ArrayList<>(inputMap.entrySet());
        Map<K, V> sortedMap = new HashMap<>();
        switch (order) {
            case ASCENDING -> entryList.sort(Map.Entry.comparingByKey());
            case DESCENDING -> entryList.sort(Collections.reverseOrder(Map.Entry.comparingByKey()));
        }
        for (Map.Entry<K, V> entry : entryList) sortedMap.put(entry.getKey(), entry.getValue());
        return sortedMap;
    }
}
