package com.company.IO;

import com.company.Board;
import com.company.Coordinates;

public class StringRender implements Render {
    @Override
    public String renderBoard(Board board) {
        int boardLength = board.getBoardLength();
        StringBuilder parsedBoard = new StringBuilder();
        for (int x = 0; x < boardLength; x++) {
            for (int y = 0; y < boardLength; y++) {
                Coordinates coordinate = new Coordinates(x,y);
                parsedBoard.append(board.getPosition(coordinate));
                if (y != boardLength-1){
                    parsedBoard.append("  ⁻  ");
                }
            }
            if(x != boardLength-1) {
                parsedBoard.append("\n");
                for (int i = 0; i < boardLength; i++) {
                    parsedBoard.append("ᶦ");
                    if (i != boardLength-1){
                        parsedBoard.append("  ⁻  ");
                    }
                }
                parsedBoard.append("\n");
            }
        }
        return parsedBoard.toString();
    }
}
