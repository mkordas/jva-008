package com.lufoxt.training.jva008.collections;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import static com.lufoxt.training.jva008.Logger.log;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 1) Implement methods fillAnimalsLengthMap() and printMap().
 * 		Look at the result of the program execution.
 * 2) Implement methods fillLengthAnimalsMap() and printMapOfSets()
 * 		Look at the result of the program execution.
 */

public class MapTutor {
	Map<String, Integer> animalsLengthMap = new HashMap<String, Integer>();
    Map<Integer, Set<String>> lengthAnimalsMap = new HashMap<Integer, Set<String>>();

    String [] animals =
        {"Cow", "Goose", "Cat", "Dog", "Elephant", "Rabbit", "Snake", "Chicken", "Horse", "Human"};

    /**
	 * should fill the table animalsLengthMap with values
	 * animal => animal.length()
	 * for example
	 * "Cow" => 3
	 * "Snake" => 5
     */
    public void fillAnimalsLengthMap() {
    }

    /**
	 * Prints the table animalsLengthMap,
	 * by printing the key and value
     */
    public void printMap(Map<?,?> map) {
    }

    /**
	 * Fills table lengthAnimalsMap by values 
	 * animal name length => list of the animals of such a length
	 * for example:
	 * 3 => Cow, Dog, Cat
	 * 5 => Goose, Snake, Horse, Human
	 * 6 => Rabbit
     */
    public void fillLengthAnimalsMap() {
    }

    /**
	 * prints the contents of lengthAnimalsMap,
	 * by printing the key and list of values
     */
    public void printMapOfSets(Map<Integer,Set<String>> map) {
    }

    @Test
    public void testMap() {
        fillAnimalsLengthMap();
        log("== printMap animalsLengthMap");
        printMap(animalsLengthMap);

        log("== printMap treemap animalsLengthMap");
        SortedMap<String, Integer> sortedMap = new TreeMap<String,Integer>(animalsLengthMap);
        printMap(sortedMap);

        log("== print lengthAnimalsMap");
        fillLengthAnimalsMap();
        printMapOfSets(lengthAnimalsMap);

        SortedMap<Integer,Set<String>> sortedMap2 = new TreeMap<Integer,Set<String>>(lengthAnimalsMap);

        log("== sortedMap headSet where key<6");
        printMapOfSets(sortedMap2.headMap(6));

        log("== sortedMap subMap 5..7");
        printMapOfSets(sortedMap2.subMap(5,7));
    }

    @Test
    public void fillAnimalsLengthMap_default_fillsAnimalsLengthMapWithData() {
        animalsLengthMap.clear();
        fillAnimalsLengthMap();
        assertEquals(3, (int) animalsLengthMap.get("Cow"));
        assertEquals(5, (int) animalsLengthMap.get("Goose"));
    }

    @Test
    public void fillLengthAnimalsMap_default_fillLengthAnimalsMapWithData() {
        lengthAnimalsMap.clear();
        fillLengthAnimalsMap();
        assertTrue(lengthAnimalsMap.get(3).contains("Cow"));
        assertTrue(lengthAnimalsMap.get(5).contains("Goose"));
    }

}
