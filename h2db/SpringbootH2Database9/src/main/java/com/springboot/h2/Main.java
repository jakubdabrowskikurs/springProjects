package com.springboot.h2;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String imagePath = "src/main/resources/static/images/a1.png";
        try {
            BufferedImage myPicture = ImageIO.read(new File(imagePath));
            System.out.println(myPicture);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
