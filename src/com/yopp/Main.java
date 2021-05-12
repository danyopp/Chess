package com.yopp;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Board b = new Board();
        int player = 1;

        while(true){

            //PRINT BOARD
            b.printBoard();
            System.out.println("Player " + player + " turn:");

            //GET MOVE FROM PLAYER
            int pieceX = 0, pieceY = 0, toX = 0, toY = 0;
            pieceX = promptInput("TO QUIT GAME, ENTER: '99'\nEnter X coords of piece you would like to move: ");
            if(pieceX == 99){break;}
            pieceY = promptInput("Enter Y coords of piece you would like to move: ");
            toX = promptInput("Enter X coords of square you would like to move to: ");
            toY = promptInput("Enter Y coords of square you would like to move to: ");
            System.out.println(pieceX + " " + pieceY + " " + toX + " " + toY);

            //TEST IF MOVE IS VALID
            Board.printDetails = true;
            System.out.println("Testing Move Validity");
            boolean test = b.testMove(pieceX, pieceY, toX, toY, player);

            //IF VALID MOVE, ATTEMPT TO MAKE MOVE
            if(test) {
                System.out.println("Making The Move");
                Board.printDetails = false;
                b.makeMove( pieceX, pieceY, toX, toY,player);
                Board.printDetails = true;

                //SWAP TO OTHER PLAYER
                player = Math.abs(player - 3);
                Board.printDetails = false;

                //DETERMINE IF PLAYER IS IN CHECK
                if (b.testForCheck(player)){
                    System.out.println("Player " + player + " is in Check");
                    b.setCheck(true);
                }
                else
                {b.setCheck(false);}

                //DETERMINE IF PLAYER IS IN CHECKMATE
                if(b.isCheckMate(player)){
                    System.out.println("CheckMate: Player " + player + " is in CheckMate \nGame Over! Thanks for Playing!");
                    break;
                }
            }
            //IF INVALID MOVE, REPROMPT PLAYER FOR A VALID MOVE
            else
            {
                System.out.println("Invalid Move! Try again!");
            }
        }



        }

        //FUNCTION THAT PRINTS A PROMPT TO USER FROM THE STRING PARAMETER IT RECEIVED
        //IT THEN RETURNS THE VALUE IF A VALID INT OR -1 IF INVALID INT
        public static int promptInput(String s) {
            Scanner scanner = new Scanner(System.in);
            boolean hasNextInt = scanner.hasNextInt();
            if(hasNextInt){
                int input = scanner.nextInt();
                scanner.nextLine();
                return input;
            }
            return -1;
    }
    }



