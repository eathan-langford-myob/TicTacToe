package com.company;
import com.company.IO.IConsoleInput;
import com.company.IO.IConsoleOutput;
import com.company.IO.StringRender;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(new IConsoleInput(), new IConsoleOutput(), new StringRender());
    }
}
