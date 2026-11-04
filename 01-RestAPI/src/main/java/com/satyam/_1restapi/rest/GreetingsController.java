package com.satyam._1restapi.rest;

import com.satyam._1restapi.service.IGreetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api1")
public class GreetingsController {
    @Autowired
    private IGreetings greetings;

    @GetMapping("/greet")
    @ResponseBody
    public ResponseEntity<String> getWishes() {
        String res = greetings.generateWish(" Satyam ");
        return new ResponseEntity<String>(res, HttpStatus.OK);
    }

}
