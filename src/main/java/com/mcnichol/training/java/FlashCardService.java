package com.mcnichol.training.java;

public interface FlashCardService {
    Question nextQuestion();

    FlashServiceState getState();

    String getQuestion();

    String getAnswer();
}
