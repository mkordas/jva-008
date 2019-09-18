import static org.junit.Assert.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegExpTutor extends Tutor {

    class Email {
        String name;
        String domainName;
        String domainZone;
    }

    public Email getEmail(String emailString) {
        //String regex = "[a-z0-9\\.*]{2,}?@[a-z]{2,}?\\.[a-z]{2,}";
        String regex = "[@\\.]";
        String[] strSpl = emailString.split(regex);
        Email email = new Email();
        email.name = strSpl[0];
        email.domainName = strSpl[1];
        email.domainZone = strSpl[2];
        return email;
    }

    /**
     * Returns a list of lines by text representation of the lines.
     * Takes a string
     * "List of animals: cow, goose, cat, dog, elephant, rabbit,
     * snake, chicken, horse, human."
     * And returns an array of animals
     */
    public String[] getAnimalsArray(String animalsString) {
        String firstregex = "[:][ ]";

        String[] temp = animalsString.split(firstregex);
        String secondregex = "[,] ?|\\.";
        String[] animalsList = temp[1].split(secondregex);
        return animalsList;
    }

    @Test
    public void testGetEmail() {
        Email email = getEmail("ivanov@mail.ru");
        assertEquals("ivanov", email.name);
        assertEquals("mail", email.domainName);
        assertEquals("ru", email.domainZone);

    }

    @Test
    public void testGetAnimalsArray() {
        String [] animals =
                {"Cow", "Goose", "Cat", "Dog", "Elephant",
                        "Rabbit", "Snake", "Chicken", "Horse", "Human"};
        String animalsString =
                "List of animals: Cow, Goose, Cat, Dog, Elephant," +
                        "Rabbit, Snake, Chicken, Horse, Human.";
        assertArrayEquals(animals, getAnimalsArray(animalsString));
    }

}
