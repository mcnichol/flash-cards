package com.mcnichol.training.java;

public interface CardDeck {
    Question getCard();

    boolean hasCards();

    void loadQuiz(Quiz quiz);
}
