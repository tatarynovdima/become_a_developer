package com.example.become_a_developer.controller;

import com.example.become_a_developer.repository.TextAnalyzerRepositoryImpl;
import com.example.become_a_developer.service.TextAnalyzerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/")
public class TextAnalyzerController {
    private final TextAnalyzerServiceImpl textAnalyzerService;
    private final TextAnalyzerRepositoryImpl textAnalyzerRepository;

    public TextAnalyzerController(TextAnalyzerServiceImpl textAnalyzerService, TextAnalyzerRepositoryImpl textAnalyzerRepository) {
        this.textAnalyzerService = textAnalyzerService;
        this.textAnalyzerRepository = textAnalyzerRepository;
    }
    @GetMapping("/analyze")
    public String showAnalyzePage() {
        return "index";
    }

    @PostMapping("/analyze")
    @ResponseBody
    public ResponseEntity<String> analyzeText(@RequestBody Map<String, String> requestBody) {
        String text = requestBody.get("text");
        textAnalyzerRepository.setText(text);
        String uniqueCharacter = textAnalyzerService.findUniqueCharacter();
        return ResponseEntity.ok(uniqueCharacter != null ? uniqueCharacter : "No unique character found");
    }
}