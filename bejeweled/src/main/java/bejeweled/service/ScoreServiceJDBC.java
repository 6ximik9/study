package bejeweled.service;


import bejeweled.entity.Score;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ScoreServiceJDBC implements ScoreService {
    public static final String URL = "jdbc:postgresql://localhost/game";
    public static final String USER = "ximik";
    public static final String PASSWORD = "ximik69";
    //public static final String SELECT = "SELECT game, player, points, playedOn FROM score WHERE game = ? ORDER BY points DESC LIMIT 10";

    public static final String SELECT = "SELECT player, game, MAX(points) AS max_score, playedon " +
            "FROM score WHERE game = ? " +
            "GROUP BY player, game, playedon " +
            "ORDER BY max_score DESC;";


    public static final String DELETE = "DELETE FROM score";
    public static final String INSERT = "INSERT INTO score (player, game, points, playedOn) VALUES (?, ?, ?, ?)";

    @Override
    public void addScore(Score score) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(INSERT)
        ) {
            statement.setString(1, score.getPlayer());
            statement.setString(2, score.getGame());
            statement.setInt(3, score.getPoints());
            statement.setTimestamp(4, new Timestamp(score.getPlayedOn().getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ScoreException("Problem inserting score", e);
        }
    }

    @Override
    public List<Score> getTopScores(String game) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SELECT);
        ) {
            statement.setString(1, game);
            try (ResultSet rs = statement.executeQuery()) {
                List<Score> scores = new ArrayList<>();
                while (rs.next()) {
                    scores.add(new Score(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getTimestamp(4)));
                    //scores.add(new Score(rs.getString(1), "game", rs.getInt(2), null));
                    //System.out.println(rs.getString(1) + "  " + rs.getString(2));
                }
                return scores;
            }
        } catch (SQLException e) {
            throw new ScoreException("Problem selecting score", e);
        }
    }

    @Override
    public void reset() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate(DELETE);
        } catch (SQLException e) {
            throw new ScoreException("Problem deleting score", e);
        }
    }
}
