package com.lufoxt.training.jva008.essensial;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class StringMatchesTutor extends Tutor {

    /**
     * Check the correctness of email
     */
    public boolean checkIsEmail(String email) {
        return email.matches("[^ ]+@[^ ]+\\..[^ ]");
    }

    /**
     * Make sure that the welcome greeting of the form
     * Hi, Ivan Ivanov!
     * or
     * Hi, James Johnes!
     * I.e. it begins on Hi and ends with '!'
     * And contains 2 words (name and surname)
     * which are not shorter than 3 letters
     * And begin with a capital letter
     */
    public boolean checkGreeting(String greeting) {
        String regex = "Hi,\\s*?[A-Z].{3,} [A-Z].{3,}!";
        return greeting.matches(regex);
    }

    @Test
    public void testCheckGreeting() {
        assertTrue(checkGreeting("Hi, John Smith!"));
        assertTrue(checkGreeting("Hi,James Jones!"));
        assertTrue(checkGreeting("Hi, James Smith!"));
        assertTrue(checkGreeting("Hi, James Smith !"));
        assertTrue(checkGreeting("Hi,\tJames Smith !"));
        assertTrue(checkGreeting("Hi,\n\tJames Smith !"));

        assertFalse("In the beginning should be Hi and comma",
                checkGreeting("Hello, James Smith!"));
        assertFalse("Exclamation mark should be in the end",
                checkGreeting("Hi, James Smith"));
        assertFalse("The name is too short",
                checkGreeting("Hi, Li Soun!"));
        assertFalse("Surname is too short",
                checkGreeting("Hi, Dju Li!"));
        assertFalse("Name should include both name and surname",
                checkGreeting("Hi, Peter!"));
        assertFalse("The first letter of the name must be capital",
                checkGreeting("Hi, peter Gabriel!"));
        assertFalse("The first letter of the name must be capital",
                checkGreeting("Hi, Peter gabriel!"));
    }

    @Test
    public void testCheckIsEmail() {
        assertTrue(checkIsEmail("ivanov@mail.ru"));
        assertTrue(checkIsEmail("ivanov@mail.com.uk"));
        assertFalse(checkIsEmail("ivan ivanov@mail.com.uk"));
        assertFalse(checkIsEmail("ivanov@mailcom"));
    }
}