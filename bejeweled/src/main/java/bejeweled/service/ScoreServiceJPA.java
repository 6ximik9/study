package bejeweled.service;

import bejeweled.entity.Rating;
import bejeweled.entity.Score;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.*;

@Transactional
public class ScoreServiceJPA implements ScoreService{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addScore(Score score) throws ScoreException {
        entityManager.persist(score);
    }

    @Override
    public List<Score> getTopScores(String game) throws ScoreException {

        TypedQuery<Score> query = entityManager.createQuery(
                "SELECT s FROM Score s WHERE s.game = :game AND s.points = (SELECT MAX(s2.points) " +
                        "FROM Score s2 WHERE s2.player = s.player AND s2.game = :game) ORDER BY s.points DESC",
                Score.class
        );

        query.setParameter("game", game);
        query.setMaxResults(5);

        List<Score> result = query.getResultList();
        Collections.reverse(result);
        Set<Score> uniqueScores = new LinkedHashSet<>(result);
        List<Score> sortedUniqueScores = new ArrayList<>(uniqueScores);
        Collections.reverse(sortedUniqueScores);
        return sortedUniqueScores;

    }



    @Override
    public void reset() throws ScoreException {
        entityManager.createNativeQuery("DELETE FROM score").executeUpdate();
    }
}
