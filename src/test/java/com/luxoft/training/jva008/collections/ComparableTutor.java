package com.luxoft.training.jva008.collections;

import com.luxoft.training.jva008.Logger;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 *	Implement method Set<Animal> getAnimalsOrderedByNameSet()
 * 	and method Set<Animal> getAnimalsOrderedByNameSetDesc()
 */

public class ComparableTutor {
	String [] animals =
        {"Cow", "Goose", "Cat", "Dog", "Elephant", "Rabbit", "Snake", "Chicken", "Horse", "Human"};

    class Animal{
        String name;
        public Animal(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
    }

    /**
	 * Method should return a Set of Animal instances, alphabetically sorted
	 * Use TreeSet for that and implement Comparable interface in Animal class.
     */
    public Set<Animal> getAnimalsOrderedByNameSet() {
        return null;
    }

    /**
	 * Method should return a Set of Animal instances,
	 * ordered by the name in reverse order.
	 * Use TreeSet for that and pass a Comparator implementation as a parameter.
     *
     */
    public Set<Animal> getAnimalsOrderedByNameSetDesc() {
        return null;
    }

    public String joinByCycle(Collection<?> c) {
        if (c == null) {
        	return "";
        }
        StringBuilder builder = new StringBuilder();
        for (Object s: c) {
            builder.append(s);
            if (builder.length()>0) builder.append(", ");
        }
        return builder.toString();
    }

    @Test
    public void testCollections() {
        Logger.log("getAnimalsList: " + joinByCycle(Arrays.asList(animals)));

        Logger.log("getAnimalsOrderedByNameSet: " + joinByCycle(getAnimalsOrderedByNameSet()));
        Logger.log("getAnimalsOrderedByNameSetDesc: " + joinByCycle(getAnimalsOrderedByNameSetDesc()));
    }

    @Test
    public void getAnimalsOrderedByNameSet_default_returnsSortedSet() {
        Set<Animal> set = getAnimalsOrderedByNameSet();
        String join = joinByCycle(set);
        assertEquals("Cat, Chicken, Cow, Dog, Elephant, Goose, Horse, Human, Rabbit, Snake, ", join);
    }

    @Test
    public void getAnimalsOrderedByNameSetDesc_default_returnsSortedSet() {
        Set<Animal> set = getAnimalsOrderedByNameSetDesc();
        String join = joinByCycle(set);
        assertEquals("Snake, Rabbit, Human, Horse, Goose, Elephant, Dog, Cow, Chicken, Cat, ", join);
    }
}
