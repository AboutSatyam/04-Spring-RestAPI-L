package com.satyam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.satyam.model.Alien;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("Object Created ");

        Alien alien = new Alien(26, "Satyam", "Mumbai");
        Alien alien1 = new Alien(24, "Kunal", "Mumbai");
        Alien alien2 = new Alien(27, "ADI", "Mumbai");
        List<Alien> aliens = Arrays.asList(alien, alien1, alien2);

        System.out.println(aliens);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(aliens);
        System.out.println(json);
    }
}
