package com.yopp;

public class Knight extends Piece {

    Knight(int team, int x, int y, int ID) {
        super(team, "Knight", x, y, ID);
    }

    public MoveResults isValidMove(Piece[][] board, int x, int y) {
        MoveResults returnObj = new MoveResults(x,y,positionX,positionY);
        if (!checkIndex(x) || !checkIndex(y)) {
            return returnObj;
        }
        if(board[x][y]!=null && board[x][y].getTeam() == team){
            return returnObj;
        }
        //attack move. Different piece at coords
        if(board[x][y]!=null && board[x][y].getTeam() != team){
            returnObj.setAttackMove(true);
        }
        int diffX = Math.abs(x - positionX);
        int diffY = Math.abs(y - positionY);
        if ((diffX == 1 && diffY == 2) || (diffX == 2 && diffY == 1)) {
            returnObj.setValidMove(true);
        }
        return returnObj;

    }
}