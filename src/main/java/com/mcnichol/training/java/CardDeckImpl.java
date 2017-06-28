package com.mcnichol.training.java;

public class CardDeckImpl implements CardDeck {
    boolean isEmpty = true;

    @Override
    public Question getCard() {
        return null;
    }

    @Override
    public boolean hasCards() {
        return !isEmpty;
    }

    @Override
    public void loadQuiz(Quiz quiz) {
        isEmpty = false;
    }
}