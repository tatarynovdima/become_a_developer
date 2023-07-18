package com.example.become_a_developer.repository;


import org.springframework.stereotype.Repository;

@Repository
public class TextAnalyzerRepositoryImpl implements TextAnalyzerRepository {
    private String text;

    @Override
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
