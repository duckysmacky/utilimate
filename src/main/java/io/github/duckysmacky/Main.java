package io.github.duckysmacky;

import io.github.duckysmacky.iterables.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        IterableManipulator im = new IterableManipulator();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(-100, 100));
        }

        List<Integer> bools = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            bools.add(random.nextInt(0, 2));
        }

        System.out.println(numbers);
        System.out.println(new Sum(numbers));
    }
}