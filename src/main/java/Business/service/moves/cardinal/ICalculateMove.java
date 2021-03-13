package Business.service.moves.cardinal;

import java.util.ArrayList;

import Business.pieces.ChessGamePiece;
import GUI.board.ChessGameBoard;
import util.IsEnemy;

public interface ICalculateMove {

	ArrayList<String> invoke(ChessGameBoard board, int numMoves);
}
