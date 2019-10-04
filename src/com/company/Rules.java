package com.company;

import java.util.Arrays;
import java.util.HashMap;

public class Rules {
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
