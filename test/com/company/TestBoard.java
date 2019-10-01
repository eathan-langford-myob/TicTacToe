package com.company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBoard {
    Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board(3,3);
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
        boolean actual = board.isPositionAvailable(1, 3);
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }
}
