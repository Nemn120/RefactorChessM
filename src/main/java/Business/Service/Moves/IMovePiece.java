package Business.Service.Moves;

import GUI.board.ChessGameBoard;

public interface IMovePiece {
	
	boolean move(ChessGameBoard board, int row, int col);
	boolean canMove(ChessGameBoard board, int row, int col);

}
