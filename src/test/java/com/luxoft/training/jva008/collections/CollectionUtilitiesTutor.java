package com.luxoft.training.jva008.collections;

import com.luxoft.training.jva008.Logger;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CollectionUtilitiesTutor {
	String [] animals =
        {"Cow", "Goose", "Cat", "Dog", "Elephant", "Rabbit", "Snake", "Chicken", "Horse", "Human"};
	
	public void print(Collection<?> c) {
		StringBuilder builder = new StringBuilder();
		Iterator<?> iterator = c.iterator();
		while(iterator.hasNext()) {
			 builder.append(iterator.next())
			        .append(" ");
		}
		Logger.log(builder.toString());
	}

	@Test
	public void testUtilities() {
		List<String> list = Arrays.asList(animals);
		Logger.log("== print the resulting list");
		print(list);
		
		Logger.log("== print the shuffled list");
		Collections.shuffle(list);
		print(list);
		
		Logger.log("== print the sorted list (used natural ordering)");
		Collections.sort(list);
		print(list);
		
		Logger.log("== binary Search of Elephant after sorting: " + Collections.binarySearch(list, "Elephant"));

		Logger.log("== print the reversed list");
		Collections.reverse(list);
		print(list);
		
		Logger.log("== binary Search of Elephant without sorting: " + Collections.binarySearch(list, "Elephant"));
		
		Logger.log("== print the sorted by length list of word");
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
		});
		print(list);

		Logger.log("== max (used natural ordering): " + Collections.max(list));
		Logger.log("== min (used natural ordering): " + Collections.min(list));
		
		Logger.log("== frequency of Cow: " + Collections.frequency(list, "Cow"));
		Logger.log("== frequency of Human: " + Collections.frequency(list, "Human"));
		
		Logger.log("== replace Cow to Pig: ");
		Collections.replaceAll(list, "Cow", "Pig");
		print(list);
		
		Logger.log("== swap: swap first and last values: ");
		Collections.swap(list, 0, list.size()-1);
		print(list);
		
		Logger.log("== rotate: rotate by 2: ");
		Collections.rotate(list, 2);
		print(list);
		
		Logger.log("== indexOfSubList: look for sublist in the list ");
		List<String> subList = Arrays.asList(new String[]{list.get(5),list.get(6)});
		print(subList);
		Logger.log("sublist position: " + Collections.indexOfSubList(list, subList));
		
		Logger.log("== fill: fill list with the same values: ");
		Collections.fill(list, ".");
		print(list);
	}

}
