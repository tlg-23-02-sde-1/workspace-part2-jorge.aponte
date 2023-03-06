package com.crunch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class RadishSortTest {

    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();

        radishes.add(new Radish("red", 1.1, 2.1, 0));
        radishes.add(new Radish("pink", 3.5, 0.0, 3));
        radishes.add(new Radish("black", 2.2, 4.2, 0));
        radishes.add(new Radish("white", 1.8, 0.6, 7));

        // Original List
        System.out.println("Original list:");
        radishes.forEach(System.out::println);
        System.out.println();

        // sort by natural order
        System.out.println("Sort by natural order (size)");
        radishes.sort(null);    // passing null means natural order
        dump(radishes);
        System.out.println();

        // sort by color. via an instance of RadishColorComparator
        System.out.println("Sort by color");
        radishes.sort(new RadishColorComparator());
        dump(radishes);
        System.out.println();

        // Using stream()
        List<Radish> sortedList = radishes.stream()
                .sorted(Comparator.comparing(Radish::getColor))
                .collect(Collectors.toList());
        sortedList.forEach(System.out::println);
        System.out.println();

        // Sort by tailLength
        // One-Time USE ONLY
        radishes.sort(new Comparator<Radish>() {
            @Override
            public int compare(Radish radish1, Radish radish2) {
                return Double.compare(radish1.getTailLength(), radish2.getTailLength());
            }
        });
        radishes.forEach(System.out::println);
        System.out.println();

        // Using stream() to sort by tailLength
        List<Radish> sortedByTailLength = radishes.stream()
                .sorted(Comparator.comparing(Radish::getTailLength))
                .collect(Collectors.toList());
        sortedByTailLength.forEach(System.out::println);
        System.out.println();

        // Sort by sprouts
        System.out.println("Sort by sprouts, via anonymous class");
        radishes.sort(new Comparator<Radish>() {
            @Override
            public int compare(Radish radish1, Radish radish2) {
                return Integer.compare(radish1.getSprouts(), radish2.getSprouts());
            }
        });
        radishes.forEach(System.out::println);
        System.out.println();

        // Using stream() to sort by sprouts
        List<Radish> sortedBySprouts = radishes.stream()
                .sorted(Comparator.comparing(Radish::getSprouts))
                .collect(Collectors.toList());
        sortedBySprouts.forEach(System.out::println);
    }

    private static void dump(List<Radish> radishList) {
        for (Radish radish : radishList) {
            System.out.println(radish);
        }
    }
}