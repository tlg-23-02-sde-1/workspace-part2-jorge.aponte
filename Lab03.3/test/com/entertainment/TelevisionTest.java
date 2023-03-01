package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionTest {
    Television tv1;
    Television tv2;

    @Before
    public void setUp() {
        tv1 = new Television("Sony", 50, DisplayType.OLED);
        tv2 = new Television("Sony", 50, DisplayType.OLED);
    }

    @Test
    public void compare_shouldEqualZero_sameChannel() {
        TelevisionChannelComparator compares = new TelevisionChannelComparator();
        assertEquals(0, compares.compare(tv1, tv2));
    }

    @Test
    public void compare_shouldReturnPositive_differentChannel() throws InvalidChannelException {
        TelevisionChannelComparator compares = new TelevisionChannelComparator();
        tv1.changeChannel(400);
        assertTrue(compares.compare(tv1, tv2) > 0);
    }

    @Test
    public void compare_shouldReturnNegativeInt_differentChannel() throws InvalidChannelException {
        TelevisionChannelComparator compares = new TelevisionChannelComparator();
        tv2.changeChannel(400);
        assertTrue(compares.compare(tv1, tv2) < 0);
    }

    @Test
    public void compare_shouldEqualZero_sameBrand_sameCurrentChannel() {
        TelevisionBrandChannelComparator compares = new TelevisionBrandChannelComparator();
        assertEquals(0, compares.compare(tv1, tv2));
    }

    @Test
    public void compare_shouldReturnPositiveInt_sameCurrentChannel_differentBrand() {
        TelevisionBrandChannelComparator compares = new TelevisionBrandChannelComparator();
        tv2.setBrand("RCA");
        assertTrue(compares.compare(tv1, tv2) > 0);
    }

    @Test
    public void compare_shouldReturnNegativeInt_sameBrand_differentCurrentChannel() throws Exception {
        TelevisionBrandChannelComparator compares = new TelevisionBrandChannelComparator();
        tv2.changeChannel(500);
        assertTrue(compares.compare(tv1, tv2) < 0);
    }

    @Test
    public void changeChannel_shouldAcceptInput_whenValid_lowerBound() throws InvalidChannelException {
        tv1.changeChannel(1);
        assertEquals(1, tv1.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldAcceptInput_whenValid_upperBound() throws InvalidChannelException {
        tv1.changeChannel(999);
        assertEquals(999, tv1.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalidInput_upperBound() {
        try {
            tv1.changeChannel(1000);
            fail("Should have thrown InvalidChannelException");
        } catch (InvalidChannelException e) {
            assertEquals("Invalid channel: 1000. Allowed range: [1,999].", e.getMessage());
        }
    }

    @Test
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalidInput_lowerBound() {
        try {
            tv1.changeChannel(-1);
            fail("Should have thrown InvalidChannelException");
        } catch (InvalidChannelException e) {
            assertEquals("Invalid channel: -1. Allowed range: [1,999].", e.getMessage());
        }
    }

    @Test
    public void compareTo_shouldNotEqual_differentBrand() {
        tv2.setBrand("Different");
        assertNotEquals(0, tv1.compareTo(tv2));
    }

    @Test
    public void compareTo_shouldEqual_sameBrand() {
        assertEquals(0, tv1.compareTo(tv2));
    }

    @Test
    public void hashcode_shouldEqual_allPropertiesSame() {
        assertEquals(tv1.hashCode(), tv2.hashCode());
    }

    @Test
    public void hashCode_shouldNotEqual_sameBrand_sameVolume_differentDisplayType() {
        tv2.setDisplay(DisplayType.LED);
        assertNotEquals(tv1.hashCode(), tv2.hashCode());
    }

    @Test
    public void hashCode_shouldNotEqual_sameDisplayType_sameVolume_differentBrand() {
        tv2.setBrand("Different");
        assertNotEquals(tv1.hashCode(), tv2.hashCode());
    }

    @Test
    public void hashCode_shouldNotEqual_sameBrand_sameDisplayType_differentVolume() {
        tv2.setVolume(25);
        assertNotEquals(tv1.hashCode(), tv2.hashCode());
    }

    @Test
    public void equals_objectsShouldBeEqual_allPropertiesAreTheSame() {
        assertEquals(tv1, tv2);
    }

    @Test
    public void equals_objectShouldNotBeEqual_sameBrand_sameVolume_differentDisplayType() {
        tv2.setDisplay(DisplayType.LED);
        assertNotEquals(tv1, tv2);
    }

    @Test
    public void equals_objectShouldNotBeEqual_sameDisplayType_sameVolume_differentBrand() {
        tv2.setBrand("Different");
        assertNotEquals(tv1, tv2);
    }

    @Test
    public void equals_objectShouldNotBeEqual_sameBrand_sameDisplayType_differentVolume() {
        tv2.setVolume(25);
        assertNotEquals(tv1, tv2);
    }

    @Test
    public void setVolume_shouldAcceptInput_lowerBound() throws IllegalArgumentException {
        tv1.setVolume(0);
        assertEquals(0, tv1.getVolume());
    }

    @Test
    public void setVolume_shouldAcceptInput_upperBound() throws IllegalArgumentException {
        tv2.setVolume(100);
        assertEquals(100, tv2.getVolume());
    }

    @Test
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_upperBound() {
        try {
            tv1.setVolume(101);
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid volume: 101. Allowed range: [0,100].", e.getMessage());
        }
    }

    @Test
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_lowerBound() {
        try {
            tv1.setVolume(-1);
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid volume: -1. Allowed range: [0,100].", e.getMessage());
        }
    }
}