package com.yopp;

public final class Board {

    private Piece [] gamePlay = new Piece[33];

    int en_passant_pawnX; //position of pawn
    int en_passant_pawnY;
    int en_passant_attackX; //position of vulnerable square behind pawn
    int en_passant_attackY;
    boolean check;

    Board(int x){
        check = false;
    }

    public void updateGamePlay(int index, Piece p){
        gamePlay[index] = p;
    }

    Board(){
        for(int i =0; i < 8; i++)
            gamePlay[i] = new Pawn(1,  i, 1, i);
        for(int i = 8; i < 16; i++)
            gamePlay[i] = new Pawn(2,   (i-8), 6 , i);
        gamePlay[16] = new Rook(1, 0,0, 16);
        gamePlay[17] = new Rook(1, 7,0,17);
        gamePlay[18] = new Knight(1, 1,0,18);
        gamePlay[19] = new Knight(1, 6,0, 19);
        gamePlay[20] = new Bishop(1, 2,0, 20);
        gamePlay[21] = new Bishop(1, 5,0, 21);
        gamePlay[22] = new Queen(1, 3,0, 22);
        gamePlay[23] = new King(1, 4,0, 23);
        gamePlay[24] = new Rook(2, 0,7, 24);
        gamePlay[25] = new Rook(2, 7,7, 25);
        gamePlay[26] = new Knight(2, 1,7, 26);
        gamePlay[27] = new Knight(2, 6,7, 27);
        gamePlay[28] = new Bishop(2, 2,7, 28);
        gamePlay[29] = new Bishop(2, 5,7, 29);
        gamePlay[30] = new Queen(2, 3,7, 30);
        gamePlay[31] = new King(2,4,7, 31);
        gamePlay[32] = null; //place holder for an en Passant attack
        check = false;
    }

    public Board copyBoard(){
        Board c = new Board(32);
        for(int j = 0; j < 32; j++){
            if(gamePlay[j] instanceof Pawn){
                c.updateGamePlay(j, new Pawn( gamePlay[j].getTeam(), gamePlay[j].getPositionX(), gamePlay[j].getPositionY(), j));
            }
            if(gamePlay[j] instanceof Rook){
                c.updateGamePlay(j, new Rook( gamePlay[j].getTeam(), gamePlay[j].getPositionX(), gamePlay[j].getPositionY(), j));
            }
            if(gamePlay[j] instanceof Knight){
                c.updateGamePlay(j, new Knight( gamePlay[j].getTeam(), gamePlay[j].getPositionX(), gamePlay[j].getPositionY(), j));
            }
            if(gamePlay[j] instanceof Bishop){
                c.updateGamePlay(j, new Bishop( gamePlay[j].getTeam(), gamePlay[j].getPositionX(), gamePlay[j].getPositionY(), j));
            }
            if(gamePlay[j] instanceof Queen){
                c.updateGamePlay(j, new Queen( gamePlay[j].getTeam(), gamePlay[j].getPositionX(), gamePlay[j].getPositionY(), j));
            }
            if(gamePlay[j] instanceof King){
                c.updateGamePlay(j, new King( gamePlay[j].getTeam(), gamePlay[j].getPositionX(), gamePlay[j].getPositionY(), j));
            }
        }
        c.en_passant_attackY = this.en_passant_attackY;
        c.en_passant_attackX = this.en_passant_attackX;
        c.en_passant_pawnX = this.en_passant_pawnX;
        c.en_passant_pawnY = this.en_passant_pawnY;

        return c;
    }

    public Piece getByID(int id) {
        for (Piece i : gamePlay) {
            if(i == null) continue;
            if (i.getPieceID() == id) {
                return i;
            }
        } return null;
    }

    //Build a 2d array representing the board
    public Piece[][] buildBoard() {
        Piece[][] chessBoard = new Piece[8][8];
        for (Piece i : gamePlay) {
            if(i == null) continue;
            try {
                if (chessBoard[i.getPositionX()][i.getPositionY()] == null)
                {chessBoard[i.getPositionX()][i.getPositionY()] = i;}
                else
                {   throw new IllegalStateException("Multiple pieces at single board location");}
            } catch (IllegalStateException e) {
                System.out.println("Multiple pieces at position");
                System.out.println(chessBoard[i.getPositionX()][i.getPositionY()].getName());
                System.out.println(i.getName());
                System.out.println("Position:" + i.getPositionX() + i.getPositionY());
            }
        }
        return chessBoard;
    }


