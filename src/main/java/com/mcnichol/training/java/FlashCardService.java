package com.mcnichol.training.java;

import java.util.List;

public interface FlashCardService {
    Question nextQuestion();

    FlashServiceState getState();

    String getQuestion();

    String getAnswer();

    List<String> getResponses();
}
