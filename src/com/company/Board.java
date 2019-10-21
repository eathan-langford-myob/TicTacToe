package com.company;

public class Board {
    private Character[][] board;
    private int length;

    public Board(int size){
        char tile = '*';
        board = new Character[size][size];
        length = size;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                board[x][y] = tile;
            }
        }
    }

    public Character[][] getBoard(){
        return board;
    }

    public int getBoardLength() {
        return length;
    }

    public Character getPosition(Coordinates queryCoordinates) {
        return board[queryCoordinates.getX()][queryCoordinates.getY()];
    }


    public boolean isPositionAvailable(Coordinates queryCoordinates) {
        return getPosition(queryCoordinates) == ('*');
    }

    public void SetPieceOnBoard(Character piece, Coordinates queryCoordinates) {
        board[queryCoordinates.getX()][queryCoordinates.getY()] = piece;
    }
}
