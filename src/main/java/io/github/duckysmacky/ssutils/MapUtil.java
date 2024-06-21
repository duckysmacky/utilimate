package io.github.duckysmacky.ssutils;

import io.github.duckysmacky.ssutils.enums.Order;

import java.util.*;

// TODO - add class Javadoc
public final class MapUtil {

    // TODO - add method Javadoc
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> inputMap, Order order) {
        List<Map.Entry<K, V>> entryList = new ArrayList<>(inputMap.entrySet());
        Map<K, V> sortedMap = new HashMap<>();

        switch (order) {
            case ASCENDING -> entryList.sort(Map.Entry.comparingByValue());
            case DESCENDING -> entryList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        }

        for (Map.Entry<K, V> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
