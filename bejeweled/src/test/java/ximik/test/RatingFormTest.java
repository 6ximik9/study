package ximik.test;

import bejeweled.components.Player;
import bejeweled.ui.view.ratingForm;
import bejeweled.entity.Comment;
import bejeweled.entity.Rating;
import bejeweled.service.CommentService;
import bejeweled.service.CommentServiceJDBC;
import bejeweled.service.RatingService;
import bejeweled.service.RatingServiceJDBC;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RatingFormTest {
    private ratingForm form;
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("username", 0);
//        form = new ratingForm();
    }

    @Test
    void testAddRatingAndComment() {
        // Створюємо макет події для натискання кнопки "Submit"
        ActionEvent event = new ActionEvent(form.submitButton, ActionEvent.ACTION_PERFORMED, "Submit");

        // Задаємо значення полів форми
        form.commentField.setText("This game is awesome!");
        form.ratingComboBox.setSelectedIndex(4); // 5 зірок

        // Симулюємо натискання кнопки "Submit"
        form.actionPerformed(event);

        // Перевіряємо, що рейтинг і коментар додані до бази даних
        RatingService ratingService = new RatingServiceJDBC();
        CommentService commentService = new CommentServiceJDBC();

        Rating rating = new Rating("TEST_PLAYER", "TEST_GAME", form.ratingComboBox.getSelectedIndex(), new Date());
        ratingService.setRating(rating);

        var ratings = ratingService.getRating("TEST_GAME", "TEST_PLAYER");

        String commentText1 = "test_comment1";
        Comment comment1 = new Comment("TEST_PLAYER", "TEST_GAME", commentText1, new Date());
        commentService.addComment(comment1);
        List<Comment> comments = commentService.getComments("TEST_GAME");

        assertEquals(1, comments.size());
        assertEquals(4, ratings);
    }


}
