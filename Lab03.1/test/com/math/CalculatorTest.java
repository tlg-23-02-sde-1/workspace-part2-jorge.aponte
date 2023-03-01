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

import org.junit.*;

public class CalculatorTest {
    // object(s) under test- called a "fixture" in JUNIT
    private Calculator calc;
    private static final double DELTA = 1e-12;

    @BeforeClass
    public static void initializeEntireTestRun() {
        System.out.println("initializeEntireTestRun");
    }

    @AfterClass
    public static void finalizeTestRun() {
        System.out.println("finalizeTestRun");
    }

    @Before
    public void setUp() {
        System.out.println("setUp");
        calc = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    public void onePlusFourEqualsFive() {
        System.out.println("testAdd");
        assertEquals(5, calc.add(1, 4));  // expected, actual
        assertNotEquals(10,calc.add(10,2));
    }

    @Test
    public void testDivide() {
        System.out.println("testDivide");
        assertEquals(2.5, calc.divide(5, 2), DELTA);  // expected, actual, delta
        assertNotEquals(4.5,calc.divide(10,2), DELTA);
    }

    @Test
    public void testIsEven() {
        System.out.println("testIsEven");
        assertTrue(calc.isEven(10));    // condition
        assertFalse(calc.isEven(11));   // condition
    }
}