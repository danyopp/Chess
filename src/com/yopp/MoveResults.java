package com.yopp;

public class MoveResults {

    private int startX;
    private int startY;
    private int endX;
    private int endY;

    private boolean validMove;
    private boolean pawnQueen;
    private boolean attackMove;

    private boolean castleMove;
    private int rookCastleStartX;
    private int rookCastleStartY;
    private int rookCastleEndX;
    private int rookCastleEndY;

    private boolean enPassant;
    private int enPassantVulnX;
    private int enPassantVulnY;

    MoveResults(){
    }

    MoveResults(int x, int y, int startX, int startY){
        this.startX = startX;
        this.startY = startY;
        this.endX = x;
        this.endY = y;

        validMove = false;
        pawnQueen = false;
        attackMove = false;
        castleMove = false;
        enPassant = false;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public boolean isValidMove() {
        return validMove;
    }

    public void setValidMove(boolean validMove) {
        this.validMove = validMove;
    }

    public boolean isPawnQueen() {
        return pawnQueen;
    }

    public void setPawnQueen(boolean pawnQueen) {
        this.pawnQueen = pawnQueen;
    }

    public boolean isAttackMove() {
        return attackMove;
    }

    public void setAttackMove(boolean attackMove) {
        this.attackMove = attackMove;
    }

    public boolean isCastleMove() {
        return castleMove;
    }

    public void setCastleMove(boolean castleMove) {
        this.castleMove = castleMove;
    }

    public int getRookCastleStartX() {
        return rookCastleStartX;
    }

    public void setRookCastleStartX(int rookCastleStartX) {
        this.rookCastleStartX = rookCastleStartX;
    }

    public int getRookCastleStartY() {
        return rookCastleStartY;
    }

    public void setRookCastleStartY(int rookCastleStartY) {
        this.rookCastleStartY = rookCastleStartY;
    }

    public int getRookCastleEndX() {
        return rookCastleEndX;
    }

    public void setRookCastleEndX(int rookCastleEndX) {
        this.rookCastleEndX = rookCastleEndX;
    }

    public int getRookCastleEndY() {
        return rookCastleEndY;
    }

    public void setRookCastleEndY(int rookCastleEndY) {
        this.rookCastleEndY = rookCastleEndY;
    }

    public boolean isEnPassant() {
        return enPassant;
    }

    public void setEnPassant(boolean enPassant) {
        this.enPassant = enPassant;
    }

    public int getEnPassantVulnX() {
        return enPassantVulnX;
    }

    public void setEnPassantVulnX(int enPassantVulnX) {
        this.enPassantVulnX = enPassantVulnX;
    }

    public int getEnPassantVulnY() {
        return enPassantVulnY;
    }

    public void setEnPassantVulnY(int enPassantVulnY) {
        this.enPassantVulnY = enPassantVulnY;
    }


}
