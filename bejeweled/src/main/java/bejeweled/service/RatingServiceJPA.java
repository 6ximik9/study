package bejeweled.service;

import bejeweled.entity.Rating;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public class RatingServiceJPA implements RatingService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Rating> getRatingGame(String game) throws RatingException {
        return entityManager.createQuery(
                "SELECT r FROM Rating r WHERE r.game = :game",
                Rating.class).setParameter("game", game).getResultList();
    }

    @Override
    public void setRating(Rating rating) throws RatingException {
        try {
            Rating rating1 = entityManager.createQuery(
                            "SELECT t FROM Rating t WHERE t.player = :player AND t.game = :game", Rating.class)
                    .setParameter("player", rating.getPlayer())
                    .setParameter("game", rating.getGame())
                    .getSingleResult();

            rating1.setRating(rating.getRating());
            rating1.setRatedon(rating.getRatedon());

        } catch (NoResultException e) {
            entityManager.persist(rating);
        }
    }

    @Override
    public int getAverageRating(String game) throws RatingException {

        Double rating = entityManager.createQuery(
                "SELECT AVG(r.rating) FROM Rating r WHERE r.game = :game",
                Double.class
        ).setParameter("game", game).getSingleResult();

        return rating != null ? rating.intValue() : 0;
    }

    @Override
    public int getCountRating(String game) throws RatingException {
       return entityManager.createQuery("SELECT COUNT(r) FROM Rating r WHERE r.game = :game", Long.class)
                .setParameter("game", game).getSingleResult().intValue();
    }

    @Override
    public int getRating(String game, String player) throws RatingException {
        return entityManager.createQuery("SELECT r.rating FROM Rating r WHERE r.game = :game AND r.player = :player", Integer.class)
                .setParameter("game", game)
                .setParameter("player", player).getSingleResult();
    }

    @Override
    public void reset() throws RatingException {
        entityManager.createNativeQuery("DELETE FROM rating").executeUpdate();
    }
}
