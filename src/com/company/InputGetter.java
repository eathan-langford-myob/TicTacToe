package com.company;

public class InputGetter {
    private final IInputReader inputReader;

    InputGetter(IInputReader inputReader) {
        this.inputReader = inputReader;
    }

    String getInput(){
        return inputReader.nextLine();
    }
}
