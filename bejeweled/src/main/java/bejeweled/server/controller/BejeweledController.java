package bejeweled.server.controller;


import bejeweled.entity.Comment;
import bejeweled.entity.Rating;
import bejeweled.entity.Score;
import bejeweled.entity.User;
import bejeweled.service.CommentService;
import bejeweled.service.RatingService;
import bejeweled.service.ScoreService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class BejeweledController {

    private static final int ROWS = 8;
    private static final int COLUMNS = 8;
    private static final int MIN_MATCH = 3;
    private static final int MAX_VALUE = 7;
    private static final Random rand = new Random();

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private RatingService ratingService;

    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping("/api/bejeweled")
    public String getGameBoard() {
        if(UserController.getLoggedUser()==null)
        {
            return "redirect:/api/";
        }
        // Створення масиву для гри
        return "bejeweled";
    }

    @GetMapping("/api/bejeweled/ratingGame")
    @ResponseBody
    public String getRatingGame() {
        int rating = ratingService.getAverageRating("bejeweled");
        return String.valueOf(rating);
    }


    @PostMapping("/api/bejeweled/addScore")
    public ResponseEntity<String> addScore(@RequestBody String comment) throws JsonProcessingException {
        Score  myObject = mapper.readValue(comment, Score.class);
        System.out.println(myObject.getPoints());
        scoreService.addScore(new Score(UserController.getLoggedUser().getLogin(),
                "bejeweled", myObject.getPoints(), new Date()));
        return ResponseEntity.ok("Коментар успішно збережено");
    }



    @PostMapping("/api/bejeweled/addComment")
    public ResponseEntity<String> addComment(@RequestBody String comment) throws JsonProcessingException {
        Comment  myObject = mapper.readValue(comment, Comment.class);
        System.out.println(myObject.getComment());
        commentService.addComment(new Comment(UserController.getLoggedUser().getLogin(),
                "bejeweled", myObject.getComment(), new Date()));
        return ResponseEntity.ok("Коментар успішно збережено");
    }

    @PostMapping("/api/bejeweled/setRating")
    public ResponseEntity<String> setRating(@RequestBody String rating) throws JsonProcessingException {
        Rating myObject = mapper.readValue(rating, Rating.class);
        ratingService.setRating(new Rating(UserController.getLoggedUser().getLogin(),
                "bejeweled", myObject.getRating(), new Date()));
        return ResponseEntity.ok("Рейтинг успішно збережено");
    }

    @GetMapping("/api/bejeweled/comments")
    public ResponseEntity<List<Comment>> getComments() {
        var topScores = commentService.getComments("bejeweled");
        return new ResponseEntity<>(topScores, HttpStatus.OK);
    }


    @GetMapping("/api/bejeweled/score")
    public ResponseEntity<List<Score>> getScores() {
        var topScores = scoreService.getTopScores("bejeweled");
        return new ResponseEntity<>(topScores, HttpStatus.OK);
    }

    @GetMapping("/api/bejeweled/board")
    public ResponseEntity<int[][]> getBejeweledBoard() {
        int[][] gameBoardArray  = generateBoard();
        return new ResponseEntity<>(gameBoardArray, HttpStatus.OK);
    }

    @GetMapping("/api/bejeweled/player")
    @ResponseBody
    public User getPlayer() {
        System.out.println(UserController.getLoggedUser());
        return UserController.getLoggedUser();
    }


    private static int[][] generateBoard() {
        int[][] board = new int[ROWS][COLUMNS];

        // initialize the board with random values
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = rand.nextInt(MAX_VALUE) + 1;
            }
        }

        // check for matches and re-generate until there are no matches
        while (hasMatches(board)) {
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLUMNS; j++) {
                    int value = board[i][j];
                    if (countMatches(board, i, j, value) >= MIN_MATCH) {
                        int newValue = (value + rand.nextInt(MAX_VALUE - 1) + 1) % MAX_VALUE + 1;
                        board[i][j] = newValue;
                    }
                }
            }
        }

        return board;
    }

    private static boolean hasMatches(int[][] board) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                int value = board[i][j];
                if (countMatches(board, i, j, value) >= MIN_MATCH) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int countMatches(int[][] board, int row, int col, int value) {
        int count = 0;
        // check horizontal matches
        for (int j = col - MIN_MATCH + 1; j <= col + MIN_MATCH - 1 && j < COLUMNS; j++) {
            if (j < 0) {
                continue;
            }
            if (board[row][j] == value) {
                count++;
            } else {
                break;
            }
        }
        if (count >= MIN_MATCH) {
            return count;
        }
        // check vertical matches
        count = 0;
        for (int i = row - MIN_MATCH + 1; i <= row + MIN_MATCH - 1 && i < ROWS; i++) {
            if (i < 0) {
                continue;
            }
            if (board[i][col] == value) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

}
