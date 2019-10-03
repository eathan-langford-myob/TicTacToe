package com.company;

public class Board {
    private char[][] board;

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

    public char getPosition(int x, int y) {
        return board[x][y];
    }

    public boolean isPositionAvailable(int x, int y) {
        return board[x][y]==('*');
    }

    public char SetPieceOnBoard(Player player, int x, int y) {
        board[x][y] = player.getPiece();
        return board[x][y];
    }
}
