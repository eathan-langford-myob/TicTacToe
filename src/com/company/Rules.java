package com.company;

import java.util.Arrays;
import java.util.HashMap;

public class Rules {



//    public static boolean checkHorizontalWin(Player p1, Player p2, Board board) {
//        char player1 = p1.getPiece();
//        char player2 = p2.getPiece();
//
//        boolean horizontalWin = false;
//        for (int y = 0; y < board.getBoard().length; y++) {
//            HashMap<Character, Integer> horizontalPieces = new HashMap<>(2);
//            horizontalPieces.put(player1, 0);
//            horizontalPieces.put(player2, 0);
//
//            for (int x = 0; x < board.getBoard()[0].length; x++) {
//                if (board.getPosition(x,y)==player1) {
//                    horizontalPieces.put(player1, horizontalPieces.get(player1)+1);
//                } else if (board.getPosition(x,y)==player2) {
//                    horizontalPieces.put(player2, horizontalPieces.get(player2)+1);
//                }
//            }
//            if( (horizontalPieces.get(player1)==3) | ((horizontalPieces.get(player2)==3)) ){
//                horizontalWin = true;
//            }
//        }
//        return horizontalWin;
//    }

        public static boolean checkHorizontals (Board board) {
        Character[] oneRow = new Character[board.getBoard().length];
        boolean horizontalWin;
        for (int y = 0; y < board.getBoard().length; y++) {
            for (int x = 0; x < board.getBoard()[0].length; x++) {
                oneRow[x] = board.getPosition(x, y);
            }
        }
        horizontalWin = Arrays.stream(oneRow).distinct().count() == 1;
        return horizontalWin;
        }

    public static boolean checkVerticals (Board board) {
        boolean verticalWin;
        Character[] oneColumn = new Character[board.getBoard()[0].length];
        for (int x = 0; x < board.getBoard()[0].length; x++) {
            oneColumn = board.getBoard()[x];
        }
        verticalWin = (Arrays.stream(oneColumn).distinct().count() == 1);
        return verticalWin;
    }

    public static boolean checkDiagonalTopLeft(Board board) {
        Character[] oneDiagnonal = new Character[board.getBoard().length];
        boolean diagonalWin;
        for (int x = 0; x < board.getBoard()[0].length; x++) {
            oneDiagnonal[x] = board.getPosition(x, x);
        }
        diagonalWin = Arrays.stream(oneDiagnonal).distinct().count() == 1;
        return diagonalWin;
    }

    public static boolean checkDiagonalTopRight(Board board) {
        Character[] oneDiagnonal = new Character[board.getBoard().length];
        boolean diagonalWin;
        int y = board.getBoard().length -1;
        for (int x = 0; x < board.getBoard().length; x++) {
            oneDiagnonal[x] = board.getPosition(x, y);
            y-=1;
        }
        diagonalWin = Arrays.stream(oneDiagnonal).distinct().count() == 1;
        return diagonalWin;
    }

    public static boolean checkWinConditions(Board board) {
        return checkHorizontals(board)||checkVerticals(board)||checkDiagonalTopLeft(board)||checkDiagonalTopRight(board);
    }
}
