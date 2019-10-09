package com.company;

import java.util.Scanner;

class ConsoleInputReader implements IInputReader {

    @Override
    public String nextLine() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
