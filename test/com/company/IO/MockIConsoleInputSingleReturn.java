package com.company.IO;

public class MockIConsoleInputSingleReturn implements IInput {
    public String mockInput;

    public MockIConsoleInputSingleReturn(String input) {
        this.mockInput = input;
    }


    @Override
    public String getInput() {
        return mockInput;
    }
}