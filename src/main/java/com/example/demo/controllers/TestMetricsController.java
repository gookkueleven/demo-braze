package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo/metrix")
public class TestMetricsController {

    @GetMapping
    public ResponseEntity doNothing() {
        return ResponseEntity.ok().build();
    }

}
