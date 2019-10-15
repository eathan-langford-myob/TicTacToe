package com.company;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InputValidatorTest {
    private String userInputValidString;

    @Before
    public void setUp(){
        userInputValidString = "2,0";
    }

    @After
    public void tearDown(){
        userInputValidString = null;
    }

    @Test
    public void shouldReturnTrueForValidFormatString(){
        boolean actual = InputValidator.isValidFormatWithDigits(userInputValidString);

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnTrueForNumbersInStringWithinBoundsOfBoard() {
        Board board = new Board(3);
        int boardBoundary = board.getBoard().length -1;
        boolean actual = InputValidator.isValidInputWithinBoardRange(userInputValidString, boardBoundary);

        Assert.assertTrue(actual);
        }

    @Test
    public void shouldReturnArrayOfNumbersFromStringInput() {
        int[] actual = InputValidator.splitIntoArrayOfInt(userInputValidString);
        int[] expected = {2,0};

        Assert.assertArrayEquals(expected, actual);
    }
}
