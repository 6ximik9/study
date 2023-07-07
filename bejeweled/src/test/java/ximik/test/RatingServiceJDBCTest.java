package ximik.test;

import bejeweled.entity.Rating;
import bejeweled.service.RatingException;
import bejeweled.service.RatingServiceJDBC;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RatingServiceJDBCTest {
    private static final String TEST_GAME = "test_game";
    private static final String TEST_PLAYER = "test_player";
    private static final int TEST_RATING_1 = 5;
    private static final int TEST_RATING_2 = 3;
    private RatingServiceJDBC ratingService;

    @BeforeEach
    public void setUp() {
        ratingService = new RatingServiceJDBC();
    }

//    @After("")
//    public void tearDown() throws RatingException {
//        ratingService.reset();
//    }

    @Test
    public void testSetAndGetRating() throws RatingException {
        Rating rating = new Rating(TEST_PLAYER, TEST_GAME, TEST_RATING_1, new Date());
        assertEquals(TEST_RATING_1, ratingService.getRating(TEST_GAME, TEST_PLAYER));
    }

    @Test
    public void testGetAverageRating() throws RatingException {
        Rating rating1 = new Rating(TEST_PLAYER, TEST_GAME, TEST_RATING_1, new Date());
        Rating rating2 = new Rating("another_player", TEST_GAME, TEST_RATING_2, new Date());
        ratingService.setRating(rating1);
        ratingService.setRating(rating2);
    }

    @Test
    public void testReset() throws RatingException {
        Rating rating = new Rating(TEST_PLAYER, TEST_GAME, TEST_RATING_1, new Date());
        ratingService.setRating(rating);
        ratingService.reset();
        assertEquals(0, ratingService.getRating(TEST_GAME, TEST_PLAYER));
    }
}
