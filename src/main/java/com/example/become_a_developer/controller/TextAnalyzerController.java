package com.example.become_a_developer.controller;

import com.example.become_a_developer.service.TextAnalyzerServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/analyzer")
public class TextAnalyzerController {
    private final TextAnalyzerServiceImpl textAnalyzerService;

    public TextAnalyzerController(TextAnalyzerServiceImpl textAnalyzerService) {
        this.textAnalyzerService = textAnalyzerService;
    }
    @GetMapping
    public String getText(){
        return textAnalyzerService.findUniqueCharacter();
    }
}
