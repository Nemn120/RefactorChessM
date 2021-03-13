package business.service.moves.impl;

import business.service.moves.ICalculateSouthMoves;
import util.IsEnemy;
import util.IsOnScreen;
import GUI.board.ChessGameBoard;

import java.util.ArrayList;

public class CalculateSouthMoves implements ICalculateSouthMoves {

    private int pieceRow;
    private int pieceColumn;

    public CalculateSouthMoves(int pieceRow, int pieceColumn) {
        this.pieceRow = pieceRow;
        this.pieceColumn = pieceColumn;
    }

    @Override
    public ArrayList<String> invoke(ChessGameBoard board, int numMoves, IsEnemy isEnemy) {
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if (IsOnScreen.invoke(pieceRow, pieceColumn)) {
            for (int i = pieceRow + 1; i < 8 && count < numMoves; i++) {
                if ((board.getCell(i, pieceColumn).getPieceOnSquare()
                        == null || isEnemy.invoke(board, i, pieceColumn))) {
                    moves.add(i + "," + pieceColumn);
                    count++;
                    if (isEnemy.invoke(board, i, pieceColumn)) {
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
