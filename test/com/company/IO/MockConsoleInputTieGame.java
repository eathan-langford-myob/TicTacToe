package com.company.IO;

import com.company.Coordinates;

import java.util.Iterator;

public class MockConsoleInputTieGame implements IInput {
    String[] arrayOfPlayedCoordinates = {
            "1,1",
            "2,1",
            "3,1",
            "3,2",
            "2,2",
            "3,1",
            "2,3",
            "1,3",
            "1,2"
    };
    int counter = -1;

    @Override
    public String getInput() {
        counter++;
        return arrayOfPlayedCoordinates[counter];
    }
}