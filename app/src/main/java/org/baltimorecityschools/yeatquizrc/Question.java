package org.baltimorecityschools.yeatquizrc;

public class Question {
    private String questionText;
    private boolean isCorrect;


    @Override
    public String toString() {
        return "" + questionText;
    }



    public boolean answer;
    private int imageResId;

    //public Question(){
        //questionText = "";
        //isCorrect = false;
        //answer = false;
        //imageResId = imageResId;

    //}

    public Question(String nQuestion, boolean nIsCorrect, boolean nAnswer, int nimageResId){
        questionText = nQuestion;
        isCorrect = nIsCorrect;
        answer = nAnswer;
        imageResId = nimageResId;
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

    public int getImageResId() {
        return imageResId;
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

