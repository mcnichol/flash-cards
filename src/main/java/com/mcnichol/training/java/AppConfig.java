package com.mcnichol.training.java;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Configuration
public class AppConfig {

    @Bean
    public FlashCardService flashCardService() {

        Quiz quiz = null;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/static/questions/java/01_basics.json"))) {
            quiz = new Gson().fromJson(br, Quiz.class);
        } catch (IOException ignored) {

        }

        return new FlashCardServiceImpl(quiz);
    }
}
