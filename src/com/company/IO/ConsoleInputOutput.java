package com.company.IO;

import java.util.Scanner;

public class ConsoleInputOutput implements IOUserInputOutput {
    private Scanner scanner;

    public ConsoleInputOutput() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public void printOutput(String string) {
        System.out.println(string);
    }
}
