package com.company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBoard {
    Board board;
    Board mockBoard;
    Player player1;

    @Before
    public void setUp() throws Exception {
        board = new Board(3,3);

        mockBoard = new Board(3,3);
        mockBoard.getBoard()[0][2] = 'X';

        player1 = new Player('X', 1);
    }

    @After
    public void tearDown() throws Exception {
        board = null;
    }

    @Test
    public void shouldReturnGeneratedEmptyBoard() {
        char[][] actual = board.getBoard();
        char[][] expected = {
                {'*','*','*'},
                {'*','*','*'},
                {'*','*','*'}
        };
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnTrueForEmptySpot(){
        boolean actual = board.isPositionAvailable(0, 2);
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseForTakenSpot(){
        boolean actual = mockBoard.isPositionAvailable(0,2);
        boolean expected = false;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldPlacePieceOnBoard(){
        char actual = board.getBoard()[0][2];
        board.SetPieceOnBoard(player1, 0, 2);
        char expected = 'X';

        Assert.assertEquals('X', expected);
    }
}
