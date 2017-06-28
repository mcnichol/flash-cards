package com.mcnichol.training.java;

import com.google.gson.Gson;
import org.junit.Test;

import java.io.FileReader;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CardDeckImplTest {

    @Test
    public void newCardDecksHaveNoCards() throws Exception {
        CardDeckImpl cardDeck = new CardDeckImpl();

        assertFalse(cardDeck.hasCards());
    }

    @Test
    public void canLoadADeckOfCards() throws Exception {
        CardDeck cardDeck = new CardDeckImpl();
        Quiz quiz = new Gson().fromJson(new FileReader("src/test/resources/java/test-questions.json"), Quiz.class);

        cardDeck.loadQuiz(quiz);

        assertTrue(cardDeck.hasCards());
    }
}
