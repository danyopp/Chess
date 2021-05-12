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
            System.out.println("TO QUIT GAME, ENTER: '99'\nEnter piece X: ");
            boolean hasNextInt = scanner.hasNextInt();
            if(hasNextInt){
                pieceX = scanner.nextInt();
                scanner.nextLine();
            }
            if(pieceX == 99){break;}
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

            Board.printDetails = true;
            System.out.println("Testing Move Validity");
            boolean test = b.testMove(pieceX, pieceY, toX, toY, player);
            if(test) {
                System.out.println("Making The Move");
                Board.printDetails = false;
                b.makeMove( pieceX, pieceY, toX, toY,player);
                Board.printDetails = true;
                player = Math.abs(player - 3);
                Board.printDetails = false;
                if (b.testForCheck(player)){
                    System.out.println("Player " + player + " is in Check");
                    b.setCheck(true);
                }
                else
                {b.setCheck(false);}
                if(b.isCheckMate(player)){
                    System.out.println("CheckMate: Player " + player + " is in CheckMate \nGame Over! Thanks for Playing!");
                    break;
                }
            }
            else
            {
                System.out.println("Invalid Move! Try again!");
            }
        }



    }


}
