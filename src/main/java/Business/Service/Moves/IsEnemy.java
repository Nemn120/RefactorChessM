package Business.Service.Moves;

import Business.pieces.ChessGamePiece;
import Business.pieces.move.impl.GeneralMove;
import GUI.board.ChessGameBoard;

public class IsEnemy {
    
    private int pieceColor;
    private GeneralMove generalMove;

    public IsEnemy(int pieceColor) {
        this.pieceColor = pieceColor;
    }

    /**
     * Determines if the row and column contains an enemy piece. This is defined
     * in GamePiece and not ChessGameBoard because different pieces have
     * different enemies depending on their colors.
     *
     * @param row   row of the GamePiece
     * @param col   column of the GamePiece
     * @param board the board to check
     * @return true if it is an enemy piece, false if not
     */
    public boolean invoke(ChessGameBoard board, int row, int col) {
        if (row > 7 || col > 7 || row < 0 || col < 0) {
            return false;
        }
        ChessGamePiece enemyPiece =
                board.getCell(row, col).getPieceOnSquare() == null
                        ? null
                        : board.getCell(row, col).getPieceOnSquare();
        if (enemyPiece == null
                || pieceColor == ChessGamePiece.UNASSIGNED
                || enemyPiece.getColorOfPiece().getColor() == ChessGamePiece.UNASSIGNED) {
            return false;
        }
        if (pieceColor == ChessGamePiece.WHITE) {
            if (enemyPiece.getColorOfPiece().getColor() == ChessGamePiece.BLACK) {
                return true;
            } else {
                return false;
            }
        } else {
            if (enemyPiece.getColorOfPiece().getColor() == ChessGamePiece.WHITE) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    public boolean isEnemy(ChessGameBoard board, int row, int col) {
        if (row > 7 || col > 7 || row < 0 || col < 0) {
            return false;
        }
        ChessGamePiece enemyPiece =
                board.getCell(row, col).getPieceOnSquare() == null
                        ? null
                        : board.getCell(row, col).getPieceOnSquare();
        if (enemyPiece == null
                || generalMove.getColorOfPiece().getColor() == ChessGamePiece.UNASSIGNED
                || enemyPiece.getColorOfPiece().getColor() == ChessGamePiece.UNASSIGNED) {
            return false;
        }
        if (generalMove.getColorOfPiece().getColor() == ChessGamePiece.WHITE) {
            if (enemyPiece.getColorOfPiece().getColor() == ChessGamePiece.BLACK) {
                return true;
            } else {
                return false;
            }
        } else {
            if (enemyPiece.getColorOfPiece().getColor() == ChessGamePiece.WHITE) {
                return true;
            } else {
                return false;
            }
        }
    }
    
}
