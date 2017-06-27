package com.mcnichol.training.java;

class FlashCardServiceImpl implements FlashCardService {

    private CardDeck cardDeck;

    public FlashCardServiceImpl(CardDeck cardDeck) {
        this.cardDeck = cardDeck;
    }

    @Override
    public Question nextQuestion() {
        return cardDeck.getCard();
    }
}