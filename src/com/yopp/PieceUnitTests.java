package com.yopp;

public class PieceUnitTests {

    public static void printResults(boolean expectedResult, boolean actualResult, String testDescription){
        System.out.print("TESTRESULT: " );
        if(expectedResult == actualResult) {
            System.out.print("PASSED - ");
            if(expectedResult) System.out.print("(Valid move detected)    -   ");
            else System.out.print("(Invalid move detected)  -   ");
        }
        else  System.out.print("FAILED (returned " + actualResult +" for valid move)- ");
        System.out.print(testDescription + "\n");
    }

    public static void main(String[] args) {
        System.out.println("PAWN TESTS");
        Board z = new Board(1);
        z.updateGamePlay(0, new Pawn(1, 3,1,0));
        MoveResults r = z.getByID(0).isValidMove(z.buildBoard(), 3,2);
        printResults(true, r.isValidMove() , "Attempt to move a starting pawn one space" );

        z = new Board(1);
        z.updateGamePlay(0, new Pawn(1, 3,1,0));
        z.updateGamePlay(1, new Pawn(2, 6,6,1));
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,0);
        printResults(false, r.isValidMove() , "Attempt to move a pawn backwards - Player 1" );
        r = z.getByID(1).isValidMove(z.buildBoard(), 6,7);
        printResults(false, r.isValidMove() , "Attempt to move a pawn backwards - Player 2" );

