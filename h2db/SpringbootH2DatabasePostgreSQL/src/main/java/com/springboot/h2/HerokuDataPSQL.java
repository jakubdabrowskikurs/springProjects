package com.springboot.h2;

import java.net.URI;
import java.net.URISyntaxException;

public class HerokuDataPSQL {

    public static void main(String[] args) throws URISyntaxException {
        //TODO LINK Z HEROKU
        //TODO DEPENDENCY
        //TODO PROPERTIES
        URI dbUri = new URI("postgres://mutcpxoggvfnyc:ebcb7793c6de62c22b058595b05b8e01ff4f83de6db2f2677481946d22d2ddfd@ec2-54-247-96-169.eu-west-1.compute.amazonaws.com:5432/d1tjug5h1o8q5o");

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
        System.out.println(dbUrl);
        System.out.println(username);
        System.out.println( password);
    }
}
