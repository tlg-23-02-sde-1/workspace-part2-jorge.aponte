package com.entertainment;

import java.util.Comparator;

public class TelevisionBrandChannelComparator implements Comparator<Television> {

    @Override
    public int compare(Television tv1, Television tv2) {
        if (tv1.getBrand().compareTo(tv2.getBrand()) == 0) {
            return Integer.compare(tv1.getCurrentChannel(), tv2.getCurrentChannel());
        }
        return tv1.getBrand().compareTo(tv2.getBrand());
    }
}