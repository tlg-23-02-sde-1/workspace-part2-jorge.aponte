package com.crunch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class RadishSortTest {

    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();
        radishes.add(new Radish("red",1.1,2.1,0));
        radishes.add(new Radish("pink",3.5,0.0,3));
        radishes.add(new Radish("black",2.2,4.2,0));
        radishes.add(new Radish("white",1.8,0.6,7));

        System.out.println("Original list:");
        radishes.forEach(System.out::println);

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
        System.out.println(sortedList);
    }

    private static void dump(List<Radish> radishList) {
        for(Radish radish : radishList) {
            System.out.println(radish);
        }
    }
}