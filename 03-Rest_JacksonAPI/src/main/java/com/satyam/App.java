package com.satyam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.satyam.model.Alien;

import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Object Created ");

        ObjectMapper mapper = new ObjectMapper();
        Alien alien = mapper.readValue(new File("json/sample.json"), Alien.class);
        System.out.println(alien);

    }
}
