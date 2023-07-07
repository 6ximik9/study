package ximik.test;

import bejeweled.entity.Score;
import bejeweled.service.ScoreServiceJDBC;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ScoreServiceJDBCTest {
    private ScoreServiceJDBC scoreService;

    @BeforeEach
    void setUp() {
        scoreService = new ScoreServiceJDBC();
        scoreService.reset();
    }

    @AfterEach
    void tearDown() {
        scoreService.reset();
    }

    @Test
    @Order(1)
    void addScore() {
        Score score = new Score("game1", "player1", 100, new Date());
        scoreService.addScore(score);

        assertEquals(1, scoreService.getTopScores("game1").size());
        assertEquals(score.getPoints(), scoreService.getTopScores("game1").get(0).getPoints());
    }

    @Test
    @Order(2)
    void addScoreMultipleTimes() {
        Score score1 = new Score("game1", "player1", 100, new Date());
        Score score2 = new Score("game1", "player2", 200, new Date());
        Score score3 = new Score("game1", "player3", 300, new Date());

        scoreService.addScore(score1);
        scoreService.addScore(score2);
        scoreService.addScore(score3);

        List<Score> topScores = scoreService.getTopScores("game1");

        assertEquals(3, topScores.size());
    }

    @Test
    @Order(3)
    void getTopScoresWithLimit() {
        for (int i = 1; i < 11; i++) {
            Score score = new Score("game1", "player" + i, i * 10, Calendar.getInstance().getTime());
            scoreService.addScore(score);
        }

        List<Score> topScores = scoreService.getTopScores("game1");
        assertEquals(10, topScores.size());
        assertEquals(100, topScores.get(0).getPoints());
        assertEquals(90, topScores.get(1).getPoints());
    }

    @Test
    @Order(4)
    void reset() throws SQLException {
        Score score = new Score("player1", "game1", 100, Calendar.getInstance().getTime());
        scoreService.addScore(score);

        scoreService.reset();

        List<Score> topScores = scoreService.getTopScores("game1");
        assertTrue(topScores.isEmpty());
    }
}
