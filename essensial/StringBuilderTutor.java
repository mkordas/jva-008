import static org.junit.Assert.*;

import org.junit.Test;

public class StringBuilderTutor extends Tutor {

    String [] animals =
            {"Cow", "Goose", "Cat", "Dog", "Elephant",
                    "Rabbit", "Snake", "Chicken", "Horse", "Human"};

    /**
     * Method must return a string:
     * "Animal list: Cow, Goose, ..., Human."
     * For implementation use StringBuilder
     */
    public String getAnimalsString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Animal list:");
        for(int i =0; i<animals.length-1; i++) {
            sb.append(" ")
                    .append(animals[i])
                    .append(",");
        }
        sb.append(" ")
                .append(animals[animals.length-1])
                .append(".");
        return sb.toString();
    }

    @Test
    public void testGetAnimalsString() {
        String animalsString = getAnimalsString();
        assertEquals("Animal list: Cow, Goose, Cat, Dog, Elephant, "+
                "Rabbit, Snake, Chicken, Horse, Human.", animalsString);
    }

}
