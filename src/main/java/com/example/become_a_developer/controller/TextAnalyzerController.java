package com.example.become_a_developer.controller;

import com.example.become_a_developer.repository.TextAnalyzerRepositoryImpl;
import com.example.become_a_developer.service.TextAnalyzerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Controller
@RequestMapping("/")
public class TextAnalyzerController {
    private final TextAnalyzerServiceImpl textAnalyzerService;
    private final TextAnalyzerRepositoryImpl textAnalyzerRepository;
    private static final Logger LOGGER = Logger.getLogger(TextAnalyzerController.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("log.txt");

            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);

            LOGGER.addHandler(fileHandler);

            LOGGER.setLevel(Level.ALL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
        try {
            String text = requestBody.get("text");
            textAnalyzerRepository.setText(text);
            String uniqueCharacter = textAnalyzerService.findUniqueCharacter();

            LOGGER.info("Unique character: " + (uniqueCharacter != null ? uniqueCharacter : "Not found"));

            return ResponseEntity.ok(uniqueCharacter != null ? uniqueCharacter : "No unique character found");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error analyzing text", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }
}