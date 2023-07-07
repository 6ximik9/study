package bejeweled.components;


public class Player {
    String login;
    int score = 0;

    public Player(String login, int score) {
        this.login = login;
        this.score = score;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
