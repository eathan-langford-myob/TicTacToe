package com.company;

public class Rules {

    public static boolean checkBoardForWinState(Board board) {
        int boardLength = board.getBoardLength();

        boolean isWinPresent;
            for (int i = 0; i < boardLength; i++) {
                isWinPresent =
                        checkWinInSingleDirection(0,i, boardLength-1,i, board) ||
                        checkWinInSingleDirection(i,0, i,boardLength-1, board);

                if (isWinPresent){
                    return true;
                }
            }
                isWinPresent = checkWinInSingleDirection(0,0, boardLength-1,boardLength-1, board) || checkWinInSingleDirection(0,boardLength-1, (-1 * 0 + (boardLength-1)),0, board);
        return isWinPresent;
    }

    static boolean checkWinInSingleDirection(int startX, int startY, int endX, int endY, Board board) {
        int boardBoundary = board.getBoardLength()-1;
        int nextPositionX;
        int nextPositionY;


        if ( (board.getPosition(startX,startY)) == '*' ){
            return false;
        }
        if (startX < 0 || startY < 0){
            return false;
        }
        if (startX == endX && startY == endY) {
            return true;
        }
        if (startX <= endX) {
            if ( (startX < endX) && (startY > endY) ) {
                nextPositionX = (startX+1 <= boardBoundary) ? startX+1 : startX;
                nextPositionY = (startY-1 < 0) ? startY : startY-1;
                return board.getPosition(startX, startY) == board.getPosition(nextPositionX, nextPositionY) && checkWinInSingleDirection(nextPositionX, nextPositionY, endX, endY, board);
            }

            if(startY == endY){
                nextPositionX = (startX+1 <= boardBoundary) ? startX+1 : startX;
                nextPositionY = startY;
                return (board.getPosition(startX, startY) == board.getPosition(nextPositionX, nextPositionY)) && checkWinInSingleDirection(nextPositionX, nextPositionY, endX, endY, board);
            }

            if(startX == endX){
                nextPositionX = startX;
                nextPositionY = (startY+1 <= boardBoundary) ? startY+1 : startY;
                return board.getPosition(startX, startY) == board.getPosition(nextPositionX, nextPositionY) && checkWinInSingleDirection(nextPositionX, nextPositionY, endX, endY, board);
            }

            if (startX == startY) {
                nextPositionX = (startX+1 <= boardBoundary) ? startX+1 : startX;
                nextPositionY = (startY+1 <= boardBoundary) ? startY+1 : startY;
                return board.getPosition(startX, startY) == board.getPosition(nextPositionX, nextPositionY) && checkWinInSingleDirection(nextPositionX, nextPositionY, endX, endY, board);
            }

            return false;
        }
        return false;
    }
}