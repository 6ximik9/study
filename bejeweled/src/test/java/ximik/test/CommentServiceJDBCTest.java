package ximik.test;

import bejeweled.entity.Comment;
import bejeweled.service.CommentException;
import bejeweled.service.CommentServiceJDBC;
import org.junit.jupiter.api.*;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CommentServiceJDBCTest {
    public static final String URL = "jdbc:postgresql://localhost/game";
    public static final String USER = "ximik";
    public static final String PASSWORD = "ximik69";
    public static final String TEST_GAME = "test_game";
    public static final String TEST_PLAYER = "test_player";
    private CommentServiceJDBC commentServiceJDBC;

    @BeforeEach
    void setUp() throws CommentException {
        commentServiceJDBC = new CommentServiceJDBC();
        commentServiceJDBC.reset();
    }

    @Test
    void testAddComment() throws CommentException {
        String commentText = "test_comment";
        Comment comment = new Comment(TEST_PLAYER, TEST_GAME, commentText, new Date());
        commentServiceJDBC.addComment(comment);

        List<Comment> comments = commentServiceJDBC.getComments(TEST_GAME);
        System.out.println(comments);
        assertEquals(1, comments.size());

        Comment addedComment = comments.get(0);
        assertEquals(TEST_PLAYER, addedComment.getPlayer());
        assertEquals(TEST_GAME, addedComment.getGame());
        assertEquals(commentText, addedComment.getComment());
    }

    @Test
    void testGetComments() throws CommentException {
        String commentText1 = "test_comment1";
        String commentText2 = "test_comment2";
        Comment comment1 = new Comment(TEST_PLAYER, TEST_GAME, commentText1, new Date());
        Comment comment2 = new Comment(TEST_PLAYER+"1", TEST_GAME, commentText2, new Date());
        commentServiceJDBC.addComment(comment1);
        commentServiceJDBC.addComment(comment2);

        List<Comment> comments = commentServiceJDBC.getComments(TEST_GAME);
        assertEquals(2, comments.size());

        Comment firstComment = comments.get(0);
        assertEquals(TEST_PLAYER, firstComment.getPlayer());
        assertEquals(TEST_GAME, firstComment.getGame());
        assertEquals(commentText1, firstComment.getComment());

        Comment secondComment = comments.get(1);
        assertEquals(TEST_PLAYER+"1", secondComment.getPlayer());
        assertEquals(TEST_GAME, secondComment.getGame());
        assertEquals(commentText2, secondComment.getComment());
    }

    @Test
    void testReset() throws CommentException {
        String commentText = "test_comment";
        Comment comment = new Comment(TEST_PLAYER, TEST_GAME, commentText, new Date());
        commentServiceJDBC.addComment(comment);

        commentServiceJDBC.reset();

        List<Comment> comments = commentServiceJDBC.getComments(TEST_GAME);
        assertTrue(comments.isEmpty());
    }
}
