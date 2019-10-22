package com.company;

import com.company.IO.IConsoleInput;
import com.company.IO.IConsoleOutput;
import com.company.IO.MockIConsoleInputSingleReturn;
import com.company.IO.StringRender;
import org.junit.*;

public class GameTest {
    Game game;

    @Before
    public void setUp() {
    }

    @After
    public void teardown() {
        game = null;
    }

    @Test
    public void shouldReturnPlayerTwoIfPlayerOneIsCurrentPlayer() {
        game = new Game(3, new IConsoleInput(), new IConsoleOutput(), new StringRender());

        Player actual = game.swapPlayers();
        Player expected = game.getCurrentPlayer();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseForInvalidInput() {
        game = new Game(3, new MockIConsoleInputSingleReturn("4,2"), new IConsoleOutput(), new StringRender());

        boolean actual = game.takeTurn();
        boolean expected = false;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseForTakenSpotFromInput() {

        game = new Game(3, new MockIConsoleInputSingleReturn("2,3"), new IConsoleOutput(), new StringRender());
        Coordinates coordinates = new Coordinates(1,2);
        game.board.SetPieceOnBoard( 'X',coordinates);
        boolean actual = game.takeTurn();
        boolean expected = false;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTrueForSuccessfulMove() {
        game = new Game(3, new MockIConsoleInputSingleReturn("1,2"), new IConsoleOutput(), new StringRender());
        boolean actual = game.takeTurn();
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

}