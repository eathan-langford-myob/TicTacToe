package com.company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBoard {
    Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
    }

    @After
    public void tearDown() throws Exception {
        board = null;
    }

    @Test
    public void shouldReturnGeneratedEmptyBoard() {
        char[][] actual = board.generateBoard(3,3);
        char[][] expected = {
                {'*','*','*'},
                {'*','*','*'},
                {'*','*','*'}
        };
        Assert.assertArrayEquals(actual, expected);
    }

    public void shouldReturnTrueForEmptySpot(){
        int actual = board.isPositionAvailable(1, 3);
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }
}
