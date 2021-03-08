package Business.Service.Moves;

import java.util.ArrayList;

import GUI.board.ChessGameBoard;

public interface ICalculateMove {
	
	public ArrayList<String> invoke(ChessGameBoard board, int numMoves, IsEnemy isEnemy);

}
