package Business.service.moves.cardinal.Impl;

import Business.service.moves.cardinal.CalculateCardinalMove;
import Business.service.moves.cardinal.ICalculateMove;
import Business.pieces.ChessGamePiece;
import util.ColorOfPiece;
import util.IsEnemy;
import util.IsOnScreen;
import GUI.board.ChessGameBoard;

import java.util.ArrayList;

public class CalculateNorthWestMoves extends CalculateCardinalMove {

    public CalculateNorthWestMoves(int pieceRow, int pieceColumn, ColorOfPiece colorOfPiece) {
        super(pieceRow,pieceColumn,colorOfPiece);
    }
    /**
     * Calculates and returns moves in the north-west direction relative to this
     * piece.
     *
     * @param board    the board to calculate the moves on
     * @param numMoves the number of moves to calculate
     * @return ArrayList<String> the moves in this direction
     */
    @Override
    public ArrayList<String> invoke(ChessGameBoard board, int numMoves) {
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if (IsOnScreen.invoke(getPieceRow(),getPieceColumn())) {
            for (int i = 1; i < 8 && count < numMoves; i++) {
                if (IsOnScreen.invoke(getPieceRow() - i, getPieceColumn() - i)
                        && (board.getCell(getPieceRow() - i,
                        getPieceColumn() - i).getPieceOnSquare() == null)) {
                    moves.add((getPieceRow() - i) + "," + (getPieceColumn() - i));
                    count++;
                } else if (IsEnemy.invoke(board, getPieceRow() - i, getPieceColumn() - i,0)) {
                    moves.add((getPieceRow() - i) + "," + (getPieceColumn() - i));
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
