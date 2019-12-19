package models;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.regexandserial.models.services.RegexExercise;
import static org.junit.Assert.*;

public class RegexExerciseTest {

    private static RegexExercise regexExercise;

    @BeforeClass public static void start() {
        regexExercise = new RegexExercise();
    }

    @AfterClass public static void stop() throws Exception {
        regexExercise = null;
    }

    @Test public void emailValidationText() throws Exception {
        assertTrue(regexExercise.isEmailAddress("example@gmail.com"));
        assertTrue(regexExercise.isEmailAddress("Maresowa@gmail.com"));
        assertTrue(regexExercise.isEmailAddress("student@university.edu.pl"));
        assertTrue(regexExercise.isEmailAddress("example.example1969@com.com"));
        assertTrue(regexExercise.isEmailAddress("11112222kitty.kit@kitty.edu.com"));
        assertFalse(regexExercise.isEmailAddress("example@example@domain.com"));
        assertFalse(regexExercise.isEmailAddress("example!example@domain.com"));
        assertFalse(regexExercise.isEmailAddress("example#example@domain.com"));
        assertFalse(regexExercise.isEmailAddress("example@.domain.com"));
        assertFalse(regexExercise.isEmailAddress("example.@domain.com"));
        assertFalse(regexExercise.isEmailAddress("example@com"));
        assertFalse(regexExercise.isEmailAddress("example@one.two.three.4"));
        assertFalse(regexExercise.isEmailAddress("example.com.pl"));
        assertFalse(regexExercise.isEmailAddress("@abc.com"));
        assertFalse(regexExercise.isEmailAddress("example@444.22"));
        assertFalse(regexExercise.isEmailAddress("example@!com.pl"));
    }


    @Test public void passwordStrengthTest() throws Exception {
        assertTrue(regexExercise.isPasswordSecure("pAsswoRd1#"));
        assertTrue(regexExercise.isPasswordSecure("Omomom1.2.3.4.5$omomom"));
        assertTrue(regexExercise.isPasswordSecure("AaAa8^8BbBb"));
        assertTrue(regexExercise.isPasswordSecure("Rj6-K93-%4X-002"));
        assertFalse(regexExercise.isPasswordSecure("passworf1#"));
        assertFalse(regexExercise.isPasswordSecure("123"));
        assertFalse(regexExercise.isPasswordSecure("extra password"));
        assertFalse(regexExercise.isPasswordSecure("Extra1Password"));
        assertFalse(regexExercise.isPasswordSecure("password#$%^&&**!234"));
        assertFalse(regexExercise.isPasswordSecure("!hidden!"));
        assertFalse(regexExercise.isPasswordSecure("29.02.1919"));
    }


    @Test public void streetTest() throws Exception {
        assertTrue(regexExercise.isStreetCorrected("Krakowska 1/2"));
        assertTrue(regexExercise.isStreetCorrected("Krakowska 2"));
        assertTrue(regexExercise.isStreetCorrected("Krakowska 2B"));
        assertTrue(regexExercise.isStreetCorrected("Krakowska 17/17"));
        assertTrue(regexExercise.isStreetCorrected("Stara Krakowska 17/17"));
        assertFalse(regexExercise.isStreetCorrected("Centrum"));
        assertFalse(regexExercise.isStreetCorrected("zielonego wzgorza"));
        assertFalse(regexExercise.isStreetCorrected("BardzoDlugaUlica4"));
        assertFalse(regexExercise.isStreetCorrected("1234"));
        assertFalse(regexExercise.isStreetCorrected("Ulica jakas tam..."));
    }


    @Test public void nameValidator() throws Exception {
        assertTrue(regexExercise.isProperName("Jan"));
        assertTrue(regexExercise.isProperName("Anna"));
        assertFalse(regexExercise.isProperName("jan marian"));
        assertFalse(regexExercise.isProperName("anna"));
        assertFalse(regexExercise.isProperName("1234"));
        assertFalse(regexExercise.isProperName("Ann@na"));
    }


    @Test public void fullNameValidator() throws Exception {
        assertTrue(regexExercise.isProperSurname("Kowalski"));
        assertTrue(regexExercise.isProperSurname("Kowalski-Nowak"));
        assertFalse(regexExercise.isProperSurname("Kowalski-Nowak-"));
        assertFalse(regexExercise.isProperSurname("KowalskiNowak"));
        assertFalse(regexExercise.isProperSurname("Kowalski123Nowak"));
        assertFalse(regexExercise.isProperSurname("name"));
    }
}