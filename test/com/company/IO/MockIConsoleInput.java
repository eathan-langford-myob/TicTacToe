package com.company.IO;

public class MockIConsoleInput implements IInput {
    public String mockInput;

    public MockIConsoleInput(String input) {
        this.mockInput = input;
    }


    @Override
    public String getInput() {
        return mockInput;
    }
}