package com.satyam._5resttouristmanageapiglobalexcep.rest;

import com.satyam._5resttouristmanageapiglobalexcep.model.Tourist;
import com.satyam._5resttouristmanageapiglobalexcep.service.ITouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TouristRestApi {
    @Autowired
    private ITouristService service;

    @PostMapping("/regTourist")
    public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist) {
        String response = service.registerTourist(tourist);
        return new ResponseEntity<String>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getTourist/{id}")
    public ResponseEntity<?> getTourist(@PathVariable("id") Integer id) {

        Tourist tourist = service.fetchTouristById(id);
        return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);


    }

    @GetMapping("/getalltourist")
    public ResponseEntity<?> getAllTourist() {
        List<Tourist> tourists = service.fetchAllTouristinfo();
        return new ResponseEntity<List>(tourists, HttpStatus.OK);


    }

    @PutMapping("/updatetourist")
    public ResponseEntity<String> updateTheTourist(@RequestBody Tourist tourist) {

        String status = service.updateTheTouristInfo(tourist);
        return new ResponseEntity<String>(status, HttpStatus.OK);


    }

    @PatchMapping("/updatetouristbudget/{id}/{budget}")
    public ResponseEntity<String> updateTheTouristBudget(@PathVariable("id") Integer id, @PathVariable("budget") Double budget) {

        String status = service.updateTheTouristBudget(id, budget);
        return new ResponseEntity<String>(status, HttpStatus.OK);

    }


    @DeleteMapping("/deletetourist/{id}")
    public ResponseEntity<String> deleteTheTourist(@PathVariable("id") Integer id) {

        String status = service.deleteTheTouristInfoById(id);
        return new ResponseEntity<String>(status, HttpStatus.OK);

    }
}
