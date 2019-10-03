package com.company;

import java.util.HashMap;
import java.util.stream.IntStream;

public class Game {

    Board board;
    private Player player1;
    private Player player2;

    public Game() {
        //currently making a new game generate a new board and players, and make it testable with a fake board.
        this.board = new Board(3,3);
        this.player1 = new Player(1);
        this.player2 = new Player(1);
    }


}
