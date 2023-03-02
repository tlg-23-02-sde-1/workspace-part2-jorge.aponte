package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionChannelComparatorTest {
    Television tv1;
    Television tv2;
    TelevisionChannelComparator compares;

    @Before
    public void setUp() {
        tv1 = new Television("Sony", 50, DisplayType.OLED);
        tv2 = new Television("Sony", 50, DisplayType.OLED);
        compares = new TelevisionChannelComparator();
    }

    @Test
    public void compare_shouldEqualZero_sameChannel() {
        assertEquals(0, compares.compare(tv1, tv2));
    }

    @Test
    public void compare_shouldReturnPositive_differentChannel() throws InvalidChannelException {
        tv1.changeChannel(400);
        assertTrue(compares.compare(tv1, tv2) > 0);
    }

    @Test
    public void compare_shouldReturnNegativeInt_differentChannel() throws InvalidChannelException {
        tv2.changeChannel(400);
        assertTrue(compares.compare(tv1, tv2) < 0);
    }
}