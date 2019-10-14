package com.company;

import java.io.Console;

public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private IOUserInputOutput IO;

    public Game(int size, IOUserInputOutput userInput) {
        this.board = new Board(size);
        this.player1 = new Player(1);
        this.player2 = new Player(2);
        this.currentPlayer = player1;
        this.IO = userInput;
    }

    public Game(IOUserInputOutput userInput) {
        this.board = new Board(3);
        this.player1 = new Player(1);
        this.player2 = new Player(2);
        this.currentPlayer = player1;
        this.IO = userInput;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }


    public Player swapPlayers() {
        return currentPlayer = (currentPlayer == player1 ? player2 : player1);
    }

    String getInput(){
        return IO.nextLine();
    }
}
