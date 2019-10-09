package com.company;


import org.junit.Assert;
import org.junit.Test;

public class InputValidatorTest {

    @Test
    public void shouldReturnTrueForValidString(){
        boolean actual = InputValidator.isValid("2,0");

        Assert.assertTrue(actual);
    }

}
