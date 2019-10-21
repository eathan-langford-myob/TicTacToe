package com.company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBoard {
    Board plainBoard;
    Board mockBoard;
    Player player1;
    Coordinates mockCoordinates = new Coordinates(0,2);

    @Before
    public void setUp() {
        plainBoard = new Board(3);

        mockBoard = new Board(3);
        mockBoard.SetPieceOnBoard('X',mockCoordinates);

        player1 = new Player(1);
    }

    @After
    public void tearDown() {
        plainBoard = null;
        mockBoard = null;
        player1 = null;
    }

    @Test
    public void shouldReturnGeneratedEmptyBoard() {
        Character[][] actual = plainBoard.getBoard();
        Character[][] expected = { {'*','*','*'}, {'*','*','*'}, {'*','*','*',}};
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnTrueForEmptySpot(){
        boolean actual = plainBoard.isPositionAvailable(mockCoordinates);
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseForTakenSpot(){
        boolean actual = mockBoard.isPositionAvailable(mockCoordinates);
        boolean expected = false;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldPlacePieceOnBoard(){
        plainBoard.SetPieceOnBoard(player1.getPiece(), mockCoordinates);
        char actual = plainBoard.getPosition(mockCoordinates);
        char expected = player1.getPiece();

        Assert.assertEquals(expected, actual);
    }
}
