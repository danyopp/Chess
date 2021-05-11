package com.yopp;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Board b = new Board();
        int player = 1;

        while(true){

           b.printBoard();
            System.out.println("Player " + player + " turn:");
           //get move

            int pieceX = 0, pieceY = 0, toX = 0, toY = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter piece X: ");
            boolean hasNextInt = scanner.hasNextInt();
            if(hasNextInt){
                pieceX = scanner.nextInt();
                scanner.nextLine();
            }
            System.out.println("Enter piece Y: ");
            hasNextInt = scanner.hasNextInt();
            if(hasNextInt){
                pieceY = scanner.nextInt();
                scanner.nextLine();
            }
            System.out.println("Enter New X: ");
            hasNextInt = scanner.hasNextInt();
            if(hasNextInt){
                toX = scanner.nextInt();
                scanner.nextLine();
            }
            System.out.println("Enter New Y: ");
            hasNextInt = scanner.hasNextInt();
            if(hasNextInt){
                toY = scanner.nextInt();
                scanner.nextLine();
            }
            System.out.println(pieceX + " " + pieceY + " " + toX + " " + toY);


            boolean checkMate = b.isCheckMate(player);
            System.out.println("CheckMate: " + checkMate);
            boolean test = b.testMove(pieceX, pieceY, toX, toY, player);
            System.out.println("Test: " + test);
            if(test) {
                System.out.println("Debug1");
                b.makeMove( pieceX, pieceY, toX, toY,player);
                System.out.println("Debug2");
                player = Math.abs(player - 3);
//                if (b.testForCheck(player)){
//                    System.out.println("Check");
//                    b.setCheck(true);
//                }
            }
            else
            {
                System.out.println("Invalid Move! Try again!");
            }
        }



    }


}
