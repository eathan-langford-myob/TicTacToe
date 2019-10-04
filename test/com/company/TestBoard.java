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
        board = new Board(3);

        mockBoard = new Board(3);
        mockBoard.getBoard()[0][2] = 'X';

        player1 = new Player(1);
    }

    @After
    public void tearDown() throws Exception {
        board = null;
        mockBoard = null;
        player1 = null;
    }

    @Test
    public void shouldReturnGeneratedEmptyBoard() {
        Character[][] actual = board.getBoard();
        Character[][] expected = {
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
        char actual = board.SetPieceOnBoard(player1, 0, 2);
        char expected = player1.getPiece();

        Assert.assertEquals(expected, actual);
    }
}
