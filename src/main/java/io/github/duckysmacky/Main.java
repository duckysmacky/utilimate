package io.github.duckysmacky;

import io.github.duckysmacky.iterables.MostCommon;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);

        String[] names = new String[]{
          "Alex", "James", "Alex", "E", "Jame", "Steve", "Alex", "steve", "Steve"
        };


        Map<Object, Integer> common = new MostCommon(Arrays.asList(names));

        System.out.println(new MostCommon(list));
        System.out.println(new MostCommon(List.of(names)));
        System.out.println(common);

    }
}