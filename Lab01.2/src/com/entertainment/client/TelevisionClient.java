package com.entertainment.client;

import com.entertainment.Television;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class TelevisionClient {
    public static void main(String[] args) {
        // compare behavior of == and equals()
        Television tv3 = new Television("Sony", 50);
        Television tv4 = new Television("Sony", 50);
        Television tv5 = new Television("Samsung", 47);
        Television tv6 = new Television("LG",52);

        System.out.println("tv3 == tv4 : " + (tv3 == tv4));             // always false (checking reference)
        System.out.println("tv3.equals(tv4) : " + (tv3.equals(tv4)));   // true now

        // Let's create a Set<Television> and see what happens
        Set<Television> tvSet = new TreeSet<>();
        tvSet.add(tv3);
        tvSet.add(tv4);     // should be rejected as a "duplication"
        tvSet.add(tv5);
        tvSet.add(tv6);

        tvSet.forEach(System.out::println);

        // The size of the Set should be 1, BUT it's 2 !!!
        System.out.println("The size of the Set is: " + tvSet.size());
    }
}