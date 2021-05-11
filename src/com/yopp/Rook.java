package com.yopp;

public class Rook extends Piece{

    boolean moved;

    Rook(int team, int x, int y, int ID){

        super(team," Rook ",x,y, ID);
        moved = false;
    }

    void move(int x, int y){

            moved = true; //used to determine if rook is available for castle move with king
            positionX = x;
            positionY = y;
    }

    public MoveResults isValidMove(Piece[][] board, int x, int y) {
        MoveResults returnObj = new MoveResults(x,y,positionX,positionY);
        //coords are not on game board
        if(!checkIndex(x) || !checkIndex(y)){
            return returnObj;
        }
        //coords are already occupied by same team piece
        if(board[x][y]!=null && board[x][y].getTeam() == team){
            return returnObj;
        }
        //attack move. Different piece at coords
        if(board[x][y]!=null && board[x][y].getTeam() != team){
            returnObj.setAttackMove(true);
        }
        //make sure its a single line move
        if (x == positionX ^ y == positionY ) {
            //make sure nothing is blocking the movement
            if(y==positionY) {
                int xMin = Math.min(x, positionX);
                int xMax = Math.max(x, positionX);
                for (int i = (xMin+1); i < xMax; i++)
                {
                    if (board[i][y] != null)
                    { return returnObj;}
                }
            }
            if(x==positionX) {
                int yMin = Math.min(y, positionY);
                int yMax = Math.max(y, positionY);
                for (int i = (yMin+1); i < yMax; i++)
                {
                    if (board[x][i] != null)
                    { return returnObj;}
                }
            }
            returnObj.setValidMove(true);
        }
        return returnObj;
    }
}
