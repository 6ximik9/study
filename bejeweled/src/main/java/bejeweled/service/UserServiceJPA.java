package bejeweled.service;

import bejeweled.entity.Rating;
import bejeweled.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public class UserServiceJPA implements UserService{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addUser(User user) throws UserException {
        entityManager.persist(user);
    }

    @Override
    public User getUser(String login) throws UserException {
        List<User> resultList = entityManager.createQuery("SELECT u FROM User u WHERE u.login = :login", User.class)
                .setParameter("login", login)
                .getResultList();

        if(resultList.isEmpty()){
            return null;
        }

        return resultList.get(0);
    }

    @Override
    public List<User> getAllUser() throws UserException {
        return entityManager.createQuery(
                "SELECT u FROM User u",
                User.class).getResultList();
    }
}
