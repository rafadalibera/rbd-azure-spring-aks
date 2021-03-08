package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DemoController {

    @GetMapping("/test")
    public ResponseEntity<String> testGet() {
        return ResponseEntity.ok().body("Hello!");
    }

}
