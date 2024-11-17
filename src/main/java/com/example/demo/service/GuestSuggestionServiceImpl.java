package com.example.demo.service;

import com.example.demo.entity.GuestSuggestionEntity;
import com.example.demo.enums.SuggestionStatus;
import com.example.demo.repository.GuestSuggestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestSuggestionServiceImpl implements GuestSuggestionService {

    private final GuestSuggestionRepository guestSuggestionRepository;

    public GuestSuggestionServiceImpl(GuestSuggestionRepository guestSuggestionRepository) {
        this.guestSuggestionRepository = guestSuggestionRepository;
    }

    @Override
    public void processSuggestion(String suggestion, int rate, String status) {

        SuggestionProcessor processor = text -> {

            GuestSuggestionEntity newSuggestion = new GuestSuggestionEntity();
            newSuggestion.setSuggestionText(text);
            newSuggestion.setRate(rate);
            newSuggestion.setStatus(SuggestionStatus.valueOf(status.toUpperCase()));

            guestSuggestionRepository.save(newSuggestion);
            System.out.println("Processed and saved suggestion: " + newSuggestion.getSuggestionText());
        };


        processor.suggestionText(suggestion);
    }

    @Override
    public List<GuestSuggestionEntity> getAllSuggestions() {
        return guestSuggestionRepository.findAll();

    }

    @Override
    public List<GuestSuggestionEntity> findAllCreatedSuggestions() {
        return guestSuggestionRepository.findAll().stream().filter(guestSuggestionEntity -> guestSuggestionEntity.getStatus().equals(SuggestionStatus.CREATE)).collect(Collectors.toList());
    }

    @Override
    public List<GuestSuggestionEntity> findAllRemovedSuggestions() {
        return guestSuggestionRepository.findAll().stream().filter(guestSuggestionEntity -> guestSuggestionEntity.getStatus().equals(SuggestionStatus.REMOVE)).collect(Collectors.toList());
    }

}
