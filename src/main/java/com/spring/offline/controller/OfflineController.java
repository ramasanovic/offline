package com.spring.offline.controller;

import com.spring.offline.model.Airport;
import com.spring.offline.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "spring/offline")
public class OfflineController {

    @GetMapping(value = "/getAirports")
    public ResponseEntity<List<Airport>> getAirports() {
        List<Airport> res = new ArrayList<>();
        res.add(new Airport("Adana Şakirpaşa Havalimanı", "ADA"));
        res.add(new Airport("Ankara Esenboğa Havalimanı", "ESB"));
        res.add(new Airport("Antalya Havalimanı", "AYT"));
        res.add(new Airport("İstanbul Havalimanı", "IST"));
        res.add(new Airport("Sabiha Gökçen Havalimanı", "SAW"));
        res.add(new Airport("Dalaman Havalimanı", "DLM"));
        return ResponseEntity.ok(res);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        if (user.getUsername().equals("off_user") && user.getPassword().equals("off_pass")) {
            return ResponseEntity.ok("{\"res\" : \"OK\"}");
        }
        return new ResponseEntity<>("{\"res\" : \"DENIED\"}", HttpStatus.UNAUTHORIZED);
    }

}
