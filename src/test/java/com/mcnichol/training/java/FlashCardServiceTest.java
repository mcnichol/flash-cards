package com.mcnichol.training.java;

import com.google.gson.Gson;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FlashCardServiceTest {

    @Test
    public void repliesWithQuestionFromCardDeck() throws Exception {
        CardDeck mockCardDeck = new TestCardDeck();
        FlashCardService flashCardService = new FlashCardServiceImpl(mockCardDeck);

        Question actualQuestion = flashCardService.nextQuestion();

        assertThat(actualQuestion.getQuestionText(), equalTo("testQuestion"));
    }

    private class TestCardDeck implements CardDeck {
        @Override
        public Question getCard() {

            Gson gson = new Gson();
            Quiz quiz = null;
            try {
                quiz = gson.fromJson(new FileReader("src/test/resources/java/test-questions.json"), Quiz.class);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            return quiz != null ? quiz.getCollection().get(0) : null;
        }
    }
}