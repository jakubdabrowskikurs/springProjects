package org.regexandserial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.regexandserial.models.services.SerializationExercise;

import java.io.File;

@Controller
public class SerialController {


    @Autowired
    private SerializationExercise serializationExercise;
    private File file = new File("fileTest.txt");

    @GetMapping("/ser")
    public String serialGet(Model model) {
        if (file.exists() && serializationExercise.loadObject(file).getName() != null) {
            model.addAttribute("message", "Last Registered Object:");
            model.addAttribute("loadedLastObject", serializationExercise.loadObject(file).toString());
        } else {
            model.addAttribute("message", "No user has been registered.. Go to '/reg' and register user..");
        }
        return "serial";
    }
}