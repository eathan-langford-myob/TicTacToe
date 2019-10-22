package com.company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



import static com.company.Rules.*;
import static org.junit.Assert.*;


public class RulesTest {
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
        threeAcross = new Board(3);
        threeAcross.SetPieceOnBoard(player1.getPiece(), new Coordinates(0, 0));
        threeAcross.SetPieceOnBoard(player1.getPiece(), new Coordinates(1, 0));
        threeAcross.SetPieceOnBoard(player1.getPiece(), new Coordinates(2, 0));
        Coordinates[] coordinates = { new Coordinates(0,0) , new Coordinates(threeAcross.BoardLength()-1,0)};
        boolean actual = checkWinInSingleDirection(coordinates, threeAcross);
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnWinConditionForThreeDown() {
//            {'X','*','*'}
//            {'X','*','*'}
//            {'X','*','*'}
        threeDown = new Board(3);
        threeDown.SetPieceOnBoard(player1.getPiece(), new Coordinates(0, 0));
        threeDown.SetPieceOnBoard(player1.getPiece(), new Coordinates(0, 1));
        threeDown.SetPieceOnBoard(player1.getPiece(), new Coordinates(0, 2));
        Coordinates[] coordinates = { new Coordinates(0,0) , new Coordinates(0,threeDown.BoardLength()-1) };
        boolean actual = checkWinInSingleDirection(coordinates, threeDown);
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }
    //
    @Test
    public void shouldReturnWinConditionForDiagonalLeftTopDown() {
////               {'X','*','*'}
////               {'*','X','*'}
////               {'*','*','X'}
        threeDiagonalTopLeft = new Board(3);
        threeDiagonalTopLeft.SetPieceOnBoard(player1.getPiece(), new Coordinates(0, 0));
        threeDiagonalTopLeft.SetPieceOnBoard(player1.getPiece(), new Coordinates(1, 1));
        threeDiagonalTopLeft.SetPieceOnBoard(player1.getPiece(), new Coordinates(2, 2));
        Coordinates[] coordinates = { new Coordinates(0,0) , new Coordinates(threeDiagonalTopLeft.BoardLength()-1,threeDiagonalTopLeft.BoardLength()-1) };
        boolean actual = checkWinInSingleDirection(coordinates, threeDiagonalTopLeft);
        boolean expected = true;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnWinConditionForDiagonalRightTopDown() {
////               {'*','*','X'}
////               {'*','X','*'}
////               {'X','*','*'}
        threeDiagonalTopRight = new Board(3);
        threeDiagonalTopRight.SetPieceOnBoard(player1.getPiece(), new Coordinates(2, 0));
        threeDiagonalTopRight.SetPieceOnBoard(player1.getPiece(), new Coordinates(1, 1));
        threeDiagonalTopRight.SetPieceOnBoard(player1.getPiece(), new Coordinates(0, 2));
        Coordinates[] coordinates = { new Coordinates(0,threeDiagonalTopRight.BoardLength()-1), new Coordinates(threeDiagonalTopRight.BoardLength()-1,0)};
        boolean actual = checkWinInSingleDirection(coordinates, threeDiagonalTopRight);
        boolean expected = true;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTrueForWinCheckingWholeBoard() {
////               {'*','O','*'}
////               {'X','X','X'}
////               {'*','O','*'}
        Board mockPlayedBoardHorizontalWin = new Board(3);
        mockPlayedBoardHorizontalWin.SetPieceOnBoard(player1.getPiece(), new Coordinates(0, 1));
        mockPlayedBoardHorizontalWin.SetPieceOnBoard(player2.getPiece(), new Coordinates(2, 1));
        mockPlayedBoardHorizontalWin.SetPieceOnBoard(player1.getPiece(), new Coordinates(1, 1));
        mockPlayedBoardHorizontalWin.SetPieceOnBoard(player2.getPiece(), new Coordinates(1, 2));
        mockPlayedBoardHorizontalWin.SetPieceOnBoard(player1.getPiece(), new Coordinates(2, 1));
        boolean actual = checkBoardForWinState(mockPlayedBoardHorizontalWin);
        boolean expected = true;

        assertEquals(expected, actual);
    }

}