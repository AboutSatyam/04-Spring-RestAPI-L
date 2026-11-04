package com.satyam._1restapi.service;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class GreetingsService implements IGreetings {


//    @Autowired
//    private LocalTime time;

    @Override
    public String generateWish(String name) {

        LocalTime time = LocalTime.now(); // Tempor Making Object
        int hour = time.getHour();
        if (hour < 12)
            return "Good Morning " + name;

        else if (hour < 16)
            return "Good Afternoon " + name;
        else if (hour < 20)
            return "Good Evening " + name;
        else
            return " Good Night" + name;
    }
}
