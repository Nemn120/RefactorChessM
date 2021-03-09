package Business.Service.Moves.Impl;

import Business.Service.Moves.ICalculateSouthEastMoves;
import util.IsEnemy;
import util.IsOnScreen;
import GUI.board.ChessGameBoard;

import java.util.ArrayList;

public class CalculateSouthEastMoves implements ICalculateSouthEastMoves {

    private int pieceRow;
    private int pieceColumn;

    public CalculateSouthEastMoves(int pieceRow, int pieceColumn) {
        this.pieceRow = pieceRow;
        this.pieceColumn = pieceColumn;
    }

    /**
     * Calculates and returns moves in the south-east direction relative to this
     * piece.
     *
     * @param board    the board to calculate the moves on
     * @param numMoves the number of moves to calculate
     * @return ArrayList<String> the moves in this direction
     */
    @Override
    public ArrayList<String> invoke(ChessGameBoard board, int numMoves, IsEnemy isEnemy) {
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if (IsOnScreen.invoke(pieceRow, pieceColumn)) {
            for (int i = 1; i < 8 && count < numMoves; i++) {
                if (IsOnScreen.invoke(pieceRow + i, pieceColumn + i)
                        && (board.getCell(pieceRow + i,
                        pieceColumn + i).getPieceOnSquare() == null)) {
                    moves.add((pieceRow + i) + "," + (pieceColumn + i));
                    count++;
                } else if (isEnemy.invoke(board, pieceRow + i, pieceColumn + i)) {
                    moves.add((pieceRow + i) + "," + (pieceColumn + i));
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
