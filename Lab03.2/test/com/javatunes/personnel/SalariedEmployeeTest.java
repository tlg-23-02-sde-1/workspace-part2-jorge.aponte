package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {
    private static final double DELTA = 1e-12;
    SalariedEmployee emp1;
    SalariedEmployee emp2;

    @Before
    public void setUp() {
        emp1 = new SalariedEmployee("Jorge", Date.valueOf("2020-12-20"), 1500.00);
        emp2 = new SalariedEmployee("Jorge", Date.valueOf("2020-12-20"), 1500.00);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameSalary_differentHireDate() {
        emp2.setHireDate(Date.valueOf("2000-1-05"));
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameSalary_sameHireDate_differentName() {
        emp2.setName("Different");
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_differentSalary() {
        emp2.setSalary(1250.00);
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesTheSame() {
        assertEquals(emp1, emp2);
    }

    @Test
    public void hashcode_shouldEqual_allPropertiesTheSame() {
        assertEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    public void hashcode_shouldNotEqual_sameName_sameHireDate_differentSalary() {
        emp2.setSalary(1250.00);
        assertNotEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    public void hashcode_shouldNotEqual_sameSalary_sameHireDate_differentName() {
        emp2.setName("Different");
        assertNotEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    public void hashcode_shouldNotEqual_sameName_sameSalary_differentHireDate() {
        emp2.setHireDate(Date.valueOf("2021-01-09"));
        assertNotEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    public void pay_shouldEqual_whenExpected1500() {
        assertEquals(1500.00, emp1.pay(), DELTA);
    }

    @Test
    public void pay_shouldNotEqual_whenSalaryIs1450() {
        assertNotEquals(1450.00, emp1.pay(), DELTA);
    }

    @Test
    public void payTaxes_shouldEqual_whenExpected450() {
        assertEquals(450.00, emp1.payTaxes(), DELTA);
    }

    @Test
    public void payTaxes_shouldNotEqual_whenExpected440() {
        assertNotEquals(440.00, emp1.payTaxes(), DELTA);
    }
}