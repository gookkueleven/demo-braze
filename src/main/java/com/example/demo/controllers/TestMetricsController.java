package com.example.demo.controllers;

import com.example.demo.models.request.TestValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

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

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    private ResponseEntity testExceptionHandler(MethodArgumentNotValidException ex, WebRequest request) {
        return ResponseEntity.badRequest().body(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
