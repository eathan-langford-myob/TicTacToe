package com.company;

public class MockStringInputReader implements IInputReader {
    private String mockInput;

    MockStringInputReader(String input) {
        this.mockInput = input;
    }

    @Override
    public String nextLine() {
        return mockInput;
    }
}