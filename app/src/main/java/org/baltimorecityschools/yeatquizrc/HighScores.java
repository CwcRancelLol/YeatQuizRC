public class HighScores {

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
    public String toString() {
        return "HighScores{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
