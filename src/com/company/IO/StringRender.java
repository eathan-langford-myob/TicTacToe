package com.company.IO;

import com.company.Board;
import com.company.Coordinates;

public class StringRender implements Render {
    @Override
    public String renderBoard(Board board) {
        int boardLength = board.BoardLength();
        StringBuilder parsedBoard = new StringBuilder();
        parsedBoard.append(" ");
        for (int i = 0; i < boardLength; i++) {
            parsedBoard.append("     ");
            parsedBoard.append(i+1);

        }
        parsedBoard.append("\n");
        parsedBoard.append("    ");

        for (int i = 0; i < boardLength; i++) {
            parsedBoard.append("  :   ");
        }
        parsedBoard.append("\n");
        for (int y = 0; y < boardLength; y++) {
            parsedBoard.append(y+1);
            parsedBoard.append("  :  ");

            for (int x = 0; x < boardLength; x++) {
                Coordinates coordinate = new Coordinates(x,y);
                parsedBoard.append(board.getPosition(coordinate));
//                parsedBoard.append(x+","+y);
                if (x != boardLength-1){
                    parsedBoard.append("     ");
                }
            }
            if(y != boardLength-1) {
                parsedBoard.append("\n");
                parsedBoard.append("      ");
                for (int i = 0; i < boardLength; i++) {
                    parsedBoard.append(" ");
                    if (i != boardLength-1){
                        parsedBoard.append("     ");
                    }
                }
                parsedBoard.append("\n");
            }
        }
        return parsedBoard.toString();
    }
}
