package com.example.demo.controller;

import com.example.demo.bo.CreateSuggestionRequest;
import com.example.demo.bo.UserResponse;
import com.example.demo.entity.GuestSuggestionEntity;
import com.example.demo.service.GuestSuggestionService;
import com.example.demo.service.GuestSuggestionServiceImpl;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SuggestionController {

    private final GuestSuggestionService guestSuggestionService;

    // Constructor-based Dependency Injection
    public SuggestionController(GuestSuggestionService guestSuggestionService) {
        this.guestSuggestionService = guestSuggestionService;
    }

    @PostMapping("/receive")
    public ResponseEntity<Object> receiveSuggestion(@RequestBody CreateSuggestionRequest request) {
        try {
            guestSuggestionService.processSuggestion(request.getSuggestionText(), request.getRate());

            return ResponseEntity.status(HttpStatus.CREATED).body("Suggestion processed successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to process suggestion: " + e.getMessage());
        }
    }

    @GetMapping("/getSuggestions")
    public List<GuestSuggestionEntity> getSuggestions() {
        return guestSuggestionService.getAllSuggestions();

    }

}


