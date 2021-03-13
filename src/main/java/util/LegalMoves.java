package util;
import java.util.ArrayList;

import business.pieces.ChessGamePiece;
import gui.board.ChessGameBoard;

public class LegalMoves {
    public static boolean returnLegalMoves(ChessGamePiece piece, int pieceRow, int pieceColumn, ArrayList<String> possibleMoves, ChessGameBoard board){
        if (IsOnScreen.invoke(pieceRow, pieceColumn)) {
            for (String locStr : possibleMoves) {
                String[] currCoords = locStr.split(",");
                int row = Integer.parseInt(currCoords[0]);
                int col = Integer.parseInt(currCoords[1]);
                if (piece.canMove(board, row, col)) // only show legal moves
                {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
