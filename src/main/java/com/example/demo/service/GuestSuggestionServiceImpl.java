package com.example.demo.service;

import com.example.demo.bo.CreateSuggestionRequest;
import com.example.demo.bo.UserResponse;
import com.example.demo.entity.GuestSuggestionEntity;
import com.example.demo.repository.GuestSuggestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestSuggestionServiceImpl implements GuestSuggestionService {

    private final GuestSuggestionRepository guestSuggestionRepository;

    public GuestSuggestionServiceImpl(GuestSuggestionRepository guestSuggestionRepository) {
        this.guestSuggestionRepository = guestSuggestionRepository;
    }

    @Override
    public void processSuggestion(String suggestion, int rate) {

        SuggestionProcessor processor = text -> {

            GuestSuggestionEntity newSuggestion = new GuestSuggestionEntity();
            newSuggestion.setSuggestionText(text);
            newSuggestion.setRate(rate);

            guestSuggestionRepository.save(newSuggestion);
            System.out.println("Processed and saved suggestion: " + newSuggestion.getSuggestionText());
        };


        processor.suggestionText(suggestion);
    }


    @Override
    public List<GuestSuggestionEntity> getAllSuggestions() {
        return guestSuggestionRepository.findAll();

    }

}
