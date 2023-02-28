package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.Set;

class TelevisionClient {
    public static void main(String[] args) {
        // compare behavior of == and equals()
        Television tv3 = new Television("Sony", 50);
        Television tv4 = new Television("Sony", 50);

        System.out.println("tv3 == tv4 : " + (tv3 == tv4));             // always false (checking reference)
        System.out.println("tv3.equals(tv4) : " + (tv3.equals(tv4)));   // true now

        System.out.println("tv3 hashcode: " + tv3.hashCode());  // 54
        System.out.println("tv4 hashcode: " + tv4.hashCode());  // 54

        // Let's create a Set<Television> and see what happens
        Set<Television> tvSet = new HashSet<>();
        tvSet.add(tv3);
        tvSet.add(tv4);     // should be rejected as a "duplication"

        // The size of the Set should be 1, BUT it's 2 !!!
        System.out.println("The size of the Set is: " + tvSet.size());
    }
}