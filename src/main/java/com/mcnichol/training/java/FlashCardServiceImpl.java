package com.mcnichol.training.java;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

import static com.mcnichol.training.java.FlashServiceState.*;

@Component
class FlashCardServiceImpl implements FlashCardService {

    private FlashServiceState state;
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private Question currentQuestion;

    public FlashCardServiceImpl() {
        updateState(LOAD);
    }

    public FlashCardServiceImpl(Quiz quiz) {
        this();
        this.questions = quiz.getCollection();
        updateState(NEXT_QUESTION);
    }

    @Override
    public Question nextQuestion() {
        if (currentQuestionIndex >= questions.size()) {
            updateState(FINISHED);
            return Question.builder().build();
        }

        currentQuestion = questions.get(currentQuestionIndex++);

        updateState(MAKE_GUESS);

        return currentQuestion;
    }

    @Override
    public String getQuestion() {
        return currentQuestion.getQuestionText();
    }

    @Override
    public String getAnswer() {
        return currentQuestion.getResponses().get(currentQuestion.getAnswerIndex());
    }

    @Override
    public List<String> getResponses() {
        return currentQuestion.getResponses();
    }

    @Override
    public Response makeGuess(Integer guessIndex) {
        return Response.builder()
                .isCorrect(Objects.equals(guessIndex, currentQuestion.getAnswerIndex()))
                .build();
    }

    @Override
    public FlashServiceState getState() {
        return state;
    }

    private void updateState(FlashServiceState updatedState) {
        state = updatedState;
    }
}