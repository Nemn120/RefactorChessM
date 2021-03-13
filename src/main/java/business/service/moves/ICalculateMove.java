package business.service.moves;

import java.util.ArrayList;

import GUI.board.ChessGameBoard;
import util.IsEnemy;

public interface ICalculateMove {
	
	ArrayList<String> invoke(ChessGameBoard board, int numMoves, IsEnemy isEnemy);

}
