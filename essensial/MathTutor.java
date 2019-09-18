import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;


public class MathTutor {

    /**
     * Return the random age in the range from minAge to maxAge
     */
    public int getRandomAge(int minAge, int maxAge) {
        int returnedAge = minAge + (int) (Math.random() * ((maxAge - minAge) + 1));
        return returnedAge;
    }

    /**
     * Pythagorean theorem:
     * Computes the hypotenuse to the nearest
     * The second decimal place,
     * For example, if leg 2 and 3, the hypotenuse = 3.61
     *
     * @return
     */
    public double getHypotenuse(double cathetus1,
                                double cathetus2) {
        double d = Math.sqrt(Math.pow(cathetus1, 2) + Math.pow(cathetus2, 2));
        int temp = (int)Math.round((d * Math.pow(10 , 2)));
        return ((double)temp)/Math.pow(10 , 2);
    }

    @Test
    public void testGetHypotenuse() {
        double hyp = getHypotenuse(2, 3);
//        log(hyp);

        assertEquals(3.61, hyp, 0);
    }

    /**
     * Tests the occupancy range MIN_AGE..MAX_AGE
     * And uniform distribution
     * (Each age should occur equally often)
     */
    @Test
    public void testRandomAge() {
        int ITERATIONS = 1000000;
        int MIN_AGE = 18;
        int MAX_AGE = 25;
        Map<Integer, Integer> occurences = new HashMap<Integer, Integer>();
        for (int i = 0; i < ITERATIONS; i++) {
            int age = getRandomAge(MIN_AGE, MAX_AGE);
            Integer occur = occurences.get(age);
            if (occur == null) occur = 0;
            occurences.put(age, occur + 1);
        }
        Set<Integer> ages = occurences.keySet();
        List<Integer> sortedAges = new ArrayList<Integer>(ages);
        Collections.sort(sortedAges);
        int minOccurences = 0, maxOccurences = 0;
        double mean = ITERATIONS / (MAX_AGE - MIN_AGE + 1);
        double varianceSum = 0;
        for (Integer age : sortedAges) {
            int o = occurences.get(age);
            minOccurences = Math.min(o, minOccurences);
            maxOccurences = Math.max(o, maxOccurences);
            int variance = (int) (o - mean);
            varianceSum += variance * variance;
//            log ("for the age of" + age + ":" + occurences.get (age) + "entries, variance =" + variance);
        }
        double deviation = Math.sqrt(varianceSum / sortedAges.size());
//        log ("sd =" + deviation);
        double uniformity = (maxOccurences - minOccurences) * 1d / ITERATIONS;
//        log ("The uniformity of the distribution of ages:" + uniformity);
        assertEquals(MIN_AGE, sortedAges.get(0), 0);
        assertEquals(MAX_AGE, sortedAges.get(sortedAges.size() - 1), 0);
        assertTrue(uniformity < 0.2);
    }

}
