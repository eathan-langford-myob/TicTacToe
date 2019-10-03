package com.company;

public class Board {
    private Character[][] board;

    public Board(int x, int y){
        char tile = '*';
        board = new Character[x][y];
        for (Character[] column : board) {
            for (int i = 0; i < column.length; i++) {
                column[i] = tile;
            }
        }
    }

    public Character[][] getBoard(){
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
