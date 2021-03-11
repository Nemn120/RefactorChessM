package Business.Service.Moves;

import java.util.ArrayList;

import Business.Service.Moves.Impl.MovePiece;
import GUI.board.ChessGameBoard;

public interface IConfigurationPieceMove {
	
	void updatePossibleMoves(ChessGameBoard board);
	boolean testMoveForKingSafety(ChessGameBoard board, int row, int col);
	void showLegalMoves(ChessGameBoard board);
	boolean hasLegalMoves(ChessGameBoard board);
	ArrayList<MovePiece> getCurrentAttackers(ChessGameBoard board);

}
