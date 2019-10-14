package com.company;

import com.company.IO.IOUserInputOutput;

public class MockStringInputOutput implements IOUserInputOutput {
    private String mockInput;

    MockStringInputOutput(String input) {
        this.mockInput = input;
    }

    @Override
    public String nextLine() {
        return mockInput;
    }

    @Override
    public void printOutput(String string) {
    }
}