    public void printBoard()
    {
        Piece[][] chessBoard = buildBoard();
        for (int y = 7; y > -1; y--){
            System.out.print("y"+y+ " | ");
            for(int x = 0; x < 8; x++) {
                if (chessBoard[x][y] == null){
                    System.out.print("   xx   \t" );
                    continue;}
                System.out.print(chessBoard[x][y].getTeam()+ chessBoard[x][y].getName() + x + y + "\t");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("   |   x0     |    x1     |    x2     |    x3     |    x4     |    x5     |    x6     |    x7     | ");
    }

    //checks if a spot in the board is occupied by a piece
    //returns true if occupied

    //removes a piece from gameplay
    public void capturePiece(int index){
        if(! (gamePlay[index] instanceof King))
        gamePlay[index]=null;
    }

    public boolean checkIndex(int index){
        if (index >=0 && index<=7){return true;}
        return false;
    }

    private boolean isEnPassant(int x, int y){
        if (x == en_passant_attackX && y == en_passant_attackY)
        {   return true;}
        return false;
    }

    //called after pawn moves to space
    private boolean isQueenPromotion(int x, int y){
        Piece[][] gameBoard = buildBoard();
        if(gameBoard[x][y] == null){return false;}
        if (!(gameBoard[x][y] instanceof Pawn)) {return false;}
        int team = gameBoard[x][y].getTeam();
        if(team == 1 && y== 7) {return true;}
        if(team == 2 && y== 0) {return true;}
        return false;
    }

    private boolean isCastle(int x, int y, int newX, int newY){
        Piece[][] gameBoard = buildBoard();
        if( gameBoard[x][y] == null){ return false; }
        if(!(gameBoard[x][y] instanceof King)){return false;}
        King piece = (King)gameBoard[x][y];
        if(piece.isMoved()){return false;}
        if(piece.getTeam() == 1 && newY == 0){
            if(newX == 6){
                if (gameBoard[7][0] == null){return false;} //no piece
                if (!(gameBoard[7][0] instanceof Rook)){return false;} //not a rook
                if (gameBoard[7][0].getTeam() != piece.getTeam()) //rook from the other team
                if (gameBoard[7][0].isMoved()){return false;} //rook has already moved
                if (gameBoard[6][0] != null || gameBoard[5][0] != null){return false;} //pieces between king and rook
                //need to check for check
                return true;
            }
            if(newX == 2){
                if (gameBoard[0][0] == null){return false;} //no piece
                if (!(gameBoard[0][0] instanceof Rook)){return false;} //not a rook
                if (gameBoard[0][0].getTeam() != piece.getTeam()) //rook from the other team
                    if (gameBoard[0][0].isMoved()){return false;} //rook has already moved
                if (gameBoard[1][0] != null || gameBoard[2][0] != null || gameBoard[3][0] != null){return false;} //pieces between king and rook
                return true;
            }
        return false;
        }
        else if(piece.getTeam() == 2 && newY == 7){
            if(newX == 6){
                if (gameBoard[7][7] == null){return false;} //no piece
                if (!(gameBoard[7][7] instanceof Rook)){return false;} //not a rook
                if (gameBoard[7][7].getTeam() != piece.getTeam()) //rook from the other team
                    if (gameBoard[7][7].isMoved()){return false;} //rook has already moved
                if (gameBoard[6][7] != null || gameBoard[7][5] != null){return false;} //pieces between king and rook
                return true;
            }
            if(newX == 2){
                if (gameBoard[0][7] == null){return false;} //no piece
                if (!(gameBoard[0][7] instanceof Rook)){return false;} //not a rook
                if (gameBoard[0][7].getTeam() != piece.getTeam()) //rook from the other team
                    if (gameBoard[0][7].isMoved()){return false;} //rook has already moved
                if (gameBoard[1][7] != null || gameBoard[2][7] != null || gameBoard[3][7] != null){return false;} //pieces between king and rook
                return true;
            }
            return false;
        }
        return false;
    }

    private void moveCastle(int x, int y, int newX, int newY){
        Piece[][] gameBoard = buildBoard();
        King piece = (King)gameBoard[x][y];
        if(piece.getTeam() == 1 && newY == 0){
            if(newX == 6){
                gameBoard[7][0].move(5,0);
                gameBoard[4][0].move(6,0);
            }
            if(newX == 2){
                gameBoard[0][0].move(3,0);
                gameBoard[4][0].move(2,0);
            }
        }
        else if(piece.getTeam() == 2 && newY == 7){
            if(newX == 6){
                gameBoard[4][7].move(6,7);
                gameBoard[7][7].move(5,7);
            }
            if(newX == 2){
                gameBoard[4][7].move(2,7);
                gameBoard[0][7].move(3,7);
            }
        }
    }


    private boolean isAttackMove(int x, int y){
        Piece[][] gameBoard = buildBoard();
        if (gameBoard[x][y] != null)
        {   return true;}
        return false;
    }

    public boolean testMove(int x, int y, int newX, int newY, int team){

        Piece [][] gameBoard = buildBoard();
        if(!checkIndex(x) || !checkIndex(y) || !checkIndex(newX) || !checkIndex(newY)) {
            System.out.println("bad index");
            return false;}
        if(team != 1 && team != 2){
            System.out.println("bad team");return false;}
        if(gameBoard[x][y] == null){
            System.out.println("empty position");
            return false;
        }
        if(gameBoard[x][y].getTeam() != team ){
            System.out.println("piece on wrong team");
            return false;}

        MoveResults m = gameBoard[x][y].isValidMove(gameBoard, newX, newY);
        if(!m.isValidMove()) {
            System.out.println("object returned invalid move");
            return false;}

        if(m.isAttackMove()){
            System.out.println("attack move");
//          System.out.println(en_passant_attackX + " " + en_passant_attackY + " " + newX + " " + newY);
            if (newX == en_passant_attackX && newY == en_passant_attackY)
            { return true; }
            else if (gameBoard[newX][newY] == null)
            { return false;}
            else if (gameBoard[newX][newY].getTeam() == gameBoard[x][y].getTeam())
            { return false; }
        }
        //Board tempBoard = copyBoard();
       // tempBoard.makeMove(x, y, newX, newY, team);
        // if(tempBoard.testForCheck(team)){return false;}
        System.out.println("valid move");
        return true;
    }

    public void makeMove(int x, int y, int newX, int newY, int team){
        Piece [][] gameBoard = buildBoard();
        MoveResults results = gameBoard[x][y].isValidMove(gameBoard, newX, newY);
        //Remove en passant pawn

        if(isEnPassant(newX, newY)){
            System.out.println("debug3");
            int id = gameBoard[en_passant_pawnX][en_passant_pawnY].getPieceID();
            capturePiece(id);
        }
        //remove other captured piece

        else if(isAttackMove(newX, newY)){
            System.out.println("Debug4");
            int id = gameBoard[newX][newY].getPieceID();
            capturePiece(id);
        }
        //Castle or move Pieces

        if(isCastle(x, y, newX, newY)){
            System.out.println("Debug5");
            moveCastle(x, y, newX, newY);
        }
        else{
            System.out.println("Debug6");
            gameBoard[x][y].move(newX, newY);
        }
        //Promote a queen
        if(isQueenPromotion(newX, newY)){
            System.out.println("Debug7");
            gameBoard = buildBoard();
            int id = gameBoard[newX][newY].getPieceID();
            int queenTeam = gameBoard[newX][newY].getTeam();
            gamePlay[id] = new Queen(queenTeam, newX, newY, id);
        }
        //Set up enPassant values for next move
        if(results.isEnPassant()) {
            System.out.println("Debug8");
            en_passant_pawnX = newX;
            en_passant_pawnY = newY;
            en_passant_attackX = results.getEnPassantVulnX();
            en_passant_attackY = results.getEnPassantVulnY();

        }else{
            System.out.println("Debug9");
            en_passant_pawnX = -1;
            en_passant_pawnY = -1;
            en_passant_attackX = -1;
            en_passant_attackY = -1;
        }
    }

    public boolean testForCheck(int player){
        Piece [][] board = buildBoard();
        Piece King;
        if(player == 1){King = gamePlay[23];}
        else{King = gamePlay[31];}

        for( Piece i : gamePlay){
            if(i == null) {continue;}
            if (i.getPositionX() == King.getPositionX() && i.getPositionY() ==King.getPositionY()){continue;}
            MoveResults results = i.isValidMove(board, King.getPositionX(), King.getPositionY());
            if (results.isValidMove() && results.isAttackMove() && i.getTeam() != player){
                return true;
            }
        }
        return false;
    }

    public boolean isCheckMate( int playerInCheck) {

        King k = playerInCheck==1 ? (King)gamePlay[23] : (King)gamePlay[31];
        Piece [][] board = buildBoard();
        int x = k.getPositionX();
        int y = k.getPositionY();

        for (int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                //getting each piece
                if(board[i][j] == null){continue;}
                if (board[i][j].getTeam() != playerInCheck) {continue;}
                for(int a = 0; a < 8; a++){
                    for(int b = 0; b < 8; b++){
                        System.out.println(i + " " + j + "->" + a + " " + b);
                        Board c = copyBoard();
                        if(c.testMove(i,j,a,b,playerInCheck)){
                            c.makeMove(i,j,a,b, playerInCheck);
                            if(!c.testForCheck(playerInCheck)){
                                return false;
                                }
                            }
                    }
                }
            }
        }
        return true;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
