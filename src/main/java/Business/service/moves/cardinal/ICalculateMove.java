package Business.service.moves.cardinal;

import java.util.ArrayList;

import GUI.board.ChessGameBoard;

public interface ICalculateMove {

	ArrayList<String> invoke(ChessGameBoard board, int numMoves);
}
