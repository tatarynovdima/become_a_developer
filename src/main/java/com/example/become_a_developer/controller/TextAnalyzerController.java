package com.example.become_a_developer.controller;

import com.example.become_a_developer.repository.TextAnalyzerRepositoryImpl;
import com.example.become_a_developer.service.TextAnalyzerServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/analyzer")
public class TextAnalyzerController {
    private final TextAnalyzerServiceImpl textAnalyzerService;
    private final TextAnalyzerRepositoryImpl textAnalyzerRepository;

    public TextAnalyzerController(TextAnalyzerServiceImpl textAnalyzerService, TextAnalyzerRepositoryImpl textAnalyzerRepository) {
        this.textAnalyzerService = textAnalyzerService;
        this.textAnalyzerRepository = textAnalyzerRepository;
    }


    @GetMapping("")
    public String getText(){
        return textAnalyzerService.findUniqueCharacter();
    }

    @PostMapping("/analyzessss")
    public String analyzeText(@RequestBody String text) {
        textAnalyzerRepository.setText(text);
        return "Анализ текста: " + text;
    }
}
