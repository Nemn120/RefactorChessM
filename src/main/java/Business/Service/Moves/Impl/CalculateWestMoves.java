package Business.Service.Moves.Impl;

import Business.Service.Moves.ICalculateWestMoves;
import Business.Service.Moves.IsEnemy;
import Business.Service.Moves.IsOnScreen;
import GUI.board.ChessGameBoard;

import java.util.ArrayList;

public class CalculateWestMoves implements ICalculateWestMoves {

    private int pieceRow;
    private int pieceColumn;

    public CalculateWestMoves(int pieceRow, int pieceColumn) {
        this.pieceRow = pieceRow;
        this.pieceColumn = pieceColumn;
    }

    @Override
    public ArrayList<String> invoke(ChessGameBoard board, int numMoves, IsEnemy isEnemy) {
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if (IsOnScreen.invoke(pieceRow,pieceColumn)) {
            for (int i = pieceColumn - 1; i >= 0 && count < numMoves; i--) {
                if ((board.getCell(pieceRow, i).getPieceOnSquare()
                        == null || isEnemy.invoke(board, pieceRow, i))) {
                    moves.add(pieceRow + "," + i);
                    count++;
                    if (isEnemy.invoke(board, pieceRow, i)) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return moves;
    }
}
