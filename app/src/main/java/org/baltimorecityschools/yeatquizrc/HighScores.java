package org.baltimorecityschools.yeatquizrc;

public class HighScores implements Comparable{

    String name;

    int score;


    public HighScores(){
        name = "user";
        score = 0;
    }


    public HighScores(String name, int score){
        this.name = name;
        this.score = score;
    }


    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        HighScores other = (HighScores) o;
        int answer = other.score - this.score;
        return answer;

    }

    @Override
    public String toString() {
        return "org.baltimorecityschools.yeatquizrc.HighScores{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
