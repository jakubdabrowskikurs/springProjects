package org.regexandserial.models.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    public static String path = "C:\\Users\\dabroj1\\Desktop\\Kuba\\29,11\\AK_Spring_Exercise_SerializableRegex\\src\\main\\resources\\serializable";

    public static void main(String[] args) throws IOException {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        System.out.println(listOfFiles.length);

        try (Stream<Path> paths = Files.walk(Paths.get(path))) {
            paths.filter(Files::isRegularFile).forEach(System.out::println);
        }
    }
}