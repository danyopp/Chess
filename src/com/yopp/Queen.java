package com.yopp;

public class Queen extends Piece{

    Queen(int team, int x, int y, int ID){
        super(team," Queen",x,y, ID);
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
        //single line move
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
            return returnObj;
        }
        //diagonal move
        int diffx = Math.abs(x-positionX);
        int diffy = Math.abs(y-positionY);
        if(diffx == diffy && diffx > 0 ){
            //make sure nothing is blocking the movement
            int incrementX = positionX < x ? 1 : -1;
            int incrementY = positionY < y ? 1 : -1;
//            System.out.println(incrementX + " " + incrementY);
            for (int a = positionX + incrementX, b = positionY + incrementY; a != x;)
            {
                // System.out.println("[a][b]= "+ a + " " + b);
                if (board[a][b] != null)
                { return returnObj;}
                a += incrementX;
                b += incrementY;
            }
            returnObj.setValidMove(true);
        }
        return returnObj;
    }
}
