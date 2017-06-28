package com.mcnichol.training.java;

import java.util.List;

class FlashCardServiceImpl implements FlashCardService {

    private FlashServiceState state;
    private int currentQuizQuestionIndex = -1;
    private Quiz quiz;

    public FlashCardServiceImpl() {
        updateState(FlashServiceState.LOAD);
    }

    public FlashCardServiceImpl(Quiz quiz) {
        this();
        this.quiz = quiz;
        updateState(FlashServiceState.NEXT_QUESTION);
    }

    @Override
    public Question nextQuestion() {
        Question question = quiz.getCollection().get(++currentQuizQuestionIndex);

        updateState(FlashServiceState.MAKE_GUESS);

        return question;
    }

    @Override
    public String getQuestion() {
        return quiz.getCollection().get(currentQuizQuestionIndex).getQuestionText();
    }

    @Override
    public String getAnswer() {
        return quiz.getCollection().get(currentQuizQuestionIndex).getResponses().get(quiz.getCollection().get(currentQuizQuestionIndex).getAnswerIndex());
    }

    @Override
    public List<String> getResponses() {
        return quiz.getCollection().get(currentQuizQuestionIndex).getResponses();
    }

    @Override
    public FlashServiceState getState() {
        return state;
    }

    private void updateState(FlashServiceState updatedState) {
        state = updatedState;
    }
}