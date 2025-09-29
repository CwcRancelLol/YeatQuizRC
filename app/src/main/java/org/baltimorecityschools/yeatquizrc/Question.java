package org.baltimorecityschools.yeatquizrc;

public class Question {
    private String questionText;
    private boolean isCorrect;

    public Question(){
        questionText = "";
        isCorrect = false;
    }

    public Question(String nQuestion, boolean nIsCorrect){
        questionText = nQuestion;
        isCorrect = nIsCorrect;
    }

    public String getQuestion(){
        return questionText;
    }
    public boolean getIsCorrect(){
        return isCorrect;
    }

    public void setQuestion(String newQuestion){
        questionText = newQuestion;
    }

    public void setIsCorrect(boolean newIsCorrect){
        isCorrect = newIsCorrect;
    }
    String[] Question = { "How many Continents are in this earth",};


}

