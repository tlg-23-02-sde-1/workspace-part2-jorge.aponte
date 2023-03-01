package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    private static final double DELTA = 1e-12;
    HourlyEmployee emp1;
    HourlyEmployee emp2;

    @Before
    public void setUp() {
        emp1 = new HourlyEmployee("Jessica", Date.valueOf("2015-03-31"), 25.00, 40.00);
        emp2 = new HourlyEmployee("Jessica", Date.valueOf("2015-03-31"), 25.00, 40.00);
    }

    @Test
    public void equals_shouldReturnFalse_sameRate_sameName_sameHours_differentHireDate() {
        emp1.setHireDate(Date.valueOf("2020-05-09"));
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameRate_sameHireDate_sameHours_differentName() {
        emp1.setName("Different");
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_sameHours_differentRate() {
        emp1.setRate(30.00);
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_sameRate_differentHours() {
        emp1.setHours(30.00);
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
    public void hashcode_shouldNotEqual_sameName_sameHireDate_sameHours_differentRate() {
        emp1.setRate(15.50);
        assertNotEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    public void hashcode_shouldNotEqual_sameName_sameRate_sameHours_differentHireDate() {
        emp1.setHireDate(Date.valueOf("2020-08-09"));
        assertNotEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    public void hashcode_shouldNotEqual_sameRate_sameHireDate_sameHours_differentName() {
        emp1.setName("Different");
        assertNotEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    public void hashcode_shouldNotEqual_sameName_sameHireDate_sameRate_differentHours() {
        emp1.setHours(30.00);
        assertNotEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    public void pay_shouldEqual_whenExpected1000() {
        assertEquals(1000.00, emp1.pay(), DELTA);
    }

    @Test
    public void pay_shouldNotEqual_whenExpected999() {
        assertNotEquals(999.00, emp1.pay(), DELTA);
    }

    @Test
    public void payTaxes_shouldEqual_whenExpected450() {
        assertEquals(250.00, emp1.payTaxes(), DELTA);
    }

    @Test
    public void payTaxes_shouldNotEqual_whenExpected440() {
        assertNotEquals(440.00, emp1.payTaxes(), DELTA);
    }
}