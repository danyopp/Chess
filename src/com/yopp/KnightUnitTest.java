package com.yopp;

public class KnightUnitTest {
    public static void main(String[] args) {
    //legal moves
    Board z = new Board(1);
        z.updateGamePlay(0, new Knight(1, 1,4,0));
        System.out.println("Attempt to move a knight - should pass");
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 0,2));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 2,2));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 3,3));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 3,5));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 2,6));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 0,6));
        z.printBoard();

    //same space move or invalid moves
        z = new Board(1);
        z.updateGamePlay(0, new Knight(1, 1,4,0));
        System.out.println("Attempt to move a knight invalidly");
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 1,4));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 0,4));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), -1,3));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), -1,5));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 4,4));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 4,7));
        z.printBoard();


    //attack moves
        z = new Board(1);
        z.updateGamePlay(0, new Knight(1, 1,4,0));
        z.updateGamePlay(1, new Pawn(2, 2,2,1));
        z.updateGamePlay(2, new Pawn(2, 3,3,2));
        z.updateGamePlay(3, new Pawn(2, 2,3,3)); //should be invalid
        System.out.println("Attack moves - pass pass fail");
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 2,2));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 3,3));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 2,3));
        z.printBoard();

    //attack moves same team
        z = new Board(1);
        z.updateGamePlay(0, new Knight(1, 1,4,0));
        z.updateGamePlay(1, new Pawn(1, 2,2,1));
        z.updateGamePlay(2, new Pawn(1, 3,3,2));
        z.updateGamePlay(3, new Pawn(1, 2,3,3)); //should be invalid
        System.out.println("Attack moves same team");
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 2,2));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 3,3));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 2,3));
        z.printBoard();


}

}
