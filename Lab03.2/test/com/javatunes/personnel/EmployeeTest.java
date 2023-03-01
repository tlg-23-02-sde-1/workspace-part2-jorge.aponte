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
        emp1 = new SalariedEmployee("Josh", Date.valueOf("2020-10-10"));
        emp2 = new SalariedEmployee("Josh", Date.valueOf("2020-10-10"));
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
}