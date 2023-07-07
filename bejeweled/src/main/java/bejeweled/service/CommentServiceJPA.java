package bejeweled.service;

import bejeweled.entity.Comment;
import bejeweled.entity.Score;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public class CommentServiceJPA implements CommentService{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addComment(Comment comment) throws CommentException {
        entityManager.persist(comment);
    }

    @Override
    public List<Comment> getComments(String game) throws CommentException {
        var comments = entityManager.createQuery("select c from Comment c where c.game = :game", Comment.class)
                .setParameter("game", game)
                .getResultList();
        return comments;
    }

    @Override
    public void reset() throws CommentException {
        entityManager.createNativeQuery("DELETE FROM comment").executeUpdate();
    }
}
