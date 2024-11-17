package com.example.demo.controller;

import com.example.demo.entity.GuestSuggestionEntity;
import com.example.demo.service.GuestSuggestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class SuggestionStatusController {

    private final GuestSuggestionService guestSuggestionService;

    public SuggestionStatusController(GuestSuggestionService guestSuggestionService) {
        this.guestSuggestionService = guestSuggestionService;
    }

    @GetMapping("/created")
    public List<GuestSuggestionEntity> getCreatedSuggestions() {
        return guestSuggestionService.findAllCreatedSuggestions();
    }

    @GetMapping("/removed")
    public List<GuestSuggestionEntity> getRemovedSuggestions() {
        return guestSuggestionService.findAllRemovedSuggestions();
    }
}
