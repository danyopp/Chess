package com.yopp;

//PIECE CLASS IS THE SUPER CLASS OF ALL THE DIFFERENT TYPES OF PIECES
public class Piece {
    int team;
    String name;
    int positionX;
    int positionY;
    int pieceID;
    boolean moved;

    public Piece(){

    }

    public Piece(int t, String name, int x, int y, int ID)
    {
        team = t;
        this.name = name;
        positionX = x;
        positionY = y;
        pieceID = ID;
        moved = false;
    }

    void move(int x, int y){
        this.moved = true;
        positionX = x;
        positionY = y;
    }

    public boolean checkIndex(int index){
        if (index >=0 && index<=7){return true;}
        return false;
    }

    //function that is overloaded in children to determine if move is valid
    public MoveResults isValidMove(Piece[][] board, int x, int y){
        return new MoveResults();
    }

    //Getters and Setters
    public String getName() {
        return name;
    }
    public int getTeam() {
        return team;
    }
    public int getPositionX() {
        return positionX;
    }
    public int getPositionY() {
        return positionY;
    }
    public int getPieceID(){
        return pieceID;
    }
    public boolean isMoved() {
        return moved;
    }
    public void setMoved(boolean moved) {
        this.moved = moved;
    }



}
