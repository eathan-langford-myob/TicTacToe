package com.company;

import com.company.IO.*;

public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private IInput userInput;
    private IOutput output;
    private Render render;

    public Game(int size, IInput userInput, IOutput output, Render renderer) {
        this.board = new Board(size);
        this.player1 = new Player(1);
        this.player2 = new Player(2);
        this.currentPlayer = player1;
        this.userInput = userInput;
        this.output = output;
        this.render = renderer;
    }

    public Game(IInput userInput, IOutput output, Render renderer) {
        this.board = new Board(3);
        this.player1 = new Player(1);
        this.player2 = new Player(2);
        this.currentPlayer = player1;
        this.userInput = userInput;
        this.output = output;
        this.render = renderer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }


    public Player swapPlayers() {
        return currentPlayer = (currentPlayer == player1 ? player2 : player1);
    }

    String getInput(){
        return userInput.getInput();
    }

    public void welcomeMessage() {
        output.renderOutput("Welcome to Tic Tac Toe!");
    }

    public void displayBoard() {
        output.renderOutput("Move accepted, here's the current board:");
        render.renderBoard(board);
    }

    public int[] takeTurn() {
        //display board
        //display message asking for coord
        //get coord
        //----------------------
        //validate coord
        //---------------------
        //place piece on board
        //swap players
        return null;
    }
}
