package com.example.demo.controllers;

import com.example.demo.models.request.TestValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/demo/metrix")
public class TestMetricsController {

    @GetMapping
    public ResponseEntity doNothing() {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity testCustomValidator(@Valid @RequestBody TestValidator testValidator) {
        return ResponseEntity.ok(testValidator.getStringList());
    }
}
