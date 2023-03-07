/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.sql.Date;
import java.util.Map;

public class EmployeeFactory {

    // prevent direct instantiation - this is an all-static factory class
    private EmployeeFactory() {
    }

    /**
     * TODO: given the input map, create and return the correct object (with its properties set).
     * If the input map's "type" value is not "HE" or "SE",
     * throw IllegalArgumentException with a suitable message.
     */
    public static Employee createEmployee(Map<String, String> inputMap)
    throws IllegalArgumentException {

        Employee emp;
        String type = inputMap.get("type");

        if("SE".equals(type)) {
            emp = new SalariedEmployee(inputMap.get("name"),Date.valueOf(inputMap.get("hireDate")),
                    Double.valueOf(inputMap.get("salary")));
            return emp;
        }
        else if ("HE".equals(type)) {
            emp = new HourlyEmployee(inputMap.get("name"),Date.valueOf(inputMap.get("hireDate")),
                    Double.valueOf(inputMap.get("rate")),Double.valueOf(inputMap.get("hours")));
            return emp;
        }

        throw new IllegalArgumentException("Invalid type: " + type);
    }
}