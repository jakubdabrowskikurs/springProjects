package models;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.regexandserial.models.UserRegisterInput;
import org.regexandserial.models.services.SerializationExercise;

import java.io.File;

import static org.junit.Assert.*;

public class SerializationExerciseTest {

    private static SerializationExercise serializationExercise;

    @BeforeClass public static void start() {
        serializationExercise = new SerializationExercise();
    }

    @AfterClass public static void stop() throws Exception {
        serializationExercise = null;
    }


    @Test public void saveTest() throws Exception {
        File file = new File("fileTest.txt");
        UserRegisterInput user1 = new UserRegisterInput("Jan", "Kowalski", "jankowal@mail.com", "Centrum 2", "SecretPassword123!!!");
        serializationExercise.saveObject(file, user1);
        assertNotEquals(serializationExercise.loadObject(file).toString(), user1.toString());
        user1.setPassword(null);
        assertEquals(serializationExercise.loadObject(file).toString(), user1.toString());
        if (file.exists()){
            file.delete();
        }
    }
}