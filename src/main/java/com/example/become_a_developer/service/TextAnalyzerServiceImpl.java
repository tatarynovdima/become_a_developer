package com.example.become_a_developer.service;

import com.example.become_a_developer.repository.TextAnalyzerRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TextAnalyzerServiceImpl implements TextAnalyzerService{
    private final TextAnalyzerRepository textAnalyzerRepository;

    public TextAnalyzerServiceImpl(TextAnalyzerRepository textAnalyzerRepository) {
        this.textAnalyzerRepository = textAnalyzerRepository;
    }

    @Override
    public String getText() {
        return textAnalyzerRepository.getText();
    }

    public String findUniqueCharacter() {
        String text = getText();

        Map<Character, Integer> characterCount = new LinkedHashMap<>();

        for (char c : text.toCharArray()) {
            characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : characterCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey().toString().toLowerCase();
            }
        }
        return null;
    }


}