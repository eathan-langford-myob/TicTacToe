package com.company;

public class Rules {
    private static int x = 0;
    private static int y = 1;
    private static int starting = 0;
    private static int ending = 1;

    public static boolean checkBoardForWinState(Board board) {
        int boardLength = board.BoardLength();
        boolean isWinPresent;

        for (int i = 0; i < boardLength; i++) {

            Coordinates[] horizontalStartEndCoordinates = { new Coordinates(0,i), new Coordinates(boardLength-1, i ) };
            Coordinates[] verticalStartEndCoordinates = { new Coordinates(i,0), new Coordinates(i, boardLength-1) };

            isWinPresent =
                    checkWinInSingleDirection(horizontalStartEndCoordinates, board) ||
                            checkWinInSingleDirection(verticalStartEndCoordinates, board);

            if (isWinPresent){
                return true;
            }
        }
        Coordinates[] diagonalLeftTopToBottomRightStartEndCoordinates = {new Coordinates(0,0), new Coordinates(boardLength-1, boardLength-1)};
        Coordinates[] diagonalLeftBottomToTopRightStartEndCoordinates = { new Coordinates(0, boardLength-1), new Coordinates((-1 * 0 + (boardLength-1)),0)};
        isWinPresent = checkWinInSingleDirection(diagonalLeftTopToBottomRightStartEndCoordinates, board) || checkWinInSingleDirection(diagonalLeftBottomToTopRightStartEndCoordinates, board);

        return isWinPresent;
    }

    private static boolean isHorizontal(Coordinates[] coordinates){
        return coordinates[starting].getY() == coordinates[ending].getY();
    }
    private static boolean isVertical(Coordinates[] coordinates){
        return coordinates[starting].getX() == coordinates[ending].getX();
    }
    private static boolean isDiagonalFromTopLeft(Coordinates[] coordinates){
        return coordinates[starting].getX() == coordinates[starting].getY();
    }
    private static boolean isDiagonalFromBottomLeft(Coordinates[] coordinates){
        return (coordinates[starting].getX() < coordinates[ending].getX()) && (coordinates[starting].getY() > coordinates[ending].getY());
    }

    static boolean checkWinInSingleDirection(Coordinates[] coordinates, Board board) {
        int boardBoundary = board.BoardLength()-1;
        Coordinates[] nextCoordinates = new Coordinates[2];
        nextCoordinates[ending] = coordinates[ending];


        if ( (board.getPosition(coordinates[starting])) == '*' ){
            return false;
        }

        if (coordinates[starting].equals(coordinates[ending])) {
            return true;
        }
        if (isDiagonalFromBottomLeft(coordinates)) {
            nextCoordinates[starting] = (coordinates[starting].getX()+1 <= boardBoundary) && (coordinates[starting].getY()-1 >= 0) ?
                    coordinates[starting].increment(coordinates[starting], "diagonalBottomLeftToTopRight") : coordinates[starting];
            return board.getPosition(coordinates[starting]) == board.getPosition(nextCoordinates[starting]) && checkWinInSingleDirection(nextCoordinates, board);
        }

        if(isHorizontal(coordinates)){
            nextCoordinates[starting] = (coordinates[starting].getX()+1 <= boardBoundary) ?
                    coordinates[starting].increment(coordinates[starting], "horizontal") : coordinates[starting];
            return board.getPosition(coordinates[starting]) == board.getPosition(nextCoordinates[starting]) && checkWinInSingleDirection(nextCoordinates, board);
        }

        if(isVertical(coordinates)){
            nextCoordinates[starting] = (coordinates[starting].getY()+1 <= boardBoundary) ?
                    coordinates[starting].increment(coordinates[starting], "vertical") : coordinates[starting];
            return board.getPosition(coordinates[starting]) == board.getPosition(nextCoordinates[starting]) && checkWinInSingleDirection(nextCoordinates, board);
        }

        if (isDiagonalFromTopLeft(coordinates)) {
            nextCoordinates[starting] = (coordinates[starting].getX()+1 <= boardBoundary && coordinates[starting].getY() <= boardBoundary) ?
                    coordinates[starting].increment(coordinates[starting], "diagonalTopLeftToBottomRight") : coordinates[starting];
            return board.getPosition(coordinates[starting]) == board.getPosition(nextCoordinates[starting]) && checkWinInSingleDirection(nextCoordinates, board);
        }

        return false;
    }
}