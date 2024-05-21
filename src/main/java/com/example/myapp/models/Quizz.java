package com.example.myapp.models;

import java.util.List;

public class Quizz {
    private String question;
    private List<String> options;
    private int answerIndex;

    public Quizz(String question, List<String> options, int answerIndex) {
        this.question = question;
        this.options = options;
        this.answerIndex = answerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }
}
