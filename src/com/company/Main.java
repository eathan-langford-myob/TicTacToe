package com.company;
import com.company.IO.IConsoleInput;
import com.company.IO.IConsoleOutput;
import com.company.IO.StringRender;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(new IConsoleInput(), new IConsoleOutput(), new StringRender());
        game.welcomeMessage();
        boolean gameOver = false;

        game: while (!gameOver) {
            game.displayBoard();
            for (int i = 0; i < game.getBoardLength() * game.getBoardLength(); i++) {
                boolean successfulTurn = false;
                game.askForCoordinates();
                while (!successfulTurn) {
                    successfulTurn = game.takeTurn();
                }
                game.displayBoard();
                if(Rules.checkBoardForWinState(game.board)) {
                    game.displayBoard();
                    game.winnerMessage();
                    break game;
                }
                game.swapPlayers();
            }
            game.noMovesLeft();
            gameOver = true;
        }
        game.goodbye();
    }
}
