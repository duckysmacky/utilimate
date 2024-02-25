package io.github.duckysmacky;

import io.github.duckysmacky.iterables.IterableManipulator;
import io.github.duckysmacky.iterables.MostCommon;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        List<String> words = new ArrayList<>();
        Random random = new Random();
        IterableManipulator im = new IterableManipulator();

        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(-100, 100));
        }

        words.add("Apple");
        words.add("Something");
        words.add("Eh");

        System.out.println(numbers);
        System.out.println(im.max(numbers));
        System.out.println(im.min(numbers));
    }
}