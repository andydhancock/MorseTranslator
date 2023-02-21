import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MorseTranslatorTest {

    private MorseCodeTranslator morseCodeTranslator;

    @BeforeEach
    public void setUp() {
        morseCodeTranslator = new MorseCodeTranslator();
    }

    @Test
    public void testToMorseCode() {
        String morseCode = morseCodeTranslator.toMorseCode("HELLO WORLD");
        Assertions.assertEquals("**** * *-** *-** ---    *-- --- *-* *-** -**", morseCode);
    }

    @Test
    public void testToEnglish() {
        String english = morseCodeTranslator.toEnglish("**** * *-** *-** ---    *-- --- *-* *-** -**");
        Assertions.assertEquals("HELLO WORLD", english);
    }

    @Test
    public void testToEnglishInvalidMorseCode() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> morseCodeTranslator.toEnglish("*-*-"));
    }

    @Test
    public void testToMorseCodeInvalidEnglish() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> morseCodeTranslator.toMorseCode("ÅÅÅÅÅÅÅÅÅÅÅÅÅ!"));
    }

}
