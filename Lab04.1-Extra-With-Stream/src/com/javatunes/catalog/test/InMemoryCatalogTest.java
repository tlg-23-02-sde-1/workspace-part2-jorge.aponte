/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog.test;

import com.javatunes.catalog.InMemoryCatalog;
import com.javatunes.catalog.MusicCategory;
import com.javatunes.catalog.MusicItem;

import java.util.Collection;
import java.util.Map;

class InMemoryCatalogTest {

    /*
     * One by one, complete each test method below, and then "activate" it by
     * uncommenting the call to that method in main().
     *
     * Once you see that the test method verifies the corresponding business method
     * works correctly, you can comment out that call in main() and proceed to the next one.
     */
    public static void main(String[] args) {
        // testFindById();              //Completed and Tested
        // testFindByKeyword();         //Completed and Tested
        // testFindByCategory();        //Completed and Tested
        // testSize();                  //Completed and Tested
        // testGetAll();                //Completed and Tested

        // testFindSelfTitled();        //Completed and Tested
        // testFindRockBottom();        //Completed and Tested
        // testGenreCount();            //Completed and Tested
        // testAverageCost();           //Completed and Tested
        // testCheapestItemByGenre();   //Completed and Tested
        // testAveragePriceByGenre();   //Completed and Tested
        // testIsAtLeast();             //Completed and Tested
        // testIsInInventory();         //Completed and Tested
        // testGetPopTitles();          //Completed and Tested
        // testCheapSongsFromThe80s();  //Completed and Tested
        // testGetCategoryMap();        //Completed and Tested
    }

    private static void testGetCategoryMap() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Map<MusicCategory, Collection<MusicItem>> items = catalog.getCategoryMap();
        items.forEach((key, value) -> System.out.println(key + " -> " + value));    // should have Jazz with empty []
    }

    private static void testCheapSongsFromThe80s() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        catalog.dump(catalog.cheapSongsFromThe80s(11.97));  // should print 4 items
    }

    private static void testGetPopTitles() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<String> titles = catalog.getPopTitles();
        titles.forEach(System.out::println);     // should print all POP Titles in natural order
    }

    private static void testIsInInventory() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        MusicCategory choice = MusicCategory.JAZZ;
        System.out.printf("Our Catalog has %s music for sale: %s\n"
                , choice, catalog.isInInventory(choice));   // should print "false"

        choice = MusicCategory.ALTERNATIVE;
        System.out.printf("Our Catalog has %s music for sale: %s"
                , choice, catalog.isInInventory(choice));   // should print "true"
    }

    private static void testIsAtLeast() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        double minPrice = 10.00;

        System.out.printf("Our Catalog has all items priced at least $%.2f : %s",
                minPrice, catalog.isAtLeast(minPrice));     // should print false
    }

    private static void testAveragePriceByGenre() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        MusicCategory genre = MusicCategory.BLUES;

        System.out.printf("Average Price for %s CDs: $%.2f", genre, catalog.averagePriceByGenre(genre));
    }

    private static void testCheapestItemByGenre() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        System.out.println(catalog.cheapestItemByGenre(MusicCategory.ROCK));    // should print the cheapest item
    }

    private static void testAverageCost() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        System.out.printf("Average cost is: $%.2f", catalog.averageCost());     // should print 15.31
    }

    private static void testGenreCount() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        MusicCategory genre = MusicCategory.ROCK;

        System.out.printf("We sell %s %s items", catalog.genreCount(genre), genre);     // should print 6
    }

    private static void testFindRockBottom() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        catalog.dump(catalog.findRockBottom(17.96));    // should print 3 items
    }

    private static void testFindSelfTitled() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        catalog.dump(catalog.findSelfTitled());     // should print 2 items Seal and Ian Moore
    }

    private static void testFindById() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        System.out.println(catalog.findById(12L));      // should print item 12
        System.out.println(catalog.findById(20L));      // should print null
    }

    private static void testFindByKeyword() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        catalog.dump(catalog.findByKeyword("Seal"));    // should print collection
        catalog.dump(catalog.findByKeyword("hello"));   // should print empty collection
    }

    private static void testFindByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        catalog.dump(catalog.findByCategory(MusicCategory.ROCK));   // should print collection ROCK
    }

    private static void testSize() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        System.out.println("Size of the catalog: " + catalog.size());   //should print 18
    }

    private static void testGetAll() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        catalog.dump(catalog.getAll());     // should print the whole unmodifiable collection
    }
}