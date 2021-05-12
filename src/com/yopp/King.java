package com.yopp;

public class King extends Piece{


    King(int team, int x, int y, int ID){

        super(team," King ",x,y, ID);
        moved = false;
    }

    void move(int x, int y){
        this.moved = true; //used to determine if rook is available for castle move with king
        positionX = x;
        positionY = y;
    }

    public MoveResults isValidMove(Piece[][] board, int x, int y){
        MoveResults returnObj = new MoveResults(x,y,positionX,positionY);
        //bad parameters out of range
        if(!checkIndex(x) || !checkIndex(y)){
            return returnObj;
        }
        //friendly piece already on target space
        if(board[x][y]!=null && board[x][y].getTeam() == team){
            return returnObj;
        }
        //enemy piece on target space - attack move
        if(board[x][y]!=null && board[x][y].getTeam() != team){
            returnObj.setAttackMove(true);
        }

        //make sure move is within one space of current position
        int diffX = Math.abs(x - positionX);
        int diffY = Math.abs(y - positionY);
        if(diffY <= 1 && diffX <= 1){
            returnObj.setValidMove(true);
        }

        //make sure that king is not moving into check
        if(kingMovingIntoCheck(board, x,y,positionX,positionY))
        {returnObj.setValidMove(false);}


        //Specialty move - Castle
        int rookLocationX = -1;
        int rookLocationY = -1;
        int newRookX = -1;
        int newRookY = -1;

        //team two castle options
        if(positionX == 4 && positionY == 7 && !moved && team == 2) {
            //king side castle
            if (x == 6 && y == 7 && board[7][7] != null && board[7][7].getTeam() == team && board[7][7] instanceof Rook && !board[7][7].moved) {
                rookLocationX = 7;
                rookLocationY = 7;
                newRookX = 5;
                newRookY = 7;
            }
            //queen side castle
            if (x == 2 && y == 7 && board[0][7] != null && board[0][7].getTeam() == team && board[0][7] instanceof Rook && !board[0][7].moved) {
                rookLocationX = 0;
                rookLocationY = 7;
                newRookX = 3;
                newRookY = 7;
            }
        }
//        team one castle options
        if(positionX == 4 && positionY == 0 && !moved && team == 1){
                //king side castle
                if(x == 6 && y == 0 && board[7][0] != null && board[7][0].getTeam() == team && board[7][0] instanceof Rook && !board[7][0].moved){
                    rookLocationX =7; rookLocationY = 0; newRookX = 5; newRookY = 0;
                }
                //queen side castle
                if(x == 2 && y == 0 && board[0][0] != null && board[0][0].getTeam() == team && board[0][0] instanceof Rook && !board[0][0].moved){
                    rookLocationX =0; rookLocationY = 0; newRookX = 3; newRookY = 0;
                }
        }

        if(rookLocationX != -1) //castle location criteria met. Test move is completely valid
        {
            //test if pieces in between rookLocationX and position X
            int xMin = Math.min(rookLocationX, positionX);
            int xMax = Math.max(rookLocationX, positionX);
            for (int i = (xMin+1); i < xMax; i++)
            {
                if (board[i][y] != null)
                { return returnObj;}
            }

            //test if in check - cannot castle out of check
            if(kingInCheck(board, positionX, positionY)) {return returnObj;}

            //test if moving into check
            if (kingCastleIntoCheck(board,x,y,positionX,positionY, newRookX, newRookY, rookLocationX, rookLocationY)){
                return returnObj;
            }
            returnObj.setValidMove(true);
            return returnObj;
        }


        return returnObj;
    }

    public boolean kingInCheck(Piece[][] board, int X, int Y){
        boolean returnVal = false;
        for(int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if(board[i][j] == null){continue;}
                if(i==X && j==Y){continue;}
                if(board[i][j].getTeam() == board[X][Y].getTeam()){continue;}
                MoveResults returnObj = board[i][j].isValidMove(board, X, Y);
                if(returnObj.isValidMove() && returnObj.isAttackMove()){
                    returnVal = true;
                    break;
                }
            }
        }
        return returnVal;
    }

    public boolean kingMovingIntoCheck(Piece[][] board, int NewX, int NewY, int KingX, int KingY){

        Piece king = board[KingX][KingY];
        Piece newSpace = board[NewX][NewY];
        board[NewX][NewY] = king;
        board[KingX][KingY] = null;

        boolean returnVal = kingInCheck(board, NewX, NewY);

        board[NewX][NewY] = newSpace;
        board[KingX][KingY] = king;

        return returnVal;
    }

    public boolean kingCastleIntoCheck(Piece [][] board, int newKingX, int newKingY, int kingX, int kingY, int newRookX, int newRookY, int rookX, int rookY){
        Piece king = board[kingX][kingY];
        Piece rook = board[rookX][rookY];
        Piece kingNew = board[newKingX][newKingY];
        Piece rookNew = board[newRookX][newRookY];

        board[kingX][kingY] = null;
        board[rookX][rookY] = null;
        board[newKingX][newKingY] = king;
        board[newRookX][newRookY] = rook;

        boolean returnVal = kingInCheck(board, newKingX, newKingY);

        board[kingX][kingY] = king;
        board[rookX][rookY] = rook;
        board[newKingX][newKingY] = kingNew;
        board[newRookX][newRookY] = rookNew;

        return returnVal;
    }

}
