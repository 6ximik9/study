package bejeweled.service;


import bejeweled.entity.Rating;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RatingServiceJDBC implements RatingService {
    public static final String URL = "jdbc:postgresql://localhost/game";
    public static final String USER = "ximik";
    public static final String PASSWORD = "ximik69";
    public static final String SELECT_PLAYER_RATING = "SELECT player, game, rating, ratedon FROM rating WHERE player = ? AND game = ?";
    public static final String SELECT_AVG_RATING = "SELECT AVG(rating) FROM rating WHERE game = ?";
    public static final String SELECT_COUNT_RATING = "SELECT COUNT(player) FROM rating WHERE game = ?";

    public static final String SELECT_ALL_RATING = "SELECT player, game, rating, ratedon FROM rating WHERE game = ?";
    public static final String DELETE = "DELETE FROM rating";
    public static final String INSERT = "INSERT INTO rating (player, game, rating, ratedon) VALUES (?, ?, ?, ?) " +
                                        "ON CONFLICT (player, game) DO UPDATE SET rating = ?, ratedon = ?";

    @Override
    public void setRating(Rating rating) throws RatingException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(INSERT)
        ) {
            statement.setString(1, rating.getPlayer());
            statement.setString(2, rating.getGame());
            statement.setInt(3, rating.getRating());
            statement.setTimestamp(4, new Timestamp(rating.getRatedon().getTime()));
            statement.setInt(5, rating.getRating());
            statement.setTimestamp(6, new Timestamp(rating.getRatedon().getTime()));
//            System.out.println(statement);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RatingException("Problem inserting rating", e);
        }
    }

    @Override
    public List<Rating> getRatingGame(String game) throws RatingException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_RATING);
        ) {
            statement.setString(1, game);
            List<Rating> ratings = new ArrayList<>();
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                ratings.add(new Rating(rs.getString(1), rs.getString(2),
                                Integer.parseInt(rs.getString(3)), rs.getTimestamp(4)));
            }
            return ratings;
        } catch (SQLException e) {
            throw new RatingException("Problem selecting rating", e);
        }
    }

    @Override
    public int getAverageRating(String game) throws RatingException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SELECT_AVG_RATING);
        ) {
            statement.setString(1, game);
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException e) {
            throw new RatingException("Problem selecting rating", e);
        }
    }

    @Override
    public int getCountRating(String game) throws RatingException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SELECT_COUNT_RATING);
        ) {
            statement.setString(1, game);
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException e) {
            throw new RatingException("Problem selecting rating", e);
        }
    }

    @Override
    public int getRating(String game, String player) throws RatingException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SELECT_PLAYER_RATING);
        ) {
            statement.setString(1, player);
            statement.setString(2, game);
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                return rs.getInt(3);
            }
            return 0;
        } catch (SQLException e) {
            throw new RatingException("Problem selecting rating", e);
        }
    }

    @Override
    public void reset() throws RatingException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate(DELETE);
        } catch (SQLException e) {
            throw new RatingException("Problem deleting rating", e);
        }
    }
}
