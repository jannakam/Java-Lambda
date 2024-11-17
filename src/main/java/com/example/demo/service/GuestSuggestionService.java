package com.example.demo.service;

import com.example.demo.entity.GuestSuggestionEntity;
import com.example.demo.enums.SuggestionStatus;

import java.util.List;

public interface GuestSuggestionService {
    void processSuggestion(String text, int rate, String status);
    List<GuestSuggestionEntity> getAllSuggestions();
    List<GuestSuggestionEntity> findAllCreatedSuggestions();
    List<GuestSuggestionEntity> findAllRemovedSuggestions();


}
