package com.example.become_a_developer.repository;


import org.springframework.stereotype.Repository;

@Repository
public class TextAnalyzerRepositoryImpl implements TextAnalyzerRepository {
    @Override
    public String getText() {
        return MockText();
    }
    private String MockText(){
        return "The Tao gave birth to machine language.  Machine language gave birth\n" +
                "to the assembler.\n" +
                "The assembler gave birth to the compiler.  Now there are ten thousand\n" +
                "languages.\n" +
                "Each language has its purpose, however humble.  Each language\n" +
                "expresses the Yin and Yang of software.  Each language has its place within\n" +
                "the Tao.\n" +
                "But do not program in COBOL if you can avoid it.\n" +
                "        -- Geoffrey James, \"The Tao of Programming\"";
    }
}
