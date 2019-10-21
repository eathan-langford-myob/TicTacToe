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

    public String welcomeMessage() {
        return "Welcome to Tic Tac Toe!";
    }

    public String displayBoard() {
        return render.renderBoard(board);
    }

    public String askForCoordinates() {
        return "Player " + currentPlayer.getPlayer() + "enter a coord x,y to place your " + currentPlayer.getPiece() + " or enter 'q' to give up: ";
    }

    public boolean takeTurn() {
        Coordinates playerCoordinates;

        output.displayOutput(displayBoard());

        String userResponse = getInput();

        if (InputValidator.isValidFormatWithDigits(userResponse) && InputValidator.isValidInputWithinBoardRange(userResponse, board.getBoardLength())) {
            playerCoordinates = InputValidator.splitIntoCoordinate(userResponse);
            if (board.isPositionAvailable(playerCoordinates)) {
                board.SetPieceOnBoard(currentPlayer.getPiece(), playerCoordinates);
                swapPlayers();
                output.displayOutput("Move accepted, here's the current board:");
                return true;
            } else {
                output.displayOutput("Oh no, a piece is already at this place! Try again...");
                return false;
            }
        }
//        }
        output.displayOutput("Oh no, that seems to be an invalid input, please try again!");
        return false;
    }
}
