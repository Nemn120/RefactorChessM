package Business.pieces.move.impl;

import Business.Service.Moves.Impl.ColorOfPiece;

public class GeneralMove {

    /**
     * The game piece's row.
     */
    protected int pieceRow;
    /**
     * The game piece's column.
     */
    protected int pieceColumn;

    private ColorOfPiece colorOfPiece;

    public int getPieceRow() {
        return pieceRow;
    }

    public void setPieceRow(int pieceRow) {
        this.pieceRow = pieceRow;
    }

    public int getPieceColumn() {
        return pieceColumn;
    }

    public void setPieceColumn(int pieceColumn) {
        this.pieceColumn = pieceColumn;
    }

    public GeneralMove(int pieceColumn, int pieceRow) {
        this.pieceRow=pieceRow;
        this.pieceColumn=pieceColumn;
    }

    public boolean isPieceOnScreen() {
        return isOnScreen(pieceRow, pieceColumn);
    }

    public boolean isOnScreen(int row, int col) {
        if (row >= 0 && row <= 7 && col >= 0 && col <= 7) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isOnScreen() {
        if (this.pieceRow >= 0 && this.pieceRow <= 7 && this.pieceColumn >= 0 && this.pieceColumn <= 7) {
            return true;
        } else {
            return false;
        }
    }

    public ColorOfPiece getColorOfPiece() {
        return colorOfPiece;
    }

    public void setColorOfPiece(ColorOfPiece colorOfPiece) {
        this.colorOfPiece = colorOfPiece;
    }

    



}
