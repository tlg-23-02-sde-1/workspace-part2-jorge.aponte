package com.duckrace;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 *
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 *
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage by id.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

class Board {
    private final Map<Integer, String> studentIdMap = loadStudentIdMap();
    private final Map<Integer, DuckRacer> racerMap = new TreeMap<>();

    /*
     * Updates the board (racerMap) by making a DuckRacer win.
     * This could mean fetching an existing DuckRacer from racerMap,
     * or we might need to create a new DuckRacer, put it in the map
     * and then make it win.
     */
    public void update(int id, Reward reward) {
        DuckRacer racer = null;

        if (racerMap.containsKey(id)) {
            racer = racerMap.get(id);
        } else {
            racer = new DuckRacer(id, studentIdMap.get(id));
            racerMap.put(id, racer);
        }
        // either way, it needs to "win"
        racer.win(reward);
    }

    /*
     * TODO: Render the data "pretty" i.e., like we see in class
     * This includes column headings, spacing it all out nicely, etc..
     * printf
     */

    void showResults() {
        System.out.println("Duck Race Results");
        System.out.println("================== \n");
        System.out.println("id \t name \t wins \t rewards");
        System.out.println("-- \t ---- \t ---- \t -------");
        Collection<DuckRacer> allRacers = racerMap.values();
        for (DuckRacer racer : allRacers) {
            System.out.printf("%s \t %s \t  %s \t%s\n"
                    ,racer.getId(),racer.getName(),racer.getWins(),racer.getRewards());  // toString() automatically called
        }
    }

    // TESTING ONLY - will probably be removed
    void dumpStudentIdMap() {
        System.out.println(studentIdMap);
    }

    /*
     * Populates student Id map from file conf/student-ids.csv
     */
    private Map<Integer, String> loadStudentIdMap() {
        Map<Integer, String> idMap = new HashMap<>();

        try {
            List<String> lines = Files.readAllLines(Path.of("conf/student-ids.csv"));

            // for each line in lines, we want to split the string into "tokens"
            // then convert
            for (String line : lines) {
                String[] tokens = line.split(",");  // returns "1" and a "Caleb" ex.. [1,Caleb]
                idMap.put(Integer.valueOf((tokens[0])), tokens[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return idMap;
    }
}