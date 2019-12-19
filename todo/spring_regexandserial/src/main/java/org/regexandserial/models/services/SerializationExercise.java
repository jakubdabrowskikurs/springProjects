package org.regexandserial.models.services;

import org.regexandserial.models.UserRegisterInput;
import org.springframework.stereotype.Service;
import java.io.*;

@Service
public class SerializationExercise {

    public void saveObject(File file, UserRegisterInput object){
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(object);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public UserRegisterInput loadObject(File file){
        UserRegisterInput object = new UserRegisterInput();
        if (!file.exists()){
            throw new IllegalArgumentException("File not exist!");
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            object = (UserRegisterInput)ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}
