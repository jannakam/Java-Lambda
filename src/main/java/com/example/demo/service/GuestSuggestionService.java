package com.example.demo.service;

import com.example.demo.bo.UserResponse;
import com.example.demo.entity.GuestSuggestionEntity;

import java.util.List;

public interface GuestSuggestionService {
    void processSuggestion(String text, int rate);
    List<GuestSuggestionEntity> getAllSuggestions();

}
