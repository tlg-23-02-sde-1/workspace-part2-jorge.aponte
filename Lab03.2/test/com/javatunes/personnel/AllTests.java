package com.javatunes.personnel;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

class AllTests {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(EmployeeTest.class, HourlyEmployeeTest.class, SalariedEmployeeTest.class);
        System.out.println("\n======================");
        System.out.println("\t TEST RESULTS");
        System.out.println("======================");
        System.out.println("All tests passed: " + result.wasSuccessful());
        System.out.println("Total tests run: " + result.getRunCount());
        System.out.println("Failure count: " + result.getFailureCount());
    }
}