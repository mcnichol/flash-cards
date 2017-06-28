package com.mcnichol.training.java;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class Question {
    int id;
    String category;
    List<String> keywords;

    String questionText;
    boolean questionHasCode;
    String questionImageUrl;

    List<String> responses;

    Integer answerIndex;
    String answerExplanation;
}