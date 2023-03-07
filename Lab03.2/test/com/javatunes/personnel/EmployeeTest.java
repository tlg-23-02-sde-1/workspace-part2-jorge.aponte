package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class EmployeeTest {
    private Employee emp1;
    private Employee emp2;

    @Before
    public void setUp() {
        // emp1 = new DummyEmployee("Josh", Date.valueOf("2020-10-10"));
        // emp2 = new DummyEmployee("Josh", Date.valueOf("2020-10-10"));

        // Create an instance of a subclass of Employee (one-time use)
        emp1 = getEmployee();
        emp2 = getEmployee();
    }

    private Employee getEmployee() {
        return new Employee("Josh", Date.valueOf("2020-10-10")) {
            public double pay() {return 0;}
            public double payTaxes() {return 0;}
        };
    }

    @Test
    public void hashCode_shouldNotEqual_sameHireDate_differentName() {
        emp2.setHireDate(Date.valueOf("2001-1-1"));
        assertNotEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    public void hashCode_shouldNotEqual_sameName_differentHireDate() {
        emp2.setHireDate(Date.valueOf("2001-1-1"));
        assertNotEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    public void hashCode_shouldEqual_whenEqualObjects() {
        assertEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate() {
        emp2.setName("Jack");
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate() {
        emp2.setHireDate(Date.valueOf("2000-01-01"));
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesTheSame() {//business method_should return what_when what happens
        assertEquals(emp1, emp2);   // for objects, equals() gets called
    }

    // inner class that we changed at line 24
    private class DummyEmployee extends Employee {

        public DummyEmployee(String name, Date hireDate) {
            super(name, hireDate);
        }

        @Override
        public double pay() {
            return 0;
        }

        @Override
        public double payTaxes() {
            return 0;
        }
    }
}