package com.badabdd.beautysal00n.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class SecurityController {

    @GetMapping
    public ResponseEntity<String> validateCredentials() {
        return ResponseEntity.ok("Authorized");
    }
}
