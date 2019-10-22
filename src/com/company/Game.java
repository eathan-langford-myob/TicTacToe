package com.company;

import com.company.IO.*;

public class Game {

    public Board board;
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

    private String getInput(){
        return userInput.getInput();
    }

    public void welcomeMessage() {
        output.displayOutput("Welcome to Tic Tac Toe!");
    }

    public void displayBoard() {
        output.displayOutput(render.renderBoard(board));
    }

    public void askForCoordinates() {
        output.displayOutput("Player " + currentPlayer.getPlayer() + " enter a coord x,y to place your " + currentPlayer.getPiece() + " or enter 'q' to give up: ");
    }

    public int getBoardLength() {
        return board.BoardLength();
    }

    public void noMovesLeft() {
        output.displayOutput("No more moves left, it's a tie!");
    }

    public boolean evaluateBoard() {
        return Rules.checkBoardForWinState(board);
    }

    public void winnerMessage() {
        output.displayOutput("Congratulations Player " + currentPlayer.getPlayer() + " you win!");
    }

    public void goodbye() {
        output.displayOutput("Thanks for playing, goodbye!");
    }

    public boolean takeTurn() {
        Coordinates playerCoordinates;

        String userResponse = getInput();
        if (InputValidator.isQuitKeyword(userResponse)){
            System.exit(0);
        }
        if (InputValidator.isValidFormatWithDigits(userResponse) && InputValidator.isValidInputWithinBoardRange(userResponse, board.BoardLength())) {
            playerCoordinates = InputValidator.splitIntoCoordinate(userResponse);
            if (board.isPositionAvailable(playerCoordinates)) {
                board.SetPieceOnBoard(currentPlayer.getPiece(), playerCoordinates);
                output.displayOutput("Move accepted, here's the current board: ");
                return true;
            } else {
                output.displayOutput("Oh no, a piece is already at this place! Try again: ");
                return false;
            }
        }
//        }
        output.displayOutput("Oh no, that seems to be an invalid input, please try again: ");
        return false;
    }

}