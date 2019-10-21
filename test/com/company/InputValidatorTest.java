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
        int boardLength = board.getBoardLength();
        boolean actual = InputValidator.isValidInputWithinBoardRange(userInputValidString, boardLength);

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnArrayOfNumbersFromStringInput() {
        Coordinates actual = InputValidator.splitIntoCoordinate(userInputValidString);
        Coordinates expected = new Coordinates(2,0);

        Assert.assertEquals(expected, actual);
    }
}
