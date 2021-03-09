package Business.pieces.move.impl;

import GUI.board.ChessGameBoard;

import java.util.ArrayList;

import Business.Service.Moves.IsEnemy;

public class DiagonalMoveImpl {

    // ----------------------------------------------------------

    private GeneralMove generalMove;
    private IsEnemy isEnemyService;

    public DiagonalMoveImpl(GeneralMove generalMove) {
        this.generalMove = generalMove;
    }

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
                if (generalMove.isOnScreen(generalMove.getPieceRow() + i, generalMove.getPieceColumn() - i)
                        && (board.getCell(generalMove.getPieceRow() + i,
                        generalMove.getPieceColumn() - i).getPieceOnSquare() == null)) {
                    moves.add((generalMove.getPieceRow() + i) + "," + (generalMove.getPieceColumn() - i));
                    count++;
                } else if (isEnemyService.isEnemy(board,generalMove.getPieceRow() + i, generalMove.getPieceColumn() - i)) {
                    moves.add((generalMove.getPieceRow() + i) + "," + (generalMove.getPieceColumn() - i));
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
