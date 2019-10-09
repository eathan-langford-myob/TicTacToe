package com.company;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class InputGetterTest {
        @Test
        void getAllInput_whenCalledWithInputReaderWithOnelLine_ReturnsAllInput_USESFAKEIMPLEMENTATION() {
            IInputReader inputReader = new MockStringInputReader("2,0");
            InputGetter inputGetter = new InputGetter(inputReader);
            String actual = inputGetter.getInput();
            String expected = "2,0";
            assertEquals(expected, actual);
        }
}
