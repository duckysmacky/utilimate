package io.github.duckysmacky.ssutils;

import io.github.duckysmacky.ssutils.enums.Order;

import java.util.*;

/**
 * <p> Static container class which has methods for manipulating, finding
 * and sorting values in maps.
 * <p> All methods within the class are static and can be used right out of the box.
 */
public final class MapUtil {

    /**
     * Sorts a map by its values based on given order
     * @param inputMap map to be sorted
     * @param order order to sort the map by
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
}
