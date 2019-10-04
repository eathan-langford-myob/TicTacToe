package com.company;

public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(int size) {
        this.board = new Board(size);
        this.player1 = new Player(1);
        this.player2 = new Player(2);
        this.currentPlayer = player1;
    }

    public Game() {
        this.board = new Board(3);
        this.player1 = new Player(1);
        this.player2 = new Player(2);
        this.currentPlayer = player1;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }


    public Player swapPlayers() {
        return currentPlayer = (currentPlayer == player1 ? player2 : player1);
    }
}
