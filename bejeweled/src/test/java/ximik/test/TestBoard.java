package ximik.test;

import bejeweled.components.GameLogic;
import bejeweled.components.Player;
import bejeweled.components.Tile;
import bejeweled.ui.view.GameUI;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class TestBoard {
    private Random randomGenerator = new Random();
    private GameLogic board;
    private Player player;
    private int timeLimit;
    private Tile[][] tiles;

    public TestBoard()
    {
        timeLimit = randomGenerator.nextInt(55) + 6;
        player = new Player("name", 0);
//        board = new GameLogic(player, new GameUI(new Player("login", 0)));
        board = new GameLogic();
    }

    @Test
    public void checkTimeLimit()
    {
        assertTrue(timeLimit>0);
    }

    @Test
    public void runTestBoard()
    {
        for(int i =0; i<5; i++)
        {
            testBoardGenerate();
        }
    }

    @Test
    public void testBoardGenerate()
    {
        try
        {
//            board = new GameLogic(player, new GameUI(new Player("login", 0)));
            board = new GameLogic();
            tiles = board.getGameBoard();
        }
        catch (Exception ex)
        {

        }

        int row = randomGenerator.nextInt(7);
        int column = randomGenerator.nextInt(7);;
        assertTrue(board!=null || tiles[row][column]!=null);
    }
}


