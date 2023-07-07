package ximik.test;

import bejeweled.components.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlayer {

    Player player;

    public TestPlayer()
    {
        player = new Player("name", 0);
    }

    @Test
    public void testPlayerName()
    {

        assertTrue(player.getLogin()!=null && player.getLogin().length()>0);
    }

    @Test
    public void testPlayerScore()
    {

        assertEquals(0, player.getScore(), "Player was initialized incorrectly - error score player");
    }
}

