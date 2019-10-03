//package com.company;
//
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//
//import static org.junit.Assert.*;
//
//
//public class GameTest {
//    Game newGame;
//    Board gameBoard;
//    Player player1;
//    Board threeAcross;
//    Board threeDiagonal;
//    Board threeDown;
//
//    @Before
//    public void setUp() {
//        player1 = new Player(1);
//
//        gameBoard = new Board(3,3);
//
//        threeAcross = new Board(3,3);
//        threeDiagonal = new Board(3,3);
//        threeDown = new Board(3,3);
//
//        for (int i = 0; i < 2; i++) {
//            threeAcross.SetPieceOnBoard(player1,i,0);
//            threeDiagonal.SetPieceOnBoard(player1,i,i);
//            threeDown.SetPieceOnBoard(player1,0,i);
//        }
//    }
//
//    @After
//    public void tearDown() {
//        threeAcross = null;
//        threeDiagonal = null;
//        threeDown = null;
//    }
//
//    @Test
//    public void shouldReturnWinConditionForThreeAcross() {
//        newGame = new Game(threeAcross);
//        boolean actual = newGame.checkHorizontalWin();
//        boolean expected = true;
//
//        Assert.assertEquals(expected, actual);
//    }
//
//}
