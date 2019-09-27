package com.luxoft.training.jva008.collections;

import com.luxoft.training.jva008.Logger;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Implement method joinByCycle(). Check the result.
 * Implement methods getAnimalsList(), getAnimalsSet() and return its values.
 * How do the results differ?
 * Implement method joinByIterator()
 */

public class CollectionTutor {
	String [] animals =
        {"Cow", "Goose", "Cat", "Dog", "Elephant", "Rabbit", "Snake", "Chicken", "Horse", "Human", "Cow"};

   /**
   * This method should return the ArrayList with all the animals
   */
   public List<String> getAnimalsList() {
       Logger.log(String.join(",", Arrays.asList(animals)));
       return Arrays.asList(animals);
   }

   /**
   * The method must return a Set with all the animals
   */
   public Set<String> getAnimalsSet() {
       //Logger.log(String.join("," Arrays.s));
       return new HashSet<>(Arrays.asList(animals));
   }

   /**
	* Method should take a collection of strings
	* and return one string consisting of all collection elements,
	* separated by commas, using for cycle
   */
   public String joinByCycle(Collection<?> c) {
       StringBuilder builder = new StringBuilder();
       for (Object o : c) {
           builder.append(o).append(",");
       }
        builder.delete(builder.length()-1, builder.length());
       return builder.toString();
   }

   /**
	* Method should take a collection of strings
	* and return one string consisting of all collection elements,
	* separated by commas, using iterator
   */
   public String joinByIterator(Collection<?> c) {
       Iterator<?> iterator = c.iterator();
       StringBuilder builder = new StringBuilder();
       while (iterator.hasNext()) {
           builder.append(iterator.next()).append(",");
       }
       builder.delete(builder.length() - 1, builder.length());
       return builder.toString();
   }

   @Test
   public void testCollections() {
       Logger.log("getAnimalsList: " + joinByCycle(Arrays.asList(animals)));

       Logger.log("getAnimalsList: " + joinByCycle(getAnimalsList()));
       Logger.log("getAnimalsSet: " + joinByCycle(getAnimalsSet()));

       Logger.log("getAnimalsList by iterator: " + joinByIterator(getAnimalsList()));
   }

   @Test
   public void getAnimalsListShouldReturnsListContainsAllAnimals() {
       List<String> list = getAnimalsList();
       assertTrue(list.containsAll(Arrays.asList(animals)));
   }

   @Test
   public void getAnimalsSetShouldReturnsSetContainsAllAnimals() {
       Set<String> set = getAnimalsSet();
       assertTrue(set.containsAll(Arrays.asList(animals)));
   }

   @Test
   public void joinByCycleShouldReturnsStringWithAllAnimalsJoined() {
       String result = joinByCycle(make123Collection());
       assertEquals("1,2,3", result);
   }

   @Test
   public void joinByIteratorShouldReturnsStringWithAllAnimalsJoined() {
       String result = joinByIterator(make123Collection());
       assertEquals("1,2,3", result);
   }

   private Collection<String> make123Collection() {
       Collection<String> collection = new LinkedHashSet<String>();
       collection.add("1");
       collection.add("2");
       collection.add("3");
       return collection;
   }
}
