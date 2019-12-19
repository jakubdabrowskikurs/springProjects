package org.regexandserial.models.services;

import org.springframework.stereotype.Service;
import org.regexandserial.models.UserRegisterInput;

import java.io.*;

@Service
public class SerializationExercise {

    public void saveObject(File file, UserRegisterInput object){
        //todo create file
        //todo write object into file
    }

    public UserRegisterInput loadObject(File file){
        //todo load object from file
        return new UserRegisterInput();
    }

}
