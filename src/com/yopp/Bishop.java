package com.yopp;

public class Bishop extends Piece{
    Bishop(int team, int x, int y, int ID){
        super(team,"Bishop",x,y, ID);
    }

    public MoveResults isValidMove(Piece[][] board, int x, int y) {

        MoveResults returnObj = new MoveResults(x,y,positionX,positionY);

        if(!checkIndex(x) || !checkIndex(y)){
            return returnObj;
        }

        if(board[x][y]!=null && board[x][y].getTeam() == team){
            return returnObj;
        }

        //attack move. Different piece at coords
        if(board[x][y]!=null && board[x][y].getTeam() != team){
            returnObj.setAttackMove(true);
        }

        //make sure its a diagonal line move
        int diffx = Math.abs(x-positionX);
        int diffy = Math.abs(y-positionY);
        if(diffx == diffy && diffx > 0 ){
            //make sure nothing is blocking the movement
            int incrementX = positionX < x ? 1 : -1;
            int incrementY = positionY < y ? 1 : -1;
            for (int a = positionX + incrementX, b = positionY + incrementY; a != x;)
                {
                    if (board[a][b] != null)
                    {
                        return returnObj;}
                    a += incrementX;
                    b += incrementY;
                }
            returnObj.setValidMove(true);
        }
        return returnObj;
    }

}
