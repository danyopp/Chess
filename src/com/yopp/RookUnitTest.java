package com.yopp;

public class RookUnitTest {
    public static void main(String[] args) {
        //legal moves
        Board z = new Board(1);
        z.updateGamePlay(0, new Rook(1, 4,4,0));
        System.out.println("Attempt to move a rook - should pass");
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 0,4));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 7,4));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 4,0));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 4, 7));
        z.printBoard();

        //same space move
        z = new Board(1);
        z.updateGamePlay(0, new Rook(1, 4,4,0));
        System.out.println("Attempt to move a rook to same space");
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 4,4));
        z.printBoard();

        //diagonal moves
        z = new Board(1);
        z.updateGamePlay(0, new Rook(1, 4,4,0));
        System.out.println("Attempt to move a rook diagonal");
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 7,3));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 5,5));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 1,7));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 2, 3));
        z.printBoard();

        //moves off the board
        z = new Board(1);
        z.updateGamePlay(0, new Rook(1, 4,4,0));
        System.out.println("Attempt to move a rook off board");
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), -2,4));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 8,4));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 4,-1));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 4, 8));
        z.printBoard();

        //attack moves
        z = new Board(1);
        z.updateGamePlay(0, new Rook(1, 2,6,0));
        z.updateGamePlay(1, new Knight(2, 2,7,1));
        z.updateGamePlay(2, new Knight(2, 2,0,2));
        z.updateGamePlay(3, new Knight(2, 7,6,3));
        System.out.println("Attempt to move a attack - should pass");
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 2,7));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 7,6));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 2,0));
        z.printBoard();

        //attack moves same team
        z = new Board(1);
        z.updateGamePlay(0, new Rook(1, 2,6,0));
        z.updateGamePlay(1, new Knight(1, 2,7,1));
        z.updateGamePlay(2, new Knight(1, 2,0,2));
        z.updateGamePlay(3, new Knight(1, 7,6,3));
        System.out.println("Attempt to move a attack on own team");
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 2,7));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 7,6));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 2,0));
        z.printBoard();

        //block moves own team
        z = new Board(1);
        z.updateGamePlay(0, new Rook(1, 2,6,0));
        z.updateGamePlay(1, new Knight(2, 0,6,1));
        z.updateGamePlay(2, new Knight(2, 2,0,2));
        z.updateGamePlay(3, new Knight(2, 7,6,3));
        z.updateGamePlay(4, new Bishop(1, 1, 6,4));
        z.updateGamePlay(5, new Bishop(1, 2, 1,5));
        z.updateGamePlay(6, new Bishop(1, 3, 6,6));
        System.out.println("blocked moves by own team");
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 0,6));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 7,6));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 2,0));
        z.printBoard();

        //block moves other team
        z = new Board(1);
        z.updateGamePlay(0, new Rook(1, 2,6,0));
        z.updateGamePlay(1, new Knight(2, 0,6,1));
        z.updateGamePlay(2, new Knight(2, 2,0,2));
        z.updateGamePlay(3, new Knight(2, 7,6,3));
        z.updateGamePlay(4, new Bishop(2, 1, 6,4));
        z.updateGamePlay(5, new Bishop(2, 2, 1,5));
        z.updateGamePlay(6, new Bishop(2, 3, 6,6));
        System.out.println("Block moves by other team");
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 0,6));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 7,6));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 2,0));
        z.printBoard();
    }
}
