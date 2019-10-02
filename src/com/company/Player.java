package com.company;
 public class Player {
    private char piece;
    private int player;

    Player(char piece, int player) {
         this.piece = piece;
         this.player = player;
     }

     public char getPiece() {
         return piece;
     }

     public int getPlayer() {
         return player;
     }
 }
