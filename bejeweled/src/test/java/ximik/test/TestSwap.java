package ximik.test;


import bejeweled.components.GameLogic;
import bejeweled.components.Player;
import bejeweled.ui.view.GameUI;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSwap {
    private Random randomGenerator = new Random();
    private GameLogic board;
    private Player player;

    public TestSwap()
    {
        player = new Player("name", 0);
//        board = new GameLogic(player, new GameUI(new Player("login", 0)));
        board = new GameLogic();
        //board.startGame();
    }

    @BeforeAll
    public static void setUp()
    {
        System.out.println("Start checkSwap");
    }


    @Test
    public void checkSwap() {
        int x = randomGenerator.nextInt(7);
        int x0 = randomGenerator.nextInt(7);
        int y = randomGenerator.nextInt(7);
        int y0 = randomGenerator.nextInt(7);

        assertFalse(board.checkValidSwap(x, x0, y, y0) == 1);
    }
}
