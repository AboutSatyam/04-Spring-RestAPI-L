package com.satyam._4resttouristmanageapi.rest;

import com.satyam._4resttouristmanageapi.exception.TouristNotFoundException;
import com.satyam._4resttouristmanageapi.model.Tourist;
import com.satyam._4resttouristmanageapi.service.ITouristService;
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
        try {
            Tourist tourist = service.fetchTouristById(id);
            return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
        } catch (TouristNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/getalltourist")
    public ResponseEntity<?> getAllTourist() {
        try {
            List<Tourist> tourists = service.fetchAllTouristinfo();
            return new ResponseEntity<List>(tourists, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Some Problem In Fetch", HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
}
