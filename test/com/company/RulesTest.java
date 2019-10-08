package com.company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static com.company.Rules.*;
import static org.junit.Assert.*;


public class RulesTest {
    Game newGame;
    Board gameBoard;
    Player player1;
    Player player2;
    Board threeDiagonalTopLeft;
    Board threeDown;
    Board threeDiagonalTopRight;

    @Before
    public void setUp() {
        player1 = new Player(1);
        player2 = new Player(2);


        gameBoard = new Board(3);
        newGame = new Game(3);
    }

    @After
    public void tearDown() {
        threeDiagonalTopLeft = null;
        threeDown = null;
    }

    @Test
    public void shouldReturnWinConditionForThreeAcross() {
//            {'X','X','X'}
//            {'*','*','*'}
//            {'*','*','*'}
        Board threeAcross = new Board(3);
        threeAcross.SetPieceOnBoard(player1, 0, 0);
        threeAcross.SetPieceOnBoard(player1, 1, 0);
        threeAcross.SetPieceOnBoard(player1, 2, 0);
        int[] lastMove = {1,0};

        boolean actual = checkLinearFromLastMove(threeAcross, lastMove[0], lastMove[1]);
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnWinConditionForThreeDown() {
//            {'X','*','*'}
//            {'X','*','*'}
//            {'X','*','*'}
        Board threeDown = new Board(3);
        threeDown.SetPieceOnBoard(player1, 0, 0);
        threeDown.SetPieceOnBoard(player1, 0, 1);
        threeDown.SetPieceOnBoard(player1, 0, 2);
        int[] lastMove = {0,1};

        boolean actual = checkLinearFromLastMove(threeDown, lastMove[0], lastMove[1]);
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }
//
    @Test
    public void shouldReturnWinConditionForDiagonalLeftTopDown() {
//               {'X','*','*'}
//               {'*','X','*'}
//               {'*','*','X'}
            Board threeDiagonalTopLeft = new Board(3);
            threeDiagonalTopLeft.SetPieceOnBoard(player1, 0, 0);
            threeDiagonalTopLeft.SetPieceOnBoard(player1, 1, 1);
            threeDiagonalTopLeft.SetPieceOnBoard(player1, 2, 2);
            int[] lastMove = {1,1};

        boolean actual = checkDiagonalsFromLastMove(threeDiagonalTopLeft, lastMove[0], lastMove[1]);
        boolean expected = true;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnWinConditionForDiagonalRightTopDown() {
//               {'*','*','X'}
//               {'*','X','*'}
//               {'X','*','*'}
        Board threeDiagonalTopRight = new Board(3);
        threeDiagonalTopRight.SetPieceOnBoard(player1, 2, 0);
        threeDiagonalTopRight.SetPieceOnBoard(player1, 1, 1);
        threeDiagonalTopRight.SetPieceOnBoard(player1, 0, 2);
        int[] lastMove = {0,2};

        boolean actual = checkDiagonalsFromLastMove(threeDiagonalTopRight, lastMove[0], lastMove[1]);
        boolean expected = true;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnWinConditionForWinCheckingDiagonalBoard() {
//                       {'*','*','X'}
//                       {'*','X','*'}
//                       {'X','*','*'}
        Board threeDiagonalTopRight = new Board(3);
        threeDiagonalTopRight.SetPieceOnBoard(player1, 2, 0);
        threeDiagonalTopRight.SetPieceOnBoard(player1, 1, 1);
        threeDiagonalTopRight.SetPieceOnBoard(player1, 0, 2);
        int[] lastMove = {0,2};
        boolean actual = checkWinConditions(threeDiagonalTopRight, lastMove[0], lastMove[1]);
        boolean expected = true;

        assertEquals(expected, actual);
    }
}