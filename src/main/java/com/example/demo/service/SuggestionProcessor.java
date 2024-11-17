package com.example.demo.service;

import com.example.demo.entity.GuestSuggestionEntity;

@FunctionalInterface
public interface SuggestionProcessor {
    void suggestionText(String text);
}
