package business.service.moves;

import java.util.ArrayList;

import gui.board.ChessGameBoard;
import util.IsEnemy;

public interface ICalculateMove {
	
	ArrayList<String> invoke(ChessGameBoard board, int numMoves, IsEnemy isEnemy);

}
