/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {

    @Test
    public void getLoudestTv() {
        // This method is implemented differently than what the optional Lab wanted.
        // Instead of returning the Television object I decided to give a collection of the Television object
        // with the greatest volume. Hence, why the size of the list is 1.
        Collection<Television> tvs = Catalog.getInventory();
        List<Television> tvList = new LinkedList<>(tvs);
        List<Television> loudestTVList = new ArrayList<>();
        int maxVolume = Integer.MIN_VALUE;
        for (Television tv : tvList) {
            if (tv.getVolume() > maxVolume) {
                maxVolume = tv.getVolume();
                loudestTVList.clear();
                loudestTVList.add(tv);
            }
        }
        assertEquals(94, loudestTVList.get(0).getVolume());
        assertEquals(1, loudestTVList.size());
    }

    @Test
    public void getInventory_shouldReturnASetWithNoDuplicates_whenAllPropertiesAreTheSame() {
        Collection<Television> tvs = Catalog.getInventory();
        Set<Television> tvList = new HashSet<>(tvs);
        assertEquals(23, tvList.size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getInventory_shouldBeUnmodifiable() {
        Collection<Television> tvs = Catalog.getInventory();
        tvs.add(new Television("Sony", 50));
        tvs.clear();
        assertEquals(30, tvs.size());
    }

    @Test
    public void findByBrands_shouldReturnWithEntries_whenBrandsPassed() {
        Map<String, Collection<Television>> tvMap = Catalog.findByBrands("Sony", "Zenith", "LG");

        assertEquals(3, tvMap.size());

        Collection<Television> sonyTvs = tvMap.get("Sony");
        assertEquals(7, sonyTvs.size());
        for (Television tv : sonyTvs) {
            assertEquals("Sony", tv.getBrand());
        }

        Collection<Television> zenithTvs = tvMap.get("Zenith");
        assertEquals(9, zenithTvs.size());
        for (Television tv : zenithTvs) {
            assertEquals("Zenith", tv.getBrand());
        }

        Collection<Television> lgTvs = tvMap.get("LG");
        assertTrue(lgTvs.isEmpty());
    }

    @Test
    public void findByBrands_shouldReturnEmptyMap_whenBrandNotFound() {
        Map<String, Collection<Television>> tvMap = Catalog.findByBrands();
        assertTrue(tvMap.isEmpty());
    }

    @Test
    public void findByBrand_shouldReturnCollectionWithThatBrand_whenBrandFound() {
        Collection<Television> tvs = Catalog.findByBrand("Sony");

        assertEquals(7, tvs.size());
        for (Television tv : tvs) {
            assertEquals("Sony", tv.getBrand());
        }
    }

    /**
     * Contract: a no-matches result should be an empty collection (not null).
     */
    @Test
    public void findByBrand_shouldReturnEmptyCollection_whenBrandNotFound() {
        Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
        assertTrue(tvs.isEmpty());
    }
}