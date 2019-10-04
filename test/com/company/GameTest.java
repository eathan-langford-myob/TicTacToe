package com.company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;


public class GameTest {
    Game game;

    @Before
    public void setUp() {
        game = new Game(3);
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