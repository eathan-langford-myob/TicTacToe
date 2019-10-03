package com.company;

import java.util.HashMap;

public class Rules {



    public static boolean checkHorizontalWin(Player p1, Player p2, Board board) {
        char player1 = p1.getPiece();
        char player2 = p2.getPiece();
        boolean horizontalWin = false;

        for (int y = 0; y < 3; y++) {
            HashMap<Character, Integer> horizontalPieces = new HashMap<>(2);
            horizontalPieces.put(player1, 0);
            horizontalPieces.put(player2, 0);

            for (int x = 0; x < 3; x++) {
                if (board.getPosition(x,y)==player1) {
                    horizontalPieces.put(player1, horizontalPieces.get(player1)+1);
                } else if (board.getPosition(x,y)==player2) {
                    horizontalPieces.put(player2, horizontalPieces.get(player2)+1);
                }
            }
            if( (horizontalPieces.get(player1)==3) | ((horizontalPieces.get(player2)==3)) ){
                horizontalWin = true;
            }
        }
        return horizontalWin;
    }

    static public boolean checkWinConditions(Player player1, Player player2, Board board) {
        boolean winCondition = false;
        while (!winCondition) {
           winCondition = checkHorizontalWin(player1, player2, board);
        }

        return winCondition;
    }


}
