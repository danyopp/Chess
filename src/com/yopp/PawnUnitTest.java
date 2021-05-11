package com.yopp;

public class PawnUnitTest {
    public static void main(String[] args) {

        //Test moving a pawn two spaces
        Board z = new Board(1);
        z.updateGamePlay(0, new Pawn(1, 3,1,0));
        System.out.println("Attempt to move a pawn two spaces - should pass");
        System.out.println( z.getByID(0).isValidMove(z.buildBoard(), 3,2));
        z.printBoard();

        //Test moving pawn backwards player1
        Board a = new Board(1);
        a.updateGamePlay(0, new Pawn(1, 3,1,0));
        a.updateGamePlay(1, new Pawn(2, 6,6,1));
        System.out.println("Attempt to move a pawn backwards");
        System.out.println( a.getByID(0).isValidMove(a.buildBoard(), 3,0));
        System.out.println( a.getByID(1).isValidMove(a.buildBoard(), 6,7));
        a.printBoard();


        //Test moving a pawn sideways
        Board b = new Board(1);
        b.updateGamePlay(0, new Pawn(1, 4,3,0));
        b.updateGamePlay(1, new Pawn(2, 7,6,1));
        System.out.println("Attempt to move a pawn sideways");
        System.out.println( b.getByID(0).isValidMove(b.buildBoard(), 3,3));
        System.out.println( b.getByID(1).isValidMove(b.buildBoard(), 5,5));
        b.printBoard();

        //Test moving a pawn off the board
        Board c = new Board(1);
        c.updateGamePlay(0, new Pawn(1, 0,1,0));
        c.updateGamePlay(1, new Pawn(2, 7,6,1));
        System.out.println("Attempt to move a pawn off board");
        System.out.println( c.getByID(0).isValidMove(c.buildBoard(), -1,1));
        System.out.println( c.getByID(1).isValidMove(c.buildBoard(), 8,6));
        c.printBoard();

        //Test moving a pawn two spaces
        Board d = new Board(1);
        d.updateGamePlay(0, new Pawn(1, 3,1,0));
        System.out.println("Attempt to move a pawn two spaces - should pass");
        System.out.println( d.getByID(0).isValidMove(d.buildBoard(), 3,3));
        d.printBoard();

        //Test moving a pawn two spaces while blocked
        Board e = new Board(1);
        e.updateGamePlay(0, new Pawn(1, 3,1,0));
        e.updateGamePlay(1, new Knight(1,3,2,1));
        e.updateGamePlay(2, new Pawn(1, 6,1,2));
        e.updateGamePlay(3, new Knight(2,6,2,3));
        System.out.println("Attempt to move a pawn over another piece");
        System.out.println( e.getByID(0).isValidMove(e.buildBoard(), 3,3));
        System.out.println( e.getByID(2).isValidMove(e.buildBoard(), 6,3));
        e.printBoard();

        //Testing moving two spaces on diagonal
        Board f = new Board(1);
        f.updateGamePlay(0, new Pawn(1, 3,1,0));
        System.out.println("Attempt to move a pawn two spaces diagonal");
        System.out.println( f.getByID(0).isValidMove(f.buildBoard(), 2,3));
        f.printBoard();

        //Test enemy capture
        Board g = new Board(1);
        g.updateGamePlay(0, new Pawn(1, 3,1,0));
        g.updateGamePlay(1, new Knight(2, 2,2,1));
        System.out.println("Attempt to capture an enemy piece - Pass");
        System.out.println( g.getByID(0).isValidMove(g.buildBoard(), 2,2));
        g.printBoard();

        //Test capture of same team
        Board h = new Board(1);
        h.updateGamePlay(0, new Pawn(1, 3,1,0));
        h.updateGamePlay(1, new Knight(1, 2,2,1));
        System.out.println("Attempt to capture an friendly piece");
        System.out.println( h.getByID(0).isValidMove(h.buildBoard(), 2,2));
        h.printBoard();

        //Test straight forward capture
        Board j = new Board(1);
        j.updateGamePlay(0, new Pawn(1, 3,1,0));
        j.updateGamePlay(1, new Knight(2, 3,2,1));
        System.out.println("Attempt to capture straight on");
        System.out.println( j.getByID(0).isValidMove(j.buildBoard(), 3,2));
        j.printBoard();

        //Test queen
        Board i = new Board(1);
        i.updateGamePlay(0, new Pawn(1, 3,6,0));
        i.updateGamePlay(1, new Pawn(2, 4,1,1));
        System.out.println("Attempt to promote queen - should pass");
        System.out.println( i.getByID(0).isValidMove(i.buildBoard(), 3,7));
        System.out.println( i.getByID(1).isValidMove(i.buildBoard(), 4,0));
        i.printBoard();

        //Test queen with capture
        Board k = new Board(1);
        k.updateGamePlay(0, new Pawn(1, 3,6,0));
        k.updateGamePlay(1, new Pawn(2, 4,1,1));
        k.updateGamePlay(2, new Knight(1, 5,0,2));
        k.updateGamePlay(3, new Knight(2, 2,7,3));
        System.out.println("Attempt to promote queen on attack - should pass");
        System.out.println( k.getByID(0).isValidMove(k.buildBoard(), 2,7));
        System.out.println( k.getByID(1).isValidMove(k.buildBoard(), 5,0));
        k.printBoard();

        //move to same square
        k = new Board(1);
        k.updateGamePlay(0, new Pawn(1, 3,6,0));
        System.out.println("Attempt to move to same space");
        System.out.println( k.getByID(0).isValidMove(k.buildBoard(), 3,6));
    }

}
