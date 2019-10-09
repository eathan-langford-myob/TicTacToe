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
        boolean actual = InputValidator.isValidFormatWithDigits("2,0");

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnTrueForNumbersInStringWithinBoundsOfBoard() {
        Board board = new Board(3);
        boolean actual = InputValidator.isValidInputWithinBoard(userInputValidString, board);

        Assert.assertTrue(actual);
        }

}
