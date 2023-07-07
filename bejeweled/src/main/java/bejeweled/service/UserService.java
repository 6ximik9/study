package bejeweled.service;

import bejeweled.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user) throws UserException;
    User getUser(String login) throws UserException;
    List<User> getAllUser() throws UserException;

}
