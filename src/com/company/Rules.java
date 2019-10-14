package com.company;

import java.util.Arrays;

public class Rules {

    public static boolean checkBoardForWinState(Board board) {
        for (int i = 0; i < board.getBoard().length-1; i++) {

        }
        return false;
    }

    public static boolean checkWinInSingleDirection(int[] startPosition, int[] endPosition, Board board) {
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
        if (startX <= endX) {
            if ( (startX < endX) && (startY > endY) ) {
                nextPosition[0] = (startX+1 <= boardBoundary) ? startX+1 : startX;
                nextPosition[1] = (startY-1 < 0) ? startY : startY-1;
                return board.getPosition(startX, startY) == board.getPosition(nextPosition[0], nextPosition[1]) && checkWinInSingleDirection(nextPosition, endPosition, board);
            }

            if(startY == endY){
                nextPosition[0] = (startX+1 <= boardBoundary) ? startX+1 : startX;
                nextPosition[1] = startY;
                return (board.getPosition(startX, startY) == board.getPosition(nextPosition[0], nextPosition[1])) && checkWinInSingleDirection(nextPosition, endPosition, board);
            }

            if(startX == endX){
                nextPosition[0] = startX;
                nextPosition[1] = (startY+1 <= boardBoundary) ? startY+1 : startY;
                return board.getPosition(startX, startY) == board.getPosition(nextPosition[0], nextPosition[1]) && checkWinInSingleDirection(nextPosition, endPosition, board);
            }

            if (startX == startY) {
                nextPosition[0] = (startX+1 <= boardBoundary) ? startX+1 : startX;
                nextPosition[1] = (startY+1 <= boardBoundary) ? startY+1 : startY;
                return board.getPosition(startX, startY) == board.getPosition(nextPosition[0], nextPosition[1]) && checkWinInSingleDirection(nextPosition, endPosition, board);
            }

            return false;
        }
        return false;
    }
}