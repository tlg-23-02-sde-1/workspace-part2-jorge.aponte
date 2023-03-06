package com.javatunes.billing;

public class TaxCalculatorFactory {

    // prevent institution
    private TaxCalculatorFactory() {
    }

    /*
     * OPTIONAL CHALLENGE:
     * Implement a cache of TaxCalculator objects, such that
     * we return a previously-created one if one is in there,
     * and if not, we create and return a new one, put it in the map, and then return it.
     *
     * Hint: you can use a Map<Location,TaxCalculator> for the cache
     *
     * Location     |     TaxCalculator     (if not in the map make new and put)
     * ---------------------------------
     * EUROPE           EuropeTax Object    (check the key to have the location)
     *
     * Create a test and use the assertSame to verify they are the same TaxCalculators
     */

    public static TaxCalculator getTaxCalculator(Location location) {
        TaxCalculator calc = null;
        switch (location) {
            case ONLINE:
                calc = new OnlineTax();
                break;
            case USA:
                calc = new USATax();
                break;
            case EUROPE:
                calc = new EuropeTax();
        }
        return calc;
    }
}