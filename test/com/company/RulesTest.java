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
    Board threeDiagonalTopLeft;
    Board threeDown;
    Board threeDiagonalTopRight;

    @Before
    public void setUp() {
        player1 = new Player(1);
        player2 = new Player(2);


        gameBoard = new Board(3,3);

        threeAcross = new Board(3,3);
        threeDiagonalTopLeft = new Board(3,3);
        threeDiagonalTopRight = new Board(3,3);
        threeDown = new Board(3,3);
        int inverseI =  2;
        for (int i = 0; i < 3; i++) {
            threeAcross.SetPieceOnBoard(player1,i,0);
            threeDiagonalTopLeft.SetPieceOnBoard(player1,i,i);
            threeDiagonalTopRight.SetPieceOnBoard(player1, i,inverseI);
            threeDown.SetPieceOnBoard(player1,i,i);
            inverseI-=1;
        }

        newGame = new Game();
    }

    @After
    public void tearDown() {
        threeAcross = null;
        threeDiagonalTopLeft = null;
        threeDown = null;
    }

    @Test
    public void shouldReturnWinConditionForThreeAcross() {
        boolean actual = Rules.checkHorizontals(threeAcross);
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnWinConditionForThreeDown() {
        boolean actual = Rules.checkVerticals(threeDown);
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnWinConditionForDiagonalLeftTopDown() {
        boolean actual = Rules.checkVerticalTopLeft(threeDiagonalTopLeft);
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnWinConditionForDiagonalRightTopDown() {
        boolean actual = Rules.checkVerticalTopRight(threeDiagonalTopRight);
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

}