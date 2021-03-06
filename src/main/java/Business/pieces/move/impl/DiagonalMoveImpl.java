package Business.pieces.move.impl;

import java.util.ArrayList;

import GUI.board.ChessGameBoard;

public class DiagonalMoveImpl {
	
	private GeneralMove generalMove;

	protected ArrayList<String> calculateNorthWestMoves(
            ChessGameBoard board,
            int numMoves) {
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if (generalMove.isPieceOnScreen()) {
            for (int i = 1; i < 8 && count < numMoves; i++) {
                if (generalMove.isOnScreen(generalMove.pieceRow - i, generalMove.pieceColumn - i)
                        && (board.getCell(generalMove.pieceRow - i,
                        		generalMove.pieceColumn - i).getPieceOnSquare() == null)) {
                    moves.add((generalMove.pieceRow - i) + "," + (generalMove.pieceColumn - i));
                    count++;
                } else if (isEnemy(board, generalMove.pieceRow - i, generalMove.pieceColumn - i)) {
                    moves.add((generalMove.pieceRow - i) + "," + (generalMove.pieceColumn - i));
                    count++;
                    break;
                } else {
                    break;
                }
            }
        }
        return moves;
    }
    // ----------------------------------------------------------

    /**
     * Calculates and returns moves in the north-east direction relative to this
     * piece.
     *
     * @param board    the board to calculate the moves on
     * @param numMoves the number of moves to calculate
     * @return ArrayList<String> the moves in this direction
     */
    protected ArrayList<String> calculateNorthEastMoves(
            ChessGameBoard board,
            int numMoves) {
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if (generalMove.isPieceOnScreen()) {
            for (int i = 1; i < 8 && count < numMoves; i++) {
                if (isOnScreen(generalMove.pieceRow - i, generalMove.pieceColumn + i)
                        && (board.getCell(generalMove.pieceRow - i,
                        generalMove.pieceColumn + i).getPieceOnSquare() == null)) {
                    moves.add((generalMove.pieceRow - i) + "," + (generalMove.pieceColumn + i));
                    count++;
                } else if (isEnemy(board, generalMove.pieceRow - i, generalMove.pieceColumn + i)) {
                    moves.add((generalMove.pieceRow - i) + "," + (generalMove.pieceColumn + i));
                    count++;
                    break;
                } else {
                    break;
                }
            }
        }
        return moves;
    }
    // ----------------------------------------------------------

    /**
     * Calculates and returns moves in the south-west direction relative to this
     * piece.
     *
     * @param board    the board to calculate the moves on
     * @param numMoves the number of moves to calculate
     * @return ArrayList<String> the moves in this direction
     */
    protected ArrayList<String> calculateSouthWestMoves(
            ChessGameBoard board,
            int numMoves) {
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if (generalMove.isPieceOnScreen()) {
            for (int i = 1; i < 8 && count < numMoves; i++) {
                if (isOnScreen(generalMove.pieceRow + i, generalMove.pieceColumn - i)
                        && (board.getCell(generalMove.pieceRow + i,
                        generalMove.pieceColumn - i).getPieceOnSquare() == null)) {
                    moves.add((generalMove.pieceRow + i) + "," + (generalMove.pieceColumn - i));
                    count++;
                } else if (isEnemy(board, generalMove.pieceRow + i, generalMove.pieceColumn - i)) {
                    moves.add((generalMove.pieceRow + i) + "," + (generalMove.pieceColumn - i));
                    count++;
                    break;
                } else {
                    break;
                }
            }
        }
        return moves;
    }
    // ----------------------------------------------------------

    /**
     * Calculates and returns moves in the south-east direction relative to this
     * piece.
     *
     * @param board    the board to calculate the moves on
     * @param numMoves the number of moves to calculate
     * @return ArrayList<String> the moves in this direction
     */
    protected ArrayList<String> calculateSouthEastMoves(
            ChessGameBoard board,
            int numMoves) {
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if (generalMove.isPieceOnScreen()) {
            for (int i = 1; i < 8 && count < numMoves; i++) {
                if (isOnScreen(generalMove.pieceRow + i, generalMove.pieceColumn + i)
                        && (board.getCell(generalMove.pieceRow + i,
                        generalMove.pieceColumn + i).getPieceOnSquare() == null)) {
                    moves.add((generalMove.pieceRow + i) + "," + (generalMove.pieceColumn + i));
                    count++;
                } else if (isEnemy(board, generalMove.pieceRow + i, generalMove.pieceColumn + i)) {
                    moves.add((generalMove.pieceRow + i) + "," + (generalMove.pieceColumn + i));
                    count++;
                    break;
                } else {
                    break;
                }
            }
        }
        return moves;
    }
	
	
}
