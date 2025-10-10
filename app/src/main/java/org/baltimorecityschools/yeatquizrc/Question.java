package org.baltimorecityschools.yeatquizrc;

public class Question {
    private String questionText;
    private boolean isCorrect;

    @Override
    public String toString() {
        return "" + questionText;
    }

    public int [] questionImages = {
            R.drawable.flat_earth,
            R.drawable.supercontinent,
            R.drawable.solarsystem,
            R.drawable.q4,
            R.drawable.q5,
            R.drawable.q6,
            R.drawable.q7,
            R.drawable.q8,
            R.drawable.q9,
            R.drawable.q10
    };

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

