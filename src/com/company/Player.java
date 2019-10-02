package com.company;
 public class Player {
    private char piece;
    private int player;

    Player(int player) {
         this.player = player;
         this.piece = (player == 1) ? 'X' : 'O';
     }

     public char getPiece() {
         return piece;
     }

     public int getPlayer() {
         return player;
     }
 }
