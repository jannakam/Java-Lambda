package com.example.demo.bo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class UserResponse {

    private Long id;
    private int rate;
    private String suggestionText;

    public UserResponse(Long id, int rate, String suggestionText) {
        this.rate = rate;
        this.suggestionText = suggestionText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getSuggestionText() {
        return suggestionText;
    }

    public void setSuggestionText(String suggestionText) {
        this.suggestionText = suggestionText;
    }
}
