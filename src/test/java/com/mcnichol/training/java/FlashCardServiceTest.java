package com.mcnichol.training.java;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FlashCardServiceTest {
    private FlashCardService flashCardService;

    @Before
    public void setUp() throws Exception {
        Quiz testQuiz = new Gson().fromJson(new BufferedReader(new FileReader("src/test/resources/java/test-questions.json")), Quiz.class);
        flashCardService = new FlashCardServiceImpl(testQuiz);
    }

    @Test
    public void initializingService_stateIs_LOAD() throws Exception {
        FlashCardService emptyFlashCardService = new FlashCardServiceImpl();

        assertThat(emptyFlashCardService.getState(), equalTo(FlashServiceState.LOAD));
    }

    @Test
    public void afterLoadingQuiz_stateIs_NEXT_QUESTION() throws Exception {

        assertThat(flashCardService.getState(), equalTo(FlashServiceState.NEXT_QUESTION));
    }

    @Test
    public void retrieveQuestion_stateIs_MAKE_GUESS() throws Exception {

        flashCardService.nextQuestion();

        assertThat(flashCardService.getState(), equalTo(FlashServiceState.MAKE_GUESS));
    }

    @Test
    public void retrievesCurrentQuestion() throws Exception {

        flashCardService.nextQuestion();

        assertThat(flashCardService.getQuestion(), equalTo("test-question-1"));
    }

    @Test
    public void retrievesPossibleAnswersToCurrentQuestion() throws Exception {

        Question question = flashCardService.nextQuestion();

        assertThat(flashCardService.getResponses(), equalTo(question.getResponses()));
    }

    @Test
    public void manuallyAdvanceToNextQuestion() throws Exception {

        flashCardService.nextQuestion();
        flashCardService.nextQuestion();

        assertThat(flashCardService.getQuestion(), equalTo("test-question-2"));
    }

    @Test
    public void retrievesAnswer() throws Exception {
        assertThat(flashCardService.getState(), equalTo(FlashServiceState.NEXT_QUESTION));
        Question actualQuestion = flashCardService.nextQuestion();

        assertThat(flashCardService.getAnswer(), equalTo(actualQuestion.getResponses().get(actualQuestion.getAnswerIndex())));
    }
}