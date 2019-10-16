package com.company.IO;

import com.company.Board;

public class IConsoleOutput implements IOutput{
    @Override
    public void renderOutput(String string) {
        System.out.print(string);
    }
}
