package com.company.IO;

public class MockIConsoleInput implements IInput {
    private String mockInput;

    MockIConsoleInput(String input) {
        this.mockInput = input;
    }


    @Override
    public String getInput() {
        return mockInput;
    }
}