        z = new Board(1);
        z.updateGamePlay(0, new Pawn(1, 4,3,0));
        z.updateGamePlay(1, new Pawn(2, 7,6,1));
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,3);
        printResults(false, r.isValidMove() , "Attempt to move a pawn sideways - Player 1" );
        r = z.getByID(1).isValidMove(z.buildBoard(), 5,5);
        printResults(false, r.isValidMove() , "Attempt to move a pawn sideways - Player 2" );

        z = new Board(1);
        z.updateGamePlay(0, new Pawn(1, 0,1,0));
        z.updateGamePlay(1, new Pawn(2, 7,6,1));
        r = z.getByID(0).isValidMove(z.buildBoard(), -1,1);
        printResults(false, r.isValidMove(),"Attempt to move a pawn off board - Player 1");
        r = z.getByID(1).isValidMove(z.buildBoard(), 8,6);
        printResults(false, r.isValidMove(),"Attempt to move a pawn off board - Player 2");

        z = new Board(1);
        z.updateGamePlay(0, new Pawn(1, 3,1,0));
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,3);
        printResults(true, r.isValidMove() , "Attempt to move a starting pawn two space" );

        z = new Board(1);
        z.updateGamePlay(0, new Pawn(1, 3,1,0));
        z.updateGamePlay(1, new Knight(1,3,2,1));
        z.updateGamePlay(2, new Pawn(1, 6,1,2));
        z.updateGamePlay(3, new Knight(2,6,2,3));
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,3);
        printResults(false, r.isValidMove() , "Attempt to move a pawn over another piece - Player 1");
        r = z.getByID(2).isValidMove(z.buildBoard(), 6,3);
        printResults(false, r.isValidMove() , "Attempt to move a pawn over another piece - Player 2");

        z = new Board(1);
        z.updateGamePlay(0, new Pawn(1, 3,1,0));
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,3);
        printResults(false, r.isValidMove() , "Attempt to move a pawn two spaces diagonal");

        z = new Board(1);
        z.updateGamePlay(0, new Pawn(1, 3,1,0));
        z.updateGamePlay(1, new Knight(2, 2,2,1));
        r =z.getByID(0).isValidMove(z.buildBoard(), 2,2);
        printResults(true, r.isValidMove() , "Attempt to capture an enemy piece");

        z = new Board(1);
        z.updateGamePlay(0, new Pawn(1, 3,1,0));
        z.updateGamePlay(1, new Knight(1, 2,2,1));
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,2);
        printResults(false, r.isValidMove() , "Attempt to capture a friendly piece");

        z = new Board(1);
        z.updateGamePlay(0, new Pawn(1, 3,1,0));
        z.updateGamePlay(1, new Knight(2, 3,2,1));
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,2);
        printResults(false, r.isValidMove() , "Attempt to capture straight on");

        z = new Board(1);
        z.updateGamePlay(0, new Pawn(1, 3,6,0));
        z.updateGamePlay(1, new Pawn(2, 4,1,1));
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,7);
        printResults(true, r.isValidMove() , "Attempt to promote queen - player 1");
        r = z.getByID(1).isValidMove(z.buildBoard(), 4,0);
        printResults(true, r.isValidMove() , "Attempt to promote queen - player 2");

        z = new Board(1);
        z.updateGamePlay(0, new Pawn(1, 3,6,0));
        z.updateGamePlay(1, new Pawn(2, 4,1,1));
        z.updateGamePlay(2, new Knight(1, 5,0,2));
        z.updateGamePlay(3, new Knight(2, 2,7,3));
        r =( z.getByID(0).isValidMove(z.buildBoard(), 2,7));
        printResults(true, r.isValidMove() , "Attempt to promote queen on attack move - player 1");
        r =( z.getByID(1).isValidMove(z.buildBoard(), 5,0));
        printResults(true, r.isValidMove() , "Attempt to promote queen on attack move - player 2");

        z = new Board(1);
        z.updateGamePlay(0, new Pawn(1, 3,6,0));
        r =  z.getByID(0).isValidMove(z.buildBoard(), 3,6);
        printResults(false, r.isValidMove() , "Attempt to move to same space");

        System.out.println("\nROOK TESTS");

        z = new Board(1);
        z.updateGamePlay(0, new Rook(1, 4,4,0));
        r = z.getByID(0).isValidMove(z.buildBoard(), 0,4);
        printResults(true, r.isValidMove() , "Attempt to move a rook in straight line");
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,4);
        printResults(true, r.isValidMove() , "Attempt to move a rook in straight line");
        r = z.getByID(0).isValidMove(z.buildBoard(), 4,0);
        printResults(true, r.isValidMove() , "Attempt to move a rook in straight line");
        r = z.getByID(0).isValidMove(z.buildBoard(), 4, 7);
        printResults(true, r.isValidMove() , "Attempt to move a rook in straight line");

        z = new Board(1);
        z.updateGamePlay(0, new Rook(1, 4,4,0));
        r = z.getByID(0).isValidMove(z.buildBoard(), 4,4);
        printResults(false, r.isValidMove() , "Attempt to move a rook to same space");

        z = new Board(1);
        z.updateGamePlay(0, new Rook(1, 4,4,0));
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,3);
        printResults(false, r.isValidMove() , "Attempt to move a rook diagonal");
        r = z.getByID(0).isValidMove(z.buildBoard(), 5,5);
        printResults(false, r.isValidMove() , "Attempt to move a rook diagonal");
        r = z.getByID(0).isValidMove(z.buildBoard(), 1,7);
        printResults(false, r.isValidMove() , "Attempt to move a rook diagonal");
        r = z.getByID(0).isValidMove(z.buildBoard(), 2, 3);
        printResults(false, r.isValidMove() , "Attempt to move a rook diagonal");

        z = new Board(1);
        z.updateGamePlay(0, new Rook(1, 4,4,0));
        r =z.getByID(0).isValidMove(z.buildBoard(), -2,4);
        printResults(false, r.isValidMove() , "Attempt to move a rook off board");
        r =z.getByID(0).isValidMove(z.buildBoard(), 8,4);
        printResults(false, r.isValidMove() , "Attempt to move a rook off board");
        r =z.getByID(0).isValidMove(z.buildBoard(), 4,-1);
        printResults(false, r.isValidMove() , "Attempt to move a rook off board");
        r =z.getByID(0).isValidMove(z.buildBoard(), 4, 8);
        printResults(false, r.isValidMove() , "Attempt to move a rook off board");

        z = new Board(1);
        z.updateGamePlay(0, new Rook(1, 2,6,0));
        z.updateGamePlay(1, new Knight(2, 2,7,1));
        z.updateGamePlay(2, new Knight(2, 2,0,2));
        z.updateGamePlay(3, new Knight(2, 7,6,3));
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,7);
        printResults(true, r.isValidMove() , "Attempt to move and attack straight line");
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,6);
        printResults(true, r.isValidMove() , "Attempt to move and attack straight line");
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,0);
        printResults(true, r.isValidMove() , "Attempt to move and attack straight line");

        z = new Board(1);
        z.updateGamePlay(0, new Rook(1, 2,6,0));
        z.updateGamePlay(1, new Knight(1, 2,7,1));
        z.updateGamePlay(2, new Knight(1, 2,0,2));
        z.updateGamePlay(3, new Knight(1, 7,6,3));
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,7);
        printResults(false, r.isValidMove() , "Attempt to move an attack on own team");
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,6);
        printResults(false, r.isValidMove() , "Attempt to move an attack on own team");
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,0);
        printResults(false, r.isValidMove() , "Attempt to move an attack on own team");

        z = new Board(1);
        z.updateGamePlay(0, new Rook(1, 2,6,0));
        z.updateGamePlay(1, new Knight(2, 0,6,1));
        z.updateGamePlay(2, new Knight(2, 2,0,2));
        z.updateGamePlay(3, new Knight(2, 7,6,3));
        z.updateGamePlay(4, new Bishop(1, 1, 6,4));
        z.updateGamePlay(5, new Bishop(1, 2, 1,5));
        z.updateGamePlay(6, new Bishop(1, 3, 6,6));
        z.getByID(0).isValidMove(z.buildBoard(), 0,6);
        printResults(false, r.isValidMove() , "Attempt to blocked moves by own team piece");
        z.getByID(0).isValidMove(z.buildBoard(), 7,6);
        printResults(false, r.isValidMove() , "Attempt to blocked moves by own team piece");
        z.getByID(0).isValidMove(z.buildBoard(), 2,0);
        printResults(false, r.isValidMove() , "Attempt to blocked moves by own team piece");

        z = new Board(1);
        z.updateGamePlay(0, new Rook(1, 2,6,0));
        z.updateGamePlay(1, new Knight(2, 0,6,1));
        z.updateGamePlay(2, new Knight(2, 2,0,2));
        z.updateGamePlay(3, new Knight(2, 7,6,3));
        z.updateGamePlay(4, new Bishop(2, 1, 6,4));
        z.updateGamePlay(5, new Bishop(2, 2, 1,5));
        z.updateGamePlay(6, new Bishop(2, 3, 6,6));
        z.getByID(0).isValidMove(z.buildBoard(), 0,6);
        printResults(false, r.isValidMove() , "Attempt to blocked moves by other team piece");
        z.getByID(0).isValidMove(z.buildBoard(), 7,6);
        printResults(false, r.isValidMove() , "Attempt to blocked moves by other team piece");
        z.getByID(0).isValidMove(z.buildBoard(), 2,0);
        printResults(false, r.isValidMove() , "Attempt to blocked moves by other team piece");

        System.out.println("\nKNIGHT TESTS");

        z = new Board(1);
        z.updateGamePlay(0, new Knight(1, 1,4,0));
        r = z.getByID(0).isValidMove(z.buildBoard(), 0,2);
        printResults(true, r.isValidMove() , "Attempt to make valid Knight move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,2);
        printResults(true, r.isValidMove() , "Attempt to make valid Knight move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,3);
        printResults(true, r.isValidMove() , "Attempt to make valid Knight move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,5);
        printResults(true, r.isValidMove() , "Attempt to make valid Knight move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,6);
        printResults(true, r.isValidMove() , "Attempt to make valid Knight move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 0,6);
        printResults(true, r.isValidMove() , "Attempt to make valid Knight move");

        z = new Board(1);
        z.updateGamePlay(0, new Knight(1, 1,4,0));
        r = z.getByID(0).isValidMove(z.buildBoard(), 1,4);
        printResults(false, r.isValidMove() , "Attempt to make invalid Knight move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 0,4);
        printResults(false, r.isValidMove() , "Attempt to make invalid Knight move");
        r = z.getByID(0).isValidMove(z.buildBoard(), -1,3);
        printResults(false, r.isValidMove() , "Attempt to make invalid Knight move");
        r = z.getByID(0).isValidMove(z.buildBoard(), -1,5);
        printResults(false, r.isValidMove() , "Attempt to make invalid Knight move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 4,4);
        printResults(false, r.isValidMove() , "Attempt to make invalid Knight move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 4,7);
        printResults(false, r.isValidMove() , "Attempt to make invalid Knight move");

        z = new Board(1);
        z.updateGamePlay(0, new Knight(1, 1,4,0));
        z.updateGamePlay(1, new Pawn(2, 2,2,1));
        z.updateGamePlay(2, new Pawn(2, 3,3,2));
        z.updateGamePlay(3, new Pawn(2, 2,3,3)); //should be invalid
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,2);
        printResults(true, r.isValidMove() , "Attempt to make valid Knight attack move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,3);
        printResults(true, r.isValidMove() , "Attempt to make valid Knight attack move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,3);
        printResults(false, r.isValidMove() , "Attempt to make invalid Knight attack move");

        z = new Board(1);
        z.updateGamePlay(0, new Knight(1, 1,4,0));
        z.updateGamePlay(1, new Pawn(1, 2,2,1));
        z.updateGamePlay(2, new Pawn(1, 3,3,2));
        z.updateGamePlay(3, new Pawn(1, 2,3,3)); //should be invalid
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,2);
        printResults(false, r.isValidMove() , "Attempt to make attack move on own piece");
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,3);
        printResults(false, r.isValidMove() , "Attempt to make attack move on own piece");
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,3);
        printResults(false, r.isValidMove() , "Attempt to make attack move on own piece");

        System.out.println("\nBISHOP TESTS");

        z = new Board(1);
        z.updateGamePlay(0, new Bishop(1, 4,4,0));
        r = z.getByID(0).isValidMove(z.buildBoard(), 1,7);
        printResults(true, r.isValidMove() , "Attempt to make a valid Bishop move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 0,0);
        printResults(true, r.isValidMove() , "Attempt to make a valid Bishop move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,1);
        printResults(true, r.isValidMove() , "Attempt to make a valid Bishop move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 5, 5);
        printResults(true, r.isValidMove() , "Attempt to make a valid Bishop move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 0,4);
        printResults(false, r.isValidMove() , "Attempt to make a invalid Bishop move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,4);
        printResults(false, r.isValidMove() , "Attempt to make a invalid Bishop move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 4,0);
        printResults(false, r.isValidMove() , "Attempt to make a invalid Bishop move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 4, 7);
        printResults(false, r.isValidMove() , "Attempt to make a invalid Bishop move");

        z = new Board(1);
        z.updateGamePlay(0, new Bishop(1, 4,4,0));
        r = z.getByID(0).isValidMove(z.buildBoard(), 4,4);
        printResults(false, r.isValidMove() , "Attempt to make an invalid Bishop move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 5,7);
        printResults(false, r.isValidMove() , "Attempt to make an invalid Bishop move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 1,3);
        printResults(false, r.isValidMove() , "Attempt to make an invalid Bishop move");
        r = z.getByID(0).isValidMove(z.buildBoard(), -1,8);
        printResults(false, r.isValidMove() , "Attempt to make an invalid Bishop move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 8,8);
        printResults(false, r.isValidMove() , "Attempt to make an invalid Bishop move");

        z = new Board(1);
        z.updateGamePlay(0, new Bishop(1, 4,4,0));
        z.updateGamePlay(1, new Knight(2, 3,3,1));
        z.updateGamePlay(2, new Knight(2, 7,1,2));
        z.updateGamePlay(3, new Knight(2, 7,7,3));
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,3);
        printResults(true, r.isValidMove() , "Attempt to make attack Bishop move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,1);
        printResults(true, r.isValidMove() , "Attempt to make attack Bishop move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,7);
        printResults(true, r.isValidMove() , "Attempt to make attack Bishop move");

        z = new Board(1);
        z.updateGamePlay(0, new Bishop(1, 4,4,0));
        z.updateGamePlay(1, new Knight(1, 3,3,1));
        z.updateGamePlay(2, new Knight(1, 7,1,2));
        z.updateGamePlay(3, new Knight(1, 7,7,3));
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,3);
        printResults(false, r.isValidMove() , "Attempt to make attack Bishop move on same team");
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,1);
        printResults(false, r.isValidMove() , "Attempt to make attack Bishop move on same team");
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,7);
        printResults(false, r.isValidMove() , "Attempt to make attack Bishop move on same team");

        z = new Board(1);
        z.updateGamePlay(0, new Bishop(1, 4,4,0));
        z.updateGamePlay(1, new Knight(1, 5,5,1));
        z.updateGamePlay(2, new Knight(2, 7,7,2));
        z.updateGamePlay(3, new Knight(1, 6,2,3));
        z.updateGamePlay(4, new Knight(2, 7,1,4));
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,7);
        printResults(false, r.isValidMove() , "Attempt to make attack Bishop with a piece on own team blocking");
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,1);
        printResults(false, r.isValidMove() , "Attempt to make attack Bishop with a piece on own team blocking");

        z = new Board(1);
        z.updateGamePlay(0, new Bishop(1, 4,4,0));
        z.updateGamePlay(1, new Knight(2, 5,5,1));
        z.updateGamePlay(2, new Knight(2, 7,7,2));
        z.updateGamePlay(3, new Knight(2, 6,2,3));
        z.updateGamePlay(4, new Knight(2, 7,1,4));
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,7);
        printResults(false, r.isValidMove() , "Attempt to make attack Bishop with a piece on other team blocking");
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,1);
        printResults(false, r.isValidMove() , "Attempt to make attack Bishop with a piece on other team blocking");

        System.out.println("\nQUEEN TESTS");

        z = new Board(1);
        z.updateGamePlay(0, new Queen(1, 4,4,0));
        r = z.getByID(0).isValidMove(z.buildBoard(), 1,7);
        printResults(true, r.isValidMove() , "Attempt to make a valid diagonal queen move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 0,0);
        printResults(true, r.isValidMove() , "Attempt to make a valid diagonal queen move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,1);
        printResults(true, r.isValidMove() , "Attempt to make a valid diagonal queen move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 5, 5);
        printResults(true, r.isValidMove() , "Attempt to make a valid diagonal queen move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 0,4);

        z = new Board(1);
        z.updateGamePlay(0, new Queen(1, 4,4,0));
        r = z.getByID(0).isValidMove(z.buildBoard(), 4,4);
        printResults(false, r.isValidMove() , "Attempt to make an invalid queen move to same square");
        r = z.getByID(0).isValidMove(z.buildBoard(), 5,7);
        printResults(false, r.isValidMove() , "Attempt to make an invalid Queen move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 1,3);
        printResults(false, r.isValidMove() , "Attempt to make an invalid Queen move");
        r = z.getByID(0).isValidMove(z.buildBoard(), -1,8);
        printResults(false, r.isValidMove() , "Attempt to make an invalid Queen move off board");
        r = z.getByID(0).isValidMove(z.buildBoard(), 8,8);
        printResults(false, r.isValidMove() , "Attempt to make an invalid Queen move off board");

        z = new Board(1);
        z.updateGamePlay(0, new Queen(1, 4,4,0));
        z.updateGamePlay(1, new Knight(2, 3,3,1));
        z.updateGamePlay(2, new Knight(2, 7,1,2));
        z.updateGamePlay(3, new Knight(2, 7,7,3));
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,3);
        printResults(true, r.isValidMove() , "Attempt to make attack Queen move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,1);
        printResults(true, r.isValidMove() , "Attempt to make attack Queen move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,7);
        printResults(true, r.isValidMove() , "Attempt to make attack Queen move");

        z = new Board(1);
        z.updateGamePlay(0, new Queen(1, 4,4,0));
        z.updateGamePlay(1, new Knight(1, 3,3,1));
        z.updateGamePlay(2, new Knight(1, 7,1,2));
        z.updateGamePlay(3, new Knight(1, 7,7,3));
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,3);
        printResults(false, r.isValidMove() , "Attempt to make attack Queen move on same team");
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,1);
        printResults(false, r.isValidMove() , "Attempt to make attack Queen move on same team");
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,7);
        printResults(false, r.isValidMove() , "Attempt to make attack Queen move on same team");

        z = new Board(1);
        z.updateGamePlay(0, new Queen(1, 4,4,0));
        z.updateGamePlay(1, new Knight(1, 5,5,1));
        z.updateGamePlay(2, new Knight(2, 7,7,2));
        z.updateGamePlay(3, new Knight(1, 6,2,3));
        z.updateGamePlay(4, new Knight(2, 7,1,4));
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,7);
        printResults(false, r.isValidMove() , "Attempt to make attack Queen with a piece on own team blocking");
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,1);
        printResults(false, r.isValidMove() , "Attempt to make attack Queen with a piece on own team blocking");

        z = new Board(1);
        z.updateGamePlay(0, new Queen(1, 4,4,0));
        z.updateGamePlay(1, new Knight(2, 5,5,1));
        z.updateGamePlay(2, new Knight(2, 7,7,2));
        z.updateGamePlay(3, new Knight(2, 6,2,3));
        z.updateGamePlay(4, new Knight(2, 7,1,4));
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,7);
        printResults(false, r.isValidMove() , "Attempt to make attack Queen with a piece on other team blocking");
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,1);
        printResults(false, r.isValidMove() , "Attempt to make attack Queen with a piece on other team blocking");



        z = new Board(1);
        z.updateGamePlay(0, new Queen(1, 4,4,0));
        r = z.getByID(0).isValidMove(z.buildBoard(), 0,4);
        printResults(true, r.isValidMove() , "Attempt to move a Queen in straight line");
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,4);
        printResults(true, r.isValidMove() , "Attempt to move a Queen in straight line");
        r = z.getByID(0).isValidMove(z.buildBoard(), 4,0);
        printResults(true, r.isValidMove() , "Attempt to move a Queen in straight line");
        r = z.getByID(0).isValidMove(z.buildBoard(), 4, 7);
        printResults(true, r.isValidMove() , "Attempt to move a Queen in straight line");


        z = new Board(1);
        z.updateGamePlay(0, new Queen(1, 4,4,0));
        r =z.getByID(0).isValidMove(z.buildBoard(), -2,4);
        printResults(false, r.isValidMove() , "Attempt to move a Queen off board");
        r =z.getByID(0).isValidMove(z.buildBoard(), 8,4);
        printResults(false, r.isValidMove() , "Attempt to move a Queen off board");
        r =z.getByID(0).isValidMove(z.buildBoard(), 4,-1);
        printResults(false, r.isValidMove() , "Attempt to move a Queen off board");
        r =z.getByID(0).isValidMove(z.buildBoard(), 4, 8);
        printResults(false, r.isValidMove() , "Attempt to move a Queen off board");

        z = new Board(1);
        z.updateGamePlay(0, new Queen(1, 2,6,0));
        z.updateGamePlay(1, new Knight(2, 2,7,1));
        z.updateGamePlay(2, new Knight(2, 2,0,2));
        z.updateGamePlay(3, new Knight(2, 7,6,3));
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,7);
        printResults(true, r.isValidMove() , "Attempt to move and attack straight line");
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,6);
        printResults(true, r.isValidMove() , "Attempt to move and attack straight line");
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,0);
        printResults(true, r.isValidMove() , "Attempt to move and attack straight line");

        z = new Board(1);
        z.updateGamePlay(0, new Queen(1, 2,6,0));
        z.updateGamePlay(1, new Knight(1, 2,7,1));
        z.updateGamePlay(2, new Knight(1, 2,0,2));
        z.updateGamePlay(3, new Knight(1, 7,6,3));
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,7);
        printResults(false, r.isValidMove() , "Attempt to move an attack on own team");
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,6);
        printResults(false, r.isValidMove() , "Attempt to move an attack on own team");
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,0);
        printResults(false, r.isValidMove() , "Attempt to move an attack on own team");

        z = new Board(1);
        z.updateGamePlay(0, new Queen(1, 2,6,0));
        z.updateGamePlay(1, new Knight(2, 0,6,1));
        z.updateGamePlay(2, new Knight(2, 2,0,2));
        z.updateGamePlay(3, new Knight(2, 7,6,3));
        z.updateGamePlay(4, new Bishop(1, 1, 6,4));
        z.updateGamePlay(5, new Bishop(1, 2, 1,5));
        z.updateGamePlay(6, new Bishop(1, 3, 6,6));
        z.getByID(0).isValidMove(z.buildBoard(), 0,6);
        printResults(false, r.isValidMove() , "Attempt to blocked moves by own team piece");
        z.getByID(0).isValidMove(z.buildBoard(), 7,6);
        printResults(false, r.isValidMove() , "Attempt to blocked moves by own team piece");
        z.getByID(0).isValidMove(z.buildBoard(), 2,0);
        printResults(false, r.isValidMove() , "Attempt to blocked moves by own team piece");

        z = new Board(1);
        z.updateGamePlay(0, new Queen(1, 2,6,0));
        z.updateGamePlay(1, new Knight(2, 0,6,1));
        z.updateGamePlay(2, new Knight(2, 2,0,2));
        z.updateGamePlay(3, new Knight(2, 7,6,3));
        z.updateGamePlay(4, new Bishop(2, 1, 6,4));
        z.updateGamePlay(5, new Bishop(2, 2, 1,5));
        z.updateGamePlay(6, new Bishop(2, 3, 6,6));
        z.getByID(0).isValidMove(z.buildBoard(), 0,6);
        printResults(false, r.isValidMove() , "Attempt to blocked moves by other team piece");
        z.getByID(0).isValidMove(z.buildBoard(), 7,6);
        printResults(false, r.isValidMove() , "Attempt to blocked moves by other team piece");
        z.getByID(0).isValidMove(z.buildBoard(), 2,0);
        printResults(false, r.isValidMove() , "Attempt to blocked moves by other team piece");



        System.out.println("\nKING TESTS");

        //castle
        z = new Board(1);
        z.updateGamePlay(0, new King(1, 4,0,0));
        z.updateGamePlay(1, new Rook(1, 0,0,1));
        z.updateGamePlay(2, new Rook(1, 7,0,2));
        z.updateGamePlay(3, new King(2, 4,7,3));
        z.updateGamePlay(4, new Rook(2, 0,7,4));
        z.updateGamePlay(5, new Rook(2, 7,7,5));
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,0);
        printResults(true, r.isValidMove() , "Attempt to castle left player 1");
        r = z.getByID(0).isValidMove(z.buildBoard(), 6,0);
        printResults(true, r.isValidMove() , "Attempt to castle right player 1");
        r = z.getByID(3).isValidMove(z.buildBoard(), 2,7);
        printResults(true, r.isValidMove() , "Attempt to castle left player 2");
        r = z.getByID(3).isValidMove(z.buildBoard(), 6,7);
        printResults(true, r.isValidMove() , "Attempt to castle right player 2");

        //castle without rooks
        z = new Board(1);
        z.updateGamePlay(0, new King(1, 4,0,0));
        z.updateGamePlay(3, new King(2, 4,7,3));
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,0);
        printResults(false, r.isValidMove() , "Attempt to castle left with missing rook player 1");
        r = z.getByID(0).isValidMove(z.buildBoard(), 6,0);
        printResults(false, r.isValidMove() , "Attempt to castle righ with missing rookt player 1");
        r = z.getByID(3).isValidMove(z.buildBoard(), 2,7);
        printResults(false, r.isValidMove() , "Attempt to castle left with missing rook player 2");
        r = z.getByID(3).isValidMove(z.buildBoard(), 6,7);
        printResults(false, r.isValidMove() , "Attempt to castle righ with missing rookt player 2");


        //castles with moved pieces
        z = new Board(1);
        z.updateGamePlay(0, new King(1, 4,0,0));
        z.updateGamePlay(1, new Rook(1, 0,0,1));
        z.getByID(1).setMoved(true);
        z.updateGamePlay(2, new Rook(1, 7,0,2));
        z.updateGamePlay(3, new King(2, 4,7,3));
        z.updateGamePlay(4, new Rook(2, 0,7,4));
        z.getByID(4).setMoved(true);
        z.updateGamePlay(5, new Rook(2, 7,7,5));
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,0);
        printResults(false, r.isValidMove() , "Attempt to castle left with moved rook player 1");
        r = z.getByID(3).isValidMove(z.buildBoard(), 2,7);
        printResults(false, r.isValidMove() , "Attempt to castle left with moved rook player 2");

        z = new Board(1);
        z.updateGamePlay(0, new King(1, 4,0,0));
        z.updateGamePlay(1, new Rook(1, 0,0,1));
        z.updateGamePlay(2, new Rook(1, 7,0,2));
        z.getByID(2).setMoved(true);
        z.updateGamePlay(3, new King(2, 4,7,3));
        z.updateGamePlay(4, new Rook(2, 0,7,4));
        z.updateGamePlay(5, new Rook(2, 7,7,5));
        z.getByID(5).setMoved(true);
        r = z.getByID(0).isValidMove(z.buildBoard(), 6,0);
        printResults(false, r.isValidMove() , "Attempt to castle right with moved rook player 1");
        r = z.getByID(3).isValidMove(z.buildBoard(), 6,7);
        printResults(false, r.isValidMove() , "Attempt to castle right with moved rook player 2");

        z.updateGamePlay(0, new King(1, 4,0,0));
        z.getByID(0).setMoved(true);
        z.updateGamePlay(1, new Rook(1, 0,0,1));
        z.updateGamePlay(2, new Rook(1, 7,0,2));
        z.updateGamePlay(3, new King(2, 4,7,3));
        z.getByID(3).setMoved(true);
        z.updateGamePlay(4, new Rook(2, 0,7,4));
        z.updateGamePlay(5, new Rook(2, 7,7,5));
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,0);
        printResults(false, r.isValidMove() , "Attempt to castle left with moved king player 1");
        r = z.getByID(0).isValidMove(z.buildBoard(), 6,0);
        printResults(false, r.isValidMove() , "Attempt to castle right with moved king player 1");
        r = z.getByID(3).isValidMove(z.buildBoard(), 2,7);
        printResults(false, r.isValidMove() , "Attempt to castle left with moved king player 2");
        r = z.getByID(3).isValidMove(z.buildBoard(), 6,7);
        printResults(false, r.isValidMove() , "Attempt to castle right with moved king player 2");


        //castle into check
        z = new Board(1);
        z.updateGamePlay(0, new King(1, 4,0,0));
        z.updateGamePlay(1, new Rook(1, 0,0,1));
        z.updateGamePlay(2, new Rook(1, 7,0,2));
        z.updateGamePlay(3, new Queen(2, 2,4,3));
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,0);
        printResults(false, r.isValidMove() , "Attempt to castle into check left player 1");
        r = z.getByID(0).isValidMove(z.buildBoard(), 6,0);
        printResults(false, r.isValidMove() , "Attempt to castle into check right player 1");

        z = new Board(1);
        z.updateGamePlay(2, new Queen(1, 2,3,2));
        z.updateGamePlay(3, new King(2, 4,7,3));
        z.updateGamePlay(4, new Rook(2, 0,7,4));
        z.updateGamePlay(5, new Rook(2, 7,7,5));
        r = z.getByID(3).isValidMove(z.buildBoard(), 2,7);
        printResults(false, r.isValidMove() , "Attempt to castle into check left player 2");
        r = z.getByID(3).isValidMove(z.buildBoard(), 6,7);
        printResults(false, r.isValidMove() , "Attempt to castle into check right player 2");

        //castle out of check
        z = new Board(1);
        z.updateGamePlay(0, new King(1, 4,0,0));
        z.updateGamePlay(1, new Rook(1, 0,0,1));
        z.updateGamePlay(2, new Rook(1, 7,0,2));
        z.updateGamePlay(3, new Queen(2, 4,1,3));
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,0);
        printResults(false, r.isValidMove() , "Attempt to castle out of check left player 1");
        r = z.getByID(0).isValidMove(z.buildBoard(), 6,0);
        printResults(false, r.isValidMove() , "Attempt to castle out of check right player 1");

        z = new Board(1);
        z.updateGamePlay(2, new Queen(1, 4,6,2));
        z.updateGamePlay(3, new King(2, 4,7,3));
        z.updateGamePlay(4, new Rook(2, 0,7,4));
        z.updateGamePlay(5, new Rook(2, 7,7,5));
        r = z.getByID(3).isValidMove(z.buildBoard(), 2,7);
        printResults(false, r.isValidMove() , "Attempt to castle out of check left player 2");
        r = z.getByID(3).isValidMove(z.buildBoard(), 6,7);
        printResults(false, r.isValidMove() , "Attempt to castle out of check right player 2");

        //king moving into check
        z = new Board(1);
        z.updateGamePlay(0, new King(1, 4,4,0));
        z.updateGamePlay(1, new Rook(2, 5,7,1));
        z.updateGamePlay(2, new Rook(2, 3,7,2));
        z.updateGamePlay(3, new Rook(2, 7,3,3));
        z.updateGamePlay(4, new Rook(2, 7,5,4));
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,3);
        printResults(false, r.isValidMove() , "Attempt to move into check");
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,4);
        printResults(false, r.isValidMove() , "Attempt to move into check");
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,5);
        printResults(false, r.isValidMove() , "Attempt to move into check");
        r = z.getByID(0).isValidMove(z.buildBoard(), 4,3);
        printResults(false, r.isValidMove() , "Attempt to move into check");
        r = z.getByID(0).isValidMove(z.buildBoard(), 4,5);
        printResults(false, r.isValidMove() , "Attempt to move into check");
        r = z.getByID(0).isValidMove(z.buildBoard(), 5,3);
        printResults(false, r.isValidMove() , "Attempt to move into check");
        r = z.getByID(0).isValidMove(z.buildBoard(), 5,4);
        printResults(false, r.isValidMove() , "Attempt to move into check");
        r = z.getByID(0).isValidMove(z.buildBoard(), 5,5);
        printResults(false, r.isValidMove() , "Attempt to move into check");


        //king making valid one space moves
        z = new Board(1);
        z.updateGamePlay(0, new King(1, 4,4,0));
        z.updateGamePlay(1, new Rook(1, 5,7,1));
        z.updateGamePlay(2, new Rook(1, 3,7,2));
        z.updateGamePlay(3, new Rook(1, 7,3,3));
        z.updateGamePlay(4, new Rook(1, 7,5,4));
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,3);
        printResults(true, r.isValidMove() , "Attempt to make a valid one space move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,4);
        printResults(true, r.isValidMove() , "Attempt to make a valid one space move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,5);
        printResults(true, r.isValidMove() , "Attempt to make a valid one space move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 4,3);
        printResults(true, r.isValidMove() , "Attempt to make a valid one space move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 4,5);
        printResults(true, r.isValidMove() , "Attempt to make a valid one space move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 5,3);
        printResults(true, r.isValidMove() , "Attempt to make a valid one space move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 5,4);
        printResults(true, r.isValidMove() , "Attempt to make a valid one space move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 5,5);
        printResults(true, r.isValidMove() , "Attempt to make a valid one space move");

        //king moving more than one space
        z = new Board(1);
        z.updateGamePlay(0, new King(1, 4,4,0));
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,3);
        printResults(false, r.isValidMove() , "Attempt to move two spaces");
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,4);
        printResults(false, r.isValidMove() , "Attempt to move two spaces");
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,5);
        printResults(false, r.isValidMove() , "Attempt to move two spaces");
        r = z.getByID(0).isValidMove(z.buildBoard(), 4,2);
        printResults(false, r.isValidMove() , "Attempt to move two spaces");
        r = z.getByID(0).isValidMove(z.buildBoard(), 4,6);
        printResults(false, r.isValidMove() , "Attempt to move two spaces");
        r = z.getByID(0).isValidMove(z.buildBoard(), 6,3);
        printResults(false, r.isValidMove() , "Attempt to move two spaces");
        r = z.getByID(0).isValidMove(z.buildBoard(), 6,4);
        printResults(false, r.isValidMove() , "Attempt to move two spaces");
        r = z.getByID(0).isValidMove(z.buildBoard(), 6,5);
        printResults(false, r.isValidMove() , "Attempt to move two spaces");


        //king attack on one space
        z = new Board(1);
        z.updateGamePlay(0, new King(1, 4,4,0));
        z.updateGamePlay(1, new Knight(2, 3,3,1));
        z.updateGamePlay(2, new Knight(2, 3,4,2));
        z.updateGamePlay(3, new Knight(2, 3,5,3));
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,3);
        printResults(true, r.isValidMove() , "Attempt to make a valid attack one space move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,4);
        printResults(true, r.isValidMove() , "Attempt to make a valid attack one space move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,5);
        printResults(true, r.isValidMove() , "Attempt to make a valid attack one space move");

        z = new Board(1);
        z.updateGamePlay(0, new King(1, 4,4,0));
        z.updateGamePlay(4, new Knight(2, 4,3,4));
        z.updateGamePlay(5, new Knight(2, 4,5,5));
        r = z.getByID(0).isValidMove(z.buildBoard(), 4,3);
        printResults(true, r.isValidMove() , "Attempt to make a valid attack one space move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 4,5);
        printResults(true, r.isValidMove() , "Attempt to make a valid attack one space move");

        z = new Board(1);
        z.updateGamePlay(0, new King(1, 4,4,0));
        z.updateGamePlay(6, new Knight(2, 5,3,6));
        z.updateGamePlay(7, new Knight(2, 5,4,7));
        z.updateGamePlay(8, new Knight(2, 5,5,8));
        r = z.getByID(0).isValidMove(z.buildBoard(), 5,3);
        printResults(true, r.isValidMove() , "Attempt to make a valid attack one space move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 5,4);
        printResults(true, r.isValidMove() , "Attempt to make a valid attack one space move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 5,5);
        printResults(true, r.isValidMove() , "Attempt to make a valid attack one space move");

        //King move blocked by same team
        z = new Board(1);
        z.updateGamePlay(0, new King(1, 4,4,0));
        z.updateGamePlay(1, new Knight(1, 3,3,1));
        z.updateGamePlay(2, new Knight(1, 3,4,2));
        z.updateGamePlay(3, new Knight(1, 3,5,3));
        z.updateGamePlay(4, new Knight(1, 4,3,4));
        z.updateGamePlay(5, new Knight(1, 4,5,5));
        z.updateGamePlay(6, new Knight(1, 5,3,6));
        z.updateGamePlay(7, new Knight(1, 5,4,7));
        z.updateGamePlay(8, new Knight(1, 5,5,8));
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,3);
        printResults(false, r.isValidMove() , "Attempt to make a valid attack one space move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,4);
        printResults(false, r.isValidMove() , "Attempt to make a valid attack one space move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 3,5);
        printResults(false, r.isValidMove() , "Attempt to make a valid attack one space move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 4,3);
        printResults(false, r.isValidMove() , "Attempt to make a valid attack one space move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 4,5);
        printResults(false, r.isValidMove() , "Attempt to make a valid attack one space move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 5,3);
        printResults(false, r.isValidMove() , "Attempt to make a valid attack one space move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 5,4);
        printResults(false, r.isValidMove() , "Attempt to make a valid attack one space move");
        r = z.getByID(0).isValidMove(z.buildBoard(), 5,5);
        printResults(false, r.isValidMove() , "Attempt to make a valid attack one space move");

        //king attack on more than one space
        z = new Board(1);
        z.updateGamePlay(0, new King(1, 4,4,0));
        z.updateGamePlay(1, new Knight(2, 2,3,1));
        z.updateGamePlay(2, new Knight(2, 2,4,2));
        z.updateGamePlay(3, new Knight(2, 2,5,3));
        z.updateGamePlay(4, new Knight(2, 4,2,4));
        z.updateGamePlay(5, new Knight(2, 4,6,5));
        z.updateGamePlay(6, new Knight(2, 6,3,6));
        z.updateGamePlay(7, new Knight(2, 6,4,7));
        z.updateGamePlay(8, new Knight(2, 6,5,8));
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,3);
        printResults(false, r.isValidMove() , "Attempt to move two spaces into check");
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,4);
        printResults(false, r.isValidMove() , "Attempt to move two spaces into check");
        r = z.getByID(0).isValidMove(z.buildBoard(), 2,5);
        printResults(false, r.isValidMove() , "Attempt to move two spaces into check");
        r = z.getByID(0).isValidMove(z.buildBoard(), 4,2);
        printResults(false, r.isValidMove() , "Attempt to move two spaces into check");
        r = z.getByID(0).isValidMove(z.buildBoard(), 4,6);
        printResults(false, r.isValidMove() , "Attempt to move two spaces into check");
        r = z.getByID(0).isValidMove(z.buildBoard(), 6,3);
        printResults(false, r.isValidMove() , "Attempt to move two spaces into check");
        r = z.getByID(0).isValidMove(z.buildBoard(), 6,4);
        printResults(false, r.isValidMove() , "Attempt to move two spaces into check");
        r = z.getByID(0).isValidMove(z.buildBoard(), 6,5);
        printResults(false, r.isValidMove() , "Attempt to move two spaces into check");


        //king move off the board
        z = new Board(1);
        z.updateGamePlay(0, new King(1, 0,0,0));
        r = z.getByID(0).isValidMove(z.buildBoard(), -1,0);
        printResults(false, r.isValidMove() , "Attempt to move off board");
        r = z.getByID(0).isValidMove(z.buildBoard(), 0,-1);
        printResults(false, r.isValidMove() , "Attempt to move off board");

        z = new Board(1);
        z.updateGamePlay(0, new King(1, 7,7,0));
        r = z.getByID(0).isValidMove(z.buildBoard(), 7,8);
        printResults(false, r.isValidMove() , "Attempt to move off board");
        r = z.getByID(0).isValidMove(z.buildBoard(), 8,7);
        printResults(false, r.isValidMove() , "Attempt to move off board");

    }
}
