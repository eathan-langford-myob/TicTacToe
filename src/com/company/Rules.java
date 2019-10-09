package com.company;

import java.util.Arrays;

public class Rules {

    //maybe grab first element from passed coords, then check the next, if true move on, if not stop.

    public static boolean checkLinearFromLastMove(Board board, int x, int y) {
        char playerLastMove = board.getPosition(x, y);
        int boardLength = board.getBoard().length;
        int horizontalWinCounter = 0;
        int verticalWinCounter = 0;

        for (int i = 0; i < boardLength; i++) {
            if (board.getPosition(i, y) == playerLastMove) {
                horizontalWinCounter++;
            }
            if (board.getPosition(x, i) == playerLastMove) {
                verticalWinCounter++;
            }
        }
        return (horizontalWinCounter == boardLength) || (verticalWinCounter == boardLength) ;
    }
    public static boolean checkDiagonalsFromLastMove(Board board, int x, int y) {
        char playerLastMovePiece = board.getPosition(x, y);
        int boardLength = board.getBoard().length;
        int winCounterTopLeftToBottomRight = 0;
        int winCounterTopRightToBottomLeft = 0;

        for (int i = 0; i < boardLength; i++) {
            if (board.getPosition(i,i) == playerLastMovePiece){
                winCounterTopLeftToBottomRight++;
            }
            if (board.getPosition(i, (-1*i+(boardLength-1))) == playerLastMovePiece){
                winCounterTopRightToBottomLeft++;
            }
        }
     return (winCounterTopLeftToBottomRight == boardLength) || (winCounterTopRightToBottomLeft == boardLength);
    }

    public static boolean checkWinConditions(Board board, int x, int y) {

        boolean diagonalsAvailableFromPiece = (x == y) || (y == (-1 * x + (board.getBoard().length-1)));

        if (diagonalsAvailableFromPiece) {
            return checkDiagonalsFromLastMove(board, x, y) || checkLinearFromLastMove(board, x, y);
        }
        return checkLinearFromLastMove(board, x, y);
    }
}
