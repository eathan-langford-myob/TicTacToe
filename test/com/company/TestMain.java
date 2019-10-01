package com.company;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMain {
    @Before
    public void setUp() throws Exception {
        Board board = new Board();
    }

    @Test
    public void generateBoard() {
        Board actual = board.generateBoard(3,3);
        char[][] expected = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
        Assert.assertEquals(actual.getBoard, expected);
    }
}