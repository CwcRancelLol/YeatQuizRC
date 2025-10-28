package org.baltimorecityschools.yeatquizrc;

public class Question {
    private int questionText;


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

    public Question(int nQuestion, boolean nAnswer, int nimageResId){
        questionText = nQuestion;
        answer = nAnswer;
        imageResId = nimageResId;
    }

    public int getQuestion(){
        return questionText;
    }

    public boolean getnAnswer(){
        return answer;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setQuestion(int newQuestion){
        questionText = newQuestion;
    }

    public void setnAnswer(boolean newAnswer){
        answer = newAnswer;
    }



}

