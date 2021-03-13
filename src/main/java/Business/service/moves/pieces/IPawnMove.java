package Business.service.moves.pieces;

import Business.pieces.ChessGamePiece;
import GUI.board.ChessGameBoard;

import java.util.ArrayList;

public interface IPawnMove {

    ArrayList<String> calculatePossibleMoves(ChessGameBoard board, int row, int column, int color, boolean isNotMoved);
}