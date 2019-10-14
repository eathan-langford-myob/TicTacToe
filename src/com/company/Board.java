package com.company;

public class Board {
    private Character[][] board;

    public Board(int size){
        char tile = '*';
        board = new Character[size][size];
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

//    public static int[] getNextTile(int[] startPosition, int[] endPosition) {
//        int startX = startPosition[0];
//        int startY = startPosition[1];
//        int endX = endPosition[0];
//        int endY = endPosition[1];
//        int nextX = 0;
//        int nextY = 0;
//        //CHECK IF X IS LESS, ADD 1, IF X IS MORE MINUS 1, ELSE EQUALS THE SAME
//        //CHECK IF Y IS LESS, ADD 1, IF Y IS MORE MINUS 1, ELSE EQUALS THE SAME
//        //HORIZONTAL
//        if (startX < endX) {
//            nextX++;
//        }
//        //VERTICAL
//        //DIAGONAL LEFT DOWN
//        //DIAGONAL RIGHT DOWN
//    }

    public boolean isPositionAvailable(int x, int y) {
        return board[x][y]==('*');
    }

    public char SetPieceOnBoard(Player player, int x, int y) {
        board[x][y] = player.getPiece();
        return board[x][y];
    }
}
