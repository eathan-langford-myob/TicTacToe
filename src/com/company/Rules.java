package com.company;

import java.util.Arrays;

public class Rules {

    private static int NUMBER_TO_WIN = 3;
    //maybe grab first element from passed coords, then check the next, if true move on, if not stop.

    public static boolean checkLinearFromLastMove(Board board, int x, int y) {
        char playerLastMove = board.getPosition(x, y);
        int boardLength = board.getBoard().length;
        boolean horizontalWinCounter = true;
        boolean verticalWinCounter = true;

        for (int i = 0; i < boardLength; i++) {
            if (board.getPosition(i, y) != playerLastMove) {
                horizontalWinCounter = false;
            }
            if (board.getPosition(x, i) != playerLastMove) {
                verticalWinCounter = false;
            }
        }
        return (horizontalWinCounter) || (verticalWinCounter) ;
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

    public static boolean checkWinConditions(int[] startingPosition, int[] endingPosition){
        return checkWin(startingPosition, endingPosition);
    }

    public static boolean checkWin(int[] startingPosition, int[] endPosition) {
        // Check whether end pos > start pos
        // If so add one to x or y or both
        // Otherwise minus one to x or y or both (mainly diagonal)
        // Get current char character and previous character
        // Check that next is the same as current char character
        // Set win variable to true
        // Check that number of win or board length has not been reached
        // If board length has been reached return current state of win boolean
        // If same then increment startPos parameter and call same function again
        // If not return false
        // Loop can also finish when current startPos == endPos
        return true;
    }

    public static boolean checkWinConditions(Board board, int x, int y) {

        boolean diagonalsAvailableFromPiece = (x == y) || (y == (-1 * x + (board.getBoard().length-1)));

        if (diagonalsAvailableFromPiece) {
            return checkDiagonalsFromLastMove(board, x, y) || checkLinearFromLastMove(board, x, y);
        }
        return checkLinearFromLastMove(board, x, y);
    }
}
