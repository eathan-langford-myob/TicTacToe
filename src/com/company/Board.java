package com.company;

public class Board {
    char[][] board;

    public Board(int x, int y){
        char tile = '*';
        board = new char[x][y];
        for (char[] column : board) {
            for (int i = 0; i < column.length; i++) {
                column[i] = tile;
            }
        }
    }

    public char[][] getBoard(){
        return board;
    }

//    public char[][] generateBoard(int x, int y){
//        char tile = '*';
//        board = new char[x][y];
//        for (char[] column : board) {
//            for (int i = 0; i < column.length; i++) {
//                column[i] = tile;
//            }
//        }
//        return board;
//    }

    public boolean isPositionAvailable(int x, int y) {
        return board[x-1][y-1]!=('X'|'Y');
    }
}
