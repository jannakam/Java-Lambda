package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class GuestSuggestionEntity {
    @Id
    @GeneratedValue
    private Long id;

    private int rate;
    private String suggestionText;


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
