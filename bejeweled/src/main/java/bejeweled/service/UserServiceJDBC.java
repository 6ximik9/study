package bejeweled.service;

import bejeweled.entity.Rating;
import bejeweled.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceJDBC implements UserService{

    static final String URL = "jdbc:postgresql://localhost:5432/game";
    public static final String USER = "ximik";
    public static final String PASSWORD = "ximik69";

    public static final String selectUser = "SELECT login, pass FROM users WHERE login=?";

    public static final String selectAllUser = "SELECT login, pass FROM users";
    public static final String INSERT = "INSERT INTO users (login, pass) VALUES (?, ?)";

    @Override
    public void addUser(User user) throws UserException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(INSERT)
        ) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPass());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new UserException("Problem inserting user", e);
        }
    }

    @Override
    public User getUser(String login) throws ScoreException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(selectUser);
        )
        {
            statement.setString(1, login);
            try (ResultSet rs = statement.executeQuery()) {
                while(rs.next())
                {
                    return new User(rs.getString(1), rs.getString(2));
                }
            }
        } catch (SQLException e) {
            throw new UserException("Problem selecting user", e);
        }

        return null;
    }

    @Override
    public List<User> getAllUser() throws UserException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(selectAllUser);
        ) {
            List<User> users = new ArrayList<>();
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                users.add(new User(rs.getString(1), rs.getString(2)));
            }
            return users;
        } catch (SQLException e) {
            throw new RatingException("Problem selecting rating", e);
        }
    }

}
