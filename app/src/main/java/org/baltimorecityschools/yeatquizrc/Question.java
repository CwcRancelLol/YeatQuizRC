package org.baltimorecityschools.yeatquizrc;

public class Question {
    private String questionText;
    private boolean isCorrect;

    private boolean answer;

    public Question(){
        questionText = "";
        isCorrect = false;
        answer = false;
    }

    public Question(String nQuestion, boolean nIsCorrect, boolean nAnswer){
        questionText = nQuestion;
        isCorrect = nIsCorrect;
        answer = nAnswer;
    }

    public String getQuestion(){
        return questionText;
    }
    public boolean getIsCorrect(){
        return isCorrect;
    }

    public boolean getnAnswer(){
        return answer;
    }

    public void setQuestion(String newQuestion){
        questionText = newQuestion;
    }

    public void setIsCorrect(boolean newIsCorrect){
        isCorrect = newIsCorrect;
    }

    public void setnAnswer(boolean newAnswer){
        answer = newAnswer;
    }



}

