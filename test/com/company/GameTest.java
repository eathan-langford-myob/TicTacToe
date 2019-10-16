package com.company;

import com.company.IO.IConsoleInput;
import com.company.IO.IConsoleOutput;
import com.company.IO.StringRender;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GameTest {
    Game game;

    @Before
    public void setUp() {
        game = new Game(3, new IConsoleInput(), new IConsoleOutput(), new StringRender());
    }

    @After
    public void teardown() {
        game = null;
    }

    @Test
    public void shouldReturnPlayerTwoIfPlayerOneIsCurrentPlayer() {
        Player actual = game.swapPlayers();
        Player expected = game.getCurrentPlayer();

        Assert.assertEquals(expected, actual);
    }

}