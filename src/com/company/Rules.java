package com.company;

import java.util.Arrays;

public class Rules {

    public static boolean checkWin(int[] startPosition, int[] endPosition, Board board) {
        int boardBoundary = board.getBoard().length-1;
        int[] nextPosition = new int[2];
        int startX = startPosition[0];
        int startY = startPosition[1];
        int endX = endPosition[0];
        int endY = endPosition[1];


        if (startPosition[0] < 0 || startPosition[1] < 0){
            return false;
        }
        if (Arrays.equals(startPosition, endPosition)) {
            return true;
        }
        //   [x,y] --horizontal---> [x,y]
        //   [0,0] ---------------> [2,0]
        //     |
        //     |
        //     V
        //   [0,2]
        // Check whether end pos > start pos || COMPARE X AND Y TO DETERMINE DIRECTION
        //for example, 0,2 and 2,2, are x the same, if not, add 1. are y the same? yes, dont change. you end up with 1,2.
        if (startX <= endX) {
//            nextPosition = {startingPosition[0], startingPosition[1]++};

            //CHECK IF X IS LESS, ADD 1, IF X IS MORE MINUS 1, ELSE EQUALS THE SAME
            //CHECK IF Y IS LESS, ADD 1, IF Y IS MORE MINUS 1, ELSE EQUALS THE SAME

            //HORIZONTAL
            // X++ Y
            // IF Y IS THE SAME
            if(startY == endY){
                nextPosition[0] = (startX+1 <= boardBoundary) ? startX+1 : startX;
                nextPosition[1] = startY;
             return (board.getPosition(startX, startY) == board.getPosition(nextPosition[0], nextPosition[1])) && checkWin(nextPosition, endPosition, board);
            }
//            //VERTICAL
//            // X   Y++
//            // IF X IS THE SAME
            if(startX == endX){
                nextPosition[0] = startX;
                nextPosition[1] = (startY+1 <= boardBoundary) ? startY+1 : startY;;
                return board.getPosition(startX, startY) == board.getPosition(nextPosition[0], nextPosition[1]) && checkWin(nextPosition, endPosition, board);
            }
//            //DIAGONAL LEFT RIGHT
//            // X == Y
//            // IF THEY ==

//            //DIAGONAL RIGHT LEFT
//            // X++ Y--
//            //IF X IS LESS, Y IS MORE

            return false;
        }

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
        return false;

        //
    }
}
