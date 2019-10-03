package com.company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;


public class RulesTest {
    Game newGame;
    Board gameBoard;
    Player player1;
    Player player2;
    Board threeAcross;
    Board threeDiagonal;
    Board threeDown;

    @Before
    public void setUp() {
        player1 = new Player(1);
        player2 = new Player(2);


        gameBoard = new Board(3,3);

        threeAcross = new Board(3,3);
        threeDiagonal = new Board(3,3);
        threeDown = new Board(3,3);

        for (int i = 0; i < 3; i++) {
            threeAcross.SetPieceOnBoard(player1,i,0);
            threeDiagonal.SetPieceOnBoard(player1,i,i);
            threeDown.SetPieceOnBoard(player1,0,i);
        }

        newGame = new Game();
    }

    @After
    public void tearDown() {
        threeAcross = null;
        threeDiagonal = null;
        threeDown = null;
    }

    @Test
    public void shouldReturnWinConditionForThreeAcross() {
        boolean actual = Rules.checkHorizontalWin(player1, player2, threeAcross);
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnWinConditionForThreeDown() {
        boolean actual = Rules.checkVerticalWin(player1, player2, threeDown);
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

}