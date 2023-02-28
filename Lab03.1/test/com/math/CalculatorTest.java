/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 1e-12;
    private static final Calculator calc = new Calculator();

    @Test
    public void testAdd() {
        System.out.println("testAdd");
//        Calculator calc = new Calculator();
        assertEquals(5, calc.add(1, 4));  // expected, actual
    }

    @Test
    public void testDivide() {
        System.out.println("testDivide");
//        Calculator calc = new Calculator();
        assertEquals(2.5, calc.divide(5, 2), DELTA);  // expected, actual, delta
    }

    @Test
    public void testIsEven() {
        System.out.println("testIsEven");
//        Calculator calc = new Calculator();
        assertTrue(calc.isEven(10));    // condition
        assertFalse(calc.isEven(11));   // condition
    }
}