package bejeweled.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "rating",
        uniqueConstraints = {@UniqueConstraint(columnNames = { "player", "game" })})
public class Rating {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String player;
    @Column(nullable = false)
    private String game;

    private int rating;

    private Date ratedon;

    public Rating() {
    }

    public Rating(String player, String game, int rating, Date ratedon) {
        this.player = player;
        this.game = game;
        this.rating = rating;
        this.ratedon = ratedon;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getRatedon() {
        return ratedon;
    }

    public void setRatedon(Date ratedon) {
        this.ratedon = ratedon;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "player='" + player + '\'' +
                ", game='" + game + '\'' +
                ", rating='" + rating + '\'' +
                ", ratedon=" + ratedon +
                '}';
    }
}
