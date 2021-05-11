package com.yopp;

public class QueenUnitTest {

    public static void main(String[] args) {
        //legal moves
        Board z = new Board(1);
        z.updateGamePlay(0, new Queen(1, 4,4,0));
        System.out.println("Attempt to move a queen - should pass");
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 1,7));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 0,0));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 7,1));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 5, 5));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 0,4));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 7,4));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 4,0));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 4, 7));
        z.printBoard();

        //illegal moves
        z = new Board(1);
        z.updateGamePlay(0, new Queen(1, 4,4,0));
        System.out.println("Attempt to move a queen illegally");
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 4,4));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 1,3));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), -1,8));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 8,8));
        z.printBoard();


        //attack moves
        z = new Board(1);
        z.updateGamePlay(0, new Queen(1, 4,4,0));
        z.updateGamePlay(1, new Knight(2, 3,3,1));
        z.updateGamePlay(2, new Knight(2, 7,1,2));
        z.updateGamePlay(3, new Knight(2, 7,7,3));
        System.out.println("Attempt to move a attack - should pass");
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 3,3));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 7,1));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 7,7));
        z.printBoard();

        //attack moves
        z = new Board(1);
        z.updateGamePlay(0, new Queen(1, 2,6,0));
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
        z.updateGamePlay(0, new Queen(1, 4,4,0));
        z.updateGamePlay(1, new Knight(1, 3,3,1));
        z.updateGamePlay(2, new Knight(1, 7,1,2));
        z.updateGamePlay(3, new Knight(1, 7,7,3));
        System.out.println("Attempt to move a attack same team");
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 3,3));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 7,1));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 7,7));
        z.printBoard();

        //attack moves same team
        z = new Board(1);
        z.updateGamePlay(0, new Queen(1, 2,6,0));
        z.updateGamePlay(1, new Knight(1, 2,7,1));
        z.updateGamePlay(2, new Knight(1, 2,0,2));
        z.updateGamePlay(3, new Knight(1, 7,6,3));
        System.out.println("Attempt to move a attack same team");
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 2,7));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 7,6));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 2,0));
        z.printBoard();



        //block moves own team
        z = new Board(1);
        z.updateGamePlay(0, new Queen(1, 4,4,0));
        z.updateGamePlay(1, new Knight(1, 5,5,1));
        z.updateGamePlay(2, new Knight(2, 7,7,2));
        z.updateGamePlay(3, new Knight(1, 6,2,3));
        z.updateGamePlay(4, new Knight(2, 7,1,4));
        System.out.println("Attempt to move a attack with a team block");
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 7,7));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 7,1));
        z.printBoard();

        //block moves own team
        z = new Board(1);
        z.updateGamePlay(0, new Queen(1, 2,6,0));
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
        z.updateGamePlay(0, new Queen(1, 4,4,0));
        z.updateGamePlay(1, new Knight(2, 5,5,1));
        z.updateGamePlay(2, new Knight(2, 7,7,2));
        z.updateGamePlay(3, new Knight(2, 6,2,3));
        z.updateGamePlay(4, new Knight(2, 7,1,4));
        System.out.println("Attempt to move a attack with a team block");
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 7,7));
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 7,1));
        z.printBoard();

        //block moves other team
        z = new Board(1);
        z.updateGamePlay(0, new Queen(1, 2,6,0));
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
