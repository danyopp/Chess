package com.yopp;

public class Pawn extends Piece{

    //can return Valid, Invalid, Queen, AttackValid, AttackQueen, Enpassant obj
    Pawn(int team, int x, int y, int ID){
        super(team," Pawn ",x,y, ID);
    }

    public MoveResults isValidMove(Piece[][] board, int x, int y) {
        //set pawn direction
        MoveResults returnObj = new MoveResults(x,y,positionX,positionY);
        int direction = team == 1 ? 1 : -1;
        //System.out.println("Direction: " + direction);
        //check for valid index params
        if (!checkIndex(y) || !checkIndex(x)) {
            //System.out.println("invalid indexes");
            return returnObj;
        }
        //check if queen promotion
        if ((getTeam() == 1 && y == 7)||(getTeam() == 2 && y == 0)){
            //System.out.println("Queen Promotion -Pawn" + getTeam() + " " +x+ " "+ y);
            returnObj.setPawnQueen(true);
        }

        //check if a single space move in correct direction
        if (x == positionX && Math.abs(y - positionY) == 1) {
            if (y == positionY + direction && board[x][y] == null) {
                returnObj.setValidMove(true);
            }
            //System.out.println("Invalid single space move, wrong direction or blocked");
            return returnObj;
        }
        //check if a double space move off start row
        else if (x == positionX && Math.abs(y - positionY) == 2) {
            if (team == 1 && positionY == 1 && y == 3 && board[x][2] == null && board[x][3] == null) {
                //System.out.println("EnPassant move created for next turn");
                returnObj.setValidMove(true);
                returnObj.setEnPassant(true);
                returnObj.setEnPassantVulnX(x);
                returnObj.setEnPassantVulnY(2);
            } else if (team == 2 && positionY == 6 && y == 4 && board[x][5] == null && board[x][4] == null) {
                returnObj.setValidMove(true);
                returnObj.setEnPassant(true);
                returnObj.setEnPassantVulnX(x);
                returnObj.setEnPassantVulnY(5);
                //System.out.println("EnPassant move created for next turn");
            }
        }

        //can capture one space diag as long as piece is present
        else if( Math.abs(positionX-x) == 1 && Math.abs(positionY-y) == 1) {
            //verify there is an enemy piece to take
            // space empty or has same team piece, cannot attack move
            if ( y == positionY + direction ) { //pawn moving in correct direction
                    //System.out.println("Attack move");
                    returnObj.setValidMove(true);
                    returnObj.setAttackMove(true);
                }
            else{
            //System.out.println("Invalid attack move - wrong direction");
                }
        }
        return returnObj;
    }


}
