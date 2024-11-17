package com.example.demo.bo;

import com.example.demo.enums.SuggestionStatus;

public class CreateSuggestionRequest {
    private String suggestionText;
    private int rate;
    private String status;

    public CreateSuggestionRequest(String suggestionText, int rate, String status) {
        this.suggestionText = suggestionText;
        this.rate = rate;
        this.status = status;
    }

    public String getSuggestionText() {
        return suggestionText;
    }

    public void setSuggestionText(String suggestionText) {
        this.suggestionText = suggestionText;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
