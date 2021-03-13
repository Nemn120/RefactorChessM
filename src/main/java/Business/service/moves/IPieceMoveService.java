package Business.service.moves;

import Business.pieces.ChessGamePiece;
import Business.service.moves.pieces.PieceMove;
import GUI.board.ChessGameBoard;

import java.util.ArrayList;

public interface IPieceMoveService {

    boolean move(ChessGameBoard board, ChessGamePiece piece, int row, int col);

    boolean canMove(ChessGameBoard board, ChessGamePiece piece, int row, int col);

    boolean testMoveForKingSafety(ChessGameBoard board, ChessGamePiece piece, int row, int col);

    void showLegalMoves(ChessGameBoard board, ChessGamePiece piece);

    boolean hasLegalMoves(ChessGameBoard board, ChessGamePiece piece);

